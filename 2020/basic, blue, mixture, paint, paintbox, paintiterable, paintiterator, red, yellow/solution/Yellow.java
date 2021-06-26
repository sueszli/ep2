import java.util.NoSuchElementException;
import java.util.Objects;

// A purely yellow paint. It is one of the basic colors for mixing other paints.
// 'Yellow' implements 'Basic'.
public class Yellow implements Basic {
    // only one instance is needed.
    public static final Yellow YELLOW = new Yellow();

    @Override
    public PaintIterator iterator() {
        return new BasicIter(YELLOW);
    }

    @Override
    public Paint mixWith(Paint paint) {
        return new Mixture(this, paint);
    }

    @Override
    public boolean equals(Object obj) {
        if (YELLOW == obj || this.getClass() == obj.getClass()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash("Yellow");
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}