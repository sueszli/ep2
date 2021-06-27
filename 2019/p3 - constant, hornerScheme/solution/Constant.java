import java.util.*;

// 'Constant' implements 'Polynomial' and represents a polynomial with degree 0 corresponding
// to a constant value (regardless of the 'x' used for evaluation).
// 'Constant' is used by class 'HornerScheme'.
// The iterator of this class iterates over only one value and therefore behaves as follows:
// The 'next' method returns the constant value, if it is called for the first time.
// 'hasNext' is 'true' only if 'next' has not been called.
//
public class Constant implements Polynomial {
    private final int c;

    // Initializes this object.
    // Precondition: c != 0.
    public Constant(int c) {
        this.c = c;
    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public List<Integer> coefficients() {
        return new ArrayList<>(c);
    }

    @Override
    public double eval(double x) {
        return c;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private boolean called;

            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("no coefficient!");
                called = true;
                return c;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant integers = (Constant) o;
        return c == integers.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }

    @Override
    public String toString() {
        return ""+c;
    }
}


