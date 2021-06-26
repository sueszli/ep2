import java.util.NoSuchElementException;
import java.util.Objects;

// 'NonEmpty' repräsentiert eine aufsteigend iterierbare Menge von aufeinander folgenden ganzen Zahlen,
// die mindestens eine Zahl enthält. 'NonEmpty' wird durch Untergrenze 'lower' und Obergenze 'upper'
// des Intervalls bestimmt.
class NonEmpty implements Interval {
    private int lower;
    private int upper;

    public NonEmpty(int lower, int upper) {
        if (lower > upper) throw new IllegalArgumentException("lower (" + lower + ") must not be greater than upper (" + upper + ")!");
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public boolean contains(Integer n) {
        return lower <= n && n <= upper;
    }

    @Override
    public boolean containsAll(Interval iv) { //check if this interval contains everything from iv
        if (isEmpty()) return true;
        NonEmpty ne = (NonEmpty) iv;
        return this.lower <= ne.lower && this.upper >= ne.upper;
    }

    @Override
    public Interval intersect(Interval iv) {
        if (iv.isEmpty()) {
            return Empty.EMPTY;
        } else {
            NonEmpty ne = (NonEmpty) iv;
            if (ne.lower > this.upper || ne.upper < this.lower) return Empty.EMPTY;
            return new NonEmpty(Math.max(this.lower, ne.lower), Math.min(this.upper, ne.upper));
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        int temp = upper;
        return new Iterator() {
            private int p; //pointer
            private int u = temp;

            @Override
            public boolean hasNext() {
                return p <= upper;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("no such element!");
                return p++;
            }
        };
    }

    @Override
    public String toString() {
        return "[" + lower + ", " + upper + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonEmpty integers = (NonEmpty) o;
        return lower == integers.lower && upper == integers.upper;
    }

    @Override
    public int hashCode() {
        return lower*31 + upper*13;
    }
}