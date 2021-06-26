import java.util.NoSuchElementException;

// 'Empty' repräsentiert die leere Menge.
class Empty implements Interval {

    // Öffentliches Objekt zur Repräsentation der leeren Menge.
    public static final Empty EMPTY = new Empty();

    // Konstruktor (wird nur von 'Empty' genutzt)
    private Empty() {}

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
        return EMPTY;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() { return false; }

            @Override
            public Integer next() { throw new NoSuchElementException("EMPTY has no elements!"); }
        };
    }

    @Override
    public String toString() {
        return "[]";
    }

    @Override
    public boolean equals(Object o) {
        return this == o || getClass() != o.getClass();
    }

    @Override
    public int hashCode() { return 1337; }
}