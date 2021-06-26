// Diese Klasse repräsentiert eine positive ganze Zahl mit maximal 8 Stellen
// im Dezimalsystem.
class Number {
    public final static int nDigits = 8; // Anzahl der Stellen
    private int[] digits = new int [nDigits];

    // Initialisiert dieses Objekt mit dem Wert 'n'.
    // Es gilt: 0 <= n && n < Math.pow(10,nDigits).
    public Number (int n) {
        //converts int to int[]
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n/10;
            if (n == 0) return;
        }
    }

    // Initialisiert dieses Objekt mit dem gleichen Wert wie 'n'.
    public Number (Number n) {
        this.digits = n.digits;
    }

    // Liefert eine lesbare Respräsentation dieses Objekts.
    public String toString() {
        String output =  "";
        for (int i = nonZeroStart(); i < digits.length; i++){
            output += digits[i];
        }
        return output;
    }

    private int nonZeroStart(){
        //get index from which we have a non zero digit
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) return i;
        }
        return 0;
    }

    public String toString2(){
        //does not skip zeros
        String output = "";
        for (int digit : digits) output += digit;
        return output;
    }

    // Liefert die Ziffer an der Stelle pos.
    // Es gilt: 0 <= pos && pos < nDigits.
    public int getDigit(int pos) {
        //1. Stelle = kleinster Wert
        return digits[digits.length-pos];
    }

    // Ersetzt die Ziffer an der Stelle 'pos' durch die Ziffer 'd'.
    // Es gilt: 0 <= pos && pos < nDigits und 0 <= d && d <= 9.
    public void setDigit(int pos, int d) {
        digits[digits.length-pos] = d;
    }

    // Inkrementiert die durch dieses Objekt dargestellte Zahl. Wird dabei der Wertebereich überschritten,
    // das heißt, die Zahl bekommt dadurch mehr als 8 Stellen, werden vom Ergebnis nur die ersten 8 (niederwertigsten)
    // Stellen gespeichert und durch den zurückgegebenen Wert 'true' wird signalisiert, dass es einen Überlauf
    // gegeben hat. Ohne Überlauf wird 'false' zurückgegeben.
    public boolean increment() {
        //int[] -> int
        int val = Integer.parseInt(this.toString());
        val++;

        //check if overflow occurred
        if (val >= Math.pow(10,nDigits)){
            digits = new int[nDigits]; //0000 0000
            return true;

        } else {
            //int -> int[]
            for (int i = digits.length - 1; i >= 0 && val != 0; i--) {
                digits[i] = val % 10;
                val = val/10;
            }
            return false;
        }
    }
}
