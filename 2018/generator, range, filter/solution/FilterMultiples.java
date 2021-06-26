import java.util.NoSuchElementException;

// Ein 'FilterMultiples'-Objekt erzeugt aus einer Datenquelle 'source' eine gefilterte Zahlenfolge.
// Alle Zahlen, die durch 'div' teilbar sind, sind nicht Teil der gefilterten Folge.
// Alle übrigen Zahlen von 'source' sind Teil der gefilterten Folge.
// hasNext() und next() beziehen sich auf die gefilterte Folge.
class FilterMultiples implements FilteredGenerator {
    private final Generator iter;
    private final int div;

    private int storedNum;
    private boolean exists;

    public FilterMultiples(Generator source, int div) {
        this.iter = source;
        this.div = div;
    }

    @Override
    public boolean pass(int i) {
        return i % div != 0;
    }

    @Override
    public FilteredGenerator copy() {
        return new FilterMultiples(iter.copy(), div);
    }

    @Override
    public boolean hasNext() {
        while(iter.hasNext() && !exists) {
            storedNum = iter.next();
            if(pass(storedNum)) {
                exists = true;
            }
        }
        return exists;
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException("FilterMultiples has no more numbers!");
        exists = false;
        return storedNum;
    }
}
