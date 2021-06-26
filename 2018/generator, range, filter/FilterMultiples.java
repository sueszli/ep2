// Ein 'FilterMultiples'-Objekt erzeugt aus einer Datenquelle 'source' eine gefilterte Zahlenfolge.
// Alle Zahlen, die durch 'div' teilbar sind, sind nicht Teil der gefilterten Folge.
// Alle übrigen Zahlen von 'source' sind Teil der gefilterten Folge.
// hasNext() und next() beziehen sich auf die gefilterte Folge.
class FilterMultiples implements FilteredGenerator {
    //TODO: Fehlende Teile der Klasse implementieren
    public FilterMultiples(Generator source, int div) {
    }

    @Override
    public boolean pass(int i) {
        return false;
    }
    
    @Override
    public FilteredGenerator copy() {
        return null;
    }
    
    @Override
    public boolean hasNext() {
        return false;
    }
    
    @Override
    public Integer next() {
        return null;
    }
}