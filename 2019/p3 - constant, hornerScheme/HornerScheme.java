import java.util.*;

// The class implements 'Polynomial' and represents the form (a + x*p), where 'a' is an Integer
// and 'p' is another polynomial. 'p' must not be 'null' (objects of 'Constant' shall be used to represent constants).
// This class implements 'Polynomial' by using Horner's scheme.
// Example:
// a₀ + a₁*x + a₂*x² + a₃*x³ + a₄*x⁴
// The polynomial above is represented in Horner's scheme as:
// a₀ + x*(a₁ + x*(a₂ + x*(a₃ + x*a₄)))
//
public class HornerScheme /* TODO: fix declaration. */ {

    //TODO: define missing parts of this class.

    // Initializes this object.
    // Precondition: 'p' must not be 'null'.
    public HornerScheme(int a, Polynomial p) {
        //TODO: implement this constructor.
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        //TODO: implement this method.
        return null;
    }

}



