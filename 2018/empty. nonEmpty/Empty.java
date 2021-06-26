// 'Empty' repräsentiert die leere Menge.
class Empty implements Interval {

    // Öffentliches Objekt zur Repräsentation der leeren Menge.
    public static final Empty EMPTY = new Empty();

    // Konstruktor (wird nur von 'Empty' genutzt)
    private Empty() {

    }

    public String toString(){
        return "";
    }

    @Override
    public boolean contains(Integer n) {
        return false;
    }

    @Override
    public boolean containsAll(Interval iv) {
        return false;
    }

    @Override
    public Interval intersect(Interval iv) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    //TODO: Fehlende Teile der Klasse implementieren

}