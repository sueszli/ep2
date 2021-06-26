import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

// A purely red paint. It is one of the basic colors for mixing other paints.
//
public class Red implements Basic {

    // only one instance is needed.
    public static final Red RED = new Red();

    @Override
    public PaintIterator iterator() {
        return new BasicIter(RED);
    }

    @Override
    public Paint mixWith(Paint paint) {
        return new Mixture(this, paint);
    }

    @Override
    public boolean equals(Object obj) {
        if (RED == obj || this.getClass() == obj.getClass()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash("Red");
    }

    @Override
    public String toString() {
        return "Red";
    }

}
