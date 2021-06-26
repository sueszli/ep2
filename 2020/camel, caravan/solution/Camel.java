import java.util.Objects;

// This class represents a camel (animal). A camel walks at a maximum pace (speed)
// and carries a load. Load slows down the camel.
//
public class Camel {
    private int load;
    private int maxPace;

    // A constructor with the 'load' this camel carries
    // and the maximum pace ('maxPace') of this camel.
    // Preconditions: load >= 0 && maxPace > 0 (need not be checked).
    public Camel(int load, int maxPace) {
        this.load = load;
        this.maxPace = maxPace;
    }

    // Returns the pace of this camel, which corresponds to its
    // maximum pace minus its load. If the load is greater than the maximum pace
    // the pace is 0.
    public int pace() {
        int diff = maxPace - load;
        return Math.max(diff, 0);
    }

    // Adds 'addLoad' to the load of this camel. A negative 'addLoad' corresponds to
    // reducing this camels load.
    public void changeLoad(int addLoad) {
        this.load = load + addLoad;
    }

    // Returns a representation of this camel, with current pace, maximum pace in parentheses and load.
    // Example: 1 (3) 2
    public String toString() {
        return pace() + " (" + maxPace + ") " + load;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camel camel = (Camel) o;
        return load == camel.load && maxPace == camel.maxPace;
    }
}