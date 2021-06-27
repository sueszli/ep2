import java.util.*;

// This class implements 'Set' and represents an interval of Integer numbers, specified by the lower and
// upper number of the interval.
public class Interval implements Set {
    // Initializes this 'Interval' with the bounds of the interval.
    public Interval(int lower, int upper) {
    }

    @Override
    public boolean isContinuous() {
        return false;
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
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}

