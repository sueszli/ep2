import java.util.*;

// This class implements 'Set' and represents an interval of Integer numbers, specified by the lower and
// upper number of the interval.
public class Interval implements Set {
    private final int lower;
    private final int upper;

    // Initializes this 'Interval' with the bounds of the interval.
    public Interval(int lower, int upper) {
        assert lower <= upper;
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public boolean isContinuous() {
        return true;
    }

    // Returns the union of 'this' and 'other'. If the result can be represented by a single
    // interval (i.e., 'this' and 'other' are connected), the result
    // is of type 'Interval', otherwise it is a 'Union'.
    // Examples:
    // The union of 0-5 and 3-8 is 0-8  (type 'Interval'),
    // the union of 0-5 and 6-7 is 0-7  (type 'Interval'),
    // the union of 0-5 and 7-8 is [0-5, 7-8] (type 'Union').
    @Override
    public Set union(Interval other) {
        if (!isConnected(other)) return new Union(this,other);
        return new Interval(Math.min(this.lower, other.lower), Math.max(this.upper, other.upper));
    }

    public boolean isConnected(Interval other){
        return !(this.upper < other.lower-1 || other.upper < this.lower-1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int p = lower;

            public boolean hasNext() { return p <= upper; }

            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("No element!");
                return p++;
            }
        };
    }

    @Override
    public String toString() { return lower + "-" + upper; }
}