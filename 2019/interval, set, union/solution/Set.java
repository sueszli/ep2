import java.util.*;

// Do not change this interface definition.
//
// 'Set' is an interface for sets of Integer numbers. There are no duplicates
// in the set.
// See examples in class 'PraxisApplication'.
//
public interface Set extends Iterable<Integer> {

    // Returns 'true' only if the set is a single interval of Integer numbers.
    // Examples:
    // The set [0-5, 7-8] is not continuous (multiple unconnected intervals),
    // the set 0-8 is continuous (single interval),
    // the set [0-5, 7-10, 12-15] is not continuous.
    boolean isContinuous();

    // Returns the union of 'this' and 'other'.
    // Examples:
    // The union of 0-5 and 3-8 is 0-8,
    // the union of 0-5 and 6-7 is 0-7,
    // the union of 0-5 and 7-8 is [0-5, 7-8].
    // See further examples in 'PraxisApplication'.
    Set union(Interval other); //other != null

    // Returns an iterator over all Integer numbers of the set. There is no specified order.
    Iterator<Integer> iterator();

    // Returns a string representation of this set, with information
    // about which numbers are in this set.
    // Examples:
    // "[0-5, 7-10, 12-15]"
    // "0-8" (single intervals are represented without brackets).
    // See further examples in class 'PraxisApplication'.
    String toString();
}

