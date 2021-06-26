// 'NonEmpty' repräsentiert eine aufsteigend iterierbare Menge von aufeinander folgenden ganzen Zahlen,
// die mindestens eine Zahl enthält. 'NonEmpty' wird durch Untergrenze 'lower' und Obergenze 'upper'
// des Intervalls bestimmt.
class NonEmpty implements Interval {

    public NonEmpty(Integer lower, Integer upper){

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
}
