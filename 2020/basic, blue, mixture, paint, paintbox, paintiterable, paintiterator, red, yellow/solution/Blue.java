import java.util.NoSuchElementException;
import java.util.Objects;

// A purely blue paint. It is one of the basic colors for mixing other paints.
// 'Blue' implements 'Basic'.
//
public class Blue implements Basic {

    // only one instance is needed.
    public static final Blue BLUE = new Blue();

    @Override
    public PaintIterator iterator() {
        return new BasicIter(BLUE);
    }

    @Override
    public Paint mixWith(Paint paint) {
        return new Mixture(this, paint);
    }

    @Override
    public boolean equals(Object obj) {
        return BLUE == obj || this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash("Blue");
    }

    @Override
    public String toString() {
        return "Blue";
    }

}
