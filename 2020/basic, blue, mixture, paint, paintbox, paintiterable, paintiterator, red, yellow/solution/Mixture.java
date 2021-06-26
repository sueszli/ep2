import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

// A painting color that is a mixture of at least two colors.
// 'Mixture' implements 'Paint'.
//
public class Mixture implements Paint {
    private final Paint left;
    private final Paint right;

    // Initializes this object.
    public Mixture(Paint p1, Paint p2) {
        this.left = p1;
        this.right = p2;
    }

    public Paint getLeft() {
        return left;
    }

    public Paint getRight() {
        return right;
    }

    @Override
    public PaintIterator iterator() {
        return new MixtureIter(this);
    }

    @Override
    public Paint mixWith(Paint paint) {
        return new Mixture(this, paint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mixture basics = (Mixture) o;
        return left.equals(basics.left) && right.equals(basics.right);
    }

    @Override
    public int hashCode() {
        return left.hashCode() + right.hashCode();
    }

    @Override
    public String toString() {
        return left.toString() + ", " + right.toString();
    }

    class MixtureIter implements PaintIterator {
        PaintIterator lIter;
        PaintIterator rIter;

        public MixtureIter(Mixture m) {
            this.lIter = m.getLeft().iterator();
            this.rIter = m.getRight().iterator();
        }

        @Override
        public boolean hasNext() {
            return lIter.hasNext() || rIter.hasNext();
        }

        @Override
        public Basic next() {
            if (!hasNext()) throw new NoSuchElementException("Called next() although hasNext() was false in MixtureIter.");
            if (lIter.hasNext()){
                return lIter.next();
            }else { //one of them must be true
                return rIter.next();
            }
        }
    }
}