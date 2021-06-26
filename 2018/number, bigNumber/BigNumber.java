// Die Klasse 'BigNumber' repräsentiert eine positive ganze Zahl mit beliebigem Betrag. Der Wertebereich beginnt
// bei 0 und kann sowohl Integer.MAX_VALUE als auch Long.MAX_VALUE überschreiten, ohne dass die Funktionalität
// beeinträchtigt wird. Dies wird dadurch erreicht, dass BigNumber intern eine verkette Liste von 'Number'-Objekten
// verwendet. z.B. wird 750000456123456789 dargestellt durch drei Knoten 23456789 -> 4561 -> 75 -> null.
class BigNumber {
    // Konstruktor: Initialisiert dieses Objekt mit 'n'.
    public BigNumber(long n) {
    }

    // Inkrementiert die Zahl.
    public void increment(){
        //TODO: Methode implementieren
    }
    
    // Ersetzt die Ziffer an der Stelle 'pos' durch die Ziffer 'd'.
    // Es gilt: pos >= 0 und 0 <= d && d <= 9.
    public void setDigit(int pos, int d) {
        //TODO: Methode implementieren
    }
    
    // Konstruktor: Initialisiert dieses Objekt mit der Zahl, die als String angegeben wird.
    // 's' sei ein String, der ausschließlich Ziffern enthält.
    public BigNumber(String s) {
        //TODO: Konstruktor implementieren
    }
    
    // Liefert eine lesbare Repräsentation des Objekts (siehe Beispiele in 'main').
    public String toString() {
        //TODO: Methode implementieren
        return "";
    }
    
    //TODO: Verkettete Liste implementieren (entweder in BigNumber oder außerhalb).
    //TODO: Diese verkettete Liste soll von BigNumber zur Speicherung von Zifferngruppen benutzt werden.
    //TODO: (Ein Knoten soll 8 Ziffern speichern.)
    }
