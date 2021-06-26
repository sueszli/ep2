import java.util.NoSuchElementException;
import java.util.Objects;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight, that can not be changed after
// initialisation.
//
public class Star implements Mobile{
    private final int weight;

    public Star(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public MobileIterator iterator() {
        Star out = this;
        return new MobileIterator() {
            private boolean called;

            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Star next() {
                if (!hasNext()) throw new NoSuchElementException("No such element!");
                called = true;
                return out;
            }
        };
    }

    @Override
    public String toString() {
        return "*" + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return weight == star.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
