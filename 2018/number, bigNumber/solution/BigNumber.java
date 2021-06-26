import java.math.BigInteger;

// Die Klasse 'BigNumber' repräsentiert eine positive ganze Zahl mit beliebigem Betrag. Der Wertebereich beginnt
// bei 0 und kann sowohl Integer.MAX_VALUE als auch Long.MAX_VALUE überschreiten, ohne dass die Funktionalität
// beeinträchtigt wird. Dies wird dadurch erreicht, dass BigNumber intern eine verkette Liste von 'Number'-Objekten
// verwendet. z.B. wird 00000075-00004561-23456789 dargestellt durch drei Knoten 23456789 -> 4561 -> 75 -> null.
class BigNumber {
    private LLNode root; //never null
    private static int e = 1_0000_0000;

    // Konstruktor: Initialisiert dieses Objekt mit 'n'.
    public BigNumber(long n) {
        while (n != 0){
            add(n % e);
            n = n / e;
        }
    }

    // Konstruktor: Initialisiert dieses Objekt mit der Zahl, die als String angegeben wird.
    // 's' sei ein String, der ausschließlich Ziffern enthält.
    public BigNumber(String s) {
        //split up in pieces with 8 digits, add each one of them
        while (!s.isEmpty()) {
            if (s.length() >= 8){
                long addMe = Long.parseLong(s.substring(s.length()-8));
                add(addMe);
                s = s.substring(0, s.length()-8);
            } else {
                long addMe = Long.parseLong(s);
                add(addMe);
                s = "";
            }
        }
    }

    private void add(long n){
        Number num = new Number((int) n);
        if (root == null) root = new LLNode(num, null);
        else root.nodeAdd(num);
    }

    // Inkrementiert die Zahl.
    public void increment(){
        root.nodeIncrement();
    }

    // Ersetzt die Ziffer an der Stelle 'pos' durch die Ziffer 'd'.
    // Es gilt: pos >= 0 und 0 <= d && d <= 9.
    public void setDigit(int pos, int d) {
        int node_i = pos / 8; //node that should change
        int num_i = pos % 8; //index in node that should change
        LLNode p = root;
        for (int i = 0; i < node_i; i++){
            if (p.next == null) p.next = new LLNode(new Number(0), null);
            p = p.next;
        }
        p.val.setDigit(num_i, d);
    }

    // Liefert eine lesbare Repräsentation des Objekts (siehe Beispiele in 'main').
    public String toString() {
        return root.toString();
    }

    class LLNode{
        private Number val;
        private LLNode next;

        public LLNode(Number val, LLNode next) {
            this.val = val;
            this.next = next;
        }

        public void nodeAdd(Number val){
            if (next != null) next.nodeAdd(val);
            else next = new LLNode(val, null);
        }

        public void nodeIncrement(){
            boolean overFlow = val.increment();
            if (overFlow){
                if (next == null) next = new LLNode(new Number(1), null);
                else next.nodeIncrement();
            }
        }

        @Override
        public String toString() {
            if (next == null) return val.toString();
            else return next.toString() + this.val.toString2();
        }
    }
}