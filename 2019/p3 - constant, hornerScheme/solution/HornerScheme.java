import java.util.*;

// The class implements 'Polynomial' and represents the form (a + x*p), where 'a' is an Integer
// and 'p' is another polynomial. 'p' must not be 'null' (objects of 'Constant' shall be used to represent constants).
// This class implements 'Polynomial' by using Horner's scheme.
// Example:
// a₀ + a₁*x + a₂*x² + a₃*x³ + a₄*x⁴
// The polynomial above is represented in Horner's scheme as:
// a₀ + x*(a₁ + x*(a₂ + x*(a₃ + x*a₄)))
//
public class HornerScheme implements Polynomial {
    private final int val;
    private final Polynomial next;

    // Initializes this object.
    // Precondition: 'p' must not be 'null'.
    public HornerScheme(int a, Polynomial p) {
        this.val = a;
        this.next = p;
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        Polynomial sum = new Constant(coeffs[coeffs.length-1]);
        for (int i = coeffs.length-2; i >= 0 ; i--) {
            sum = new HornerScheme(coeffs[i], sum);
        }
        return sum;
    }

    @Override
    public int degree() {
        return 1 + next.degree();
    }

    @Override
    public List<Integer> coefficients() {
        ArrayList<Integer> cs = new ArrayList<>(val);
        cs.addAll(next.coefficients());
        return cs;
    }

    @Override
    public double eval(double x) {
        return val + x * next.eval(x);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private boolean called;
            private final Iterator<Integer> nextIter = next.iterator();

            @Override
            public boolean hasNext() { return !called || nextIter.hasNext(); }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("no coefficient!");
                if (!called) {
                    called = true;
                    return val;
                }
                return nextIter.next();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HornerScheme integers = (HornerScheme) o;
        return val == integers.val && Objects.equals(next, integers.next);
    }

    @Override
    public int hashCode() { return Objects.hash(val, next); }

    @Override
    public String toString() { return "(" + val + " + x*" + next.toString() + ")"; }
}



