import java.util.Iterator;
import java.util.List;

// Do not change this interface definition.
//
// Represents a polynomial of the form a₀ + a₁*x + a₂*x² + ... + a𝘥*xᵈ,
// where d is the degree of the polynomial. Coefficients are Integers.
// The Iterator of a Polynomial iterates over the coefficients
// in the order a₀, a₁, a₂, ... a𝘥.
// See examples in class 'PraxisApplication'.
//
public interface Polynomial extends Iterable<Integer> {

    // Returns the degree of the polynomial.
    int degree();

    // Returns a list with all coefficients aᵢ of this polynomial,
    // starting with a₀, followed by a₁, a₂, ... a𝘥.
    List<Integer> coefficients();

    // Returns the value of this polynomial evaluated with the specified 'x'.
    double eval(double x);

    // Returns an iterator over the coefficients in the order a₀, a₁, a₂, ... ,a𝘥.
    // The 'next' method throws a 'java.util.NoSuchElementException' if the iteration
    // has no more coefficient (a𝘥 has already been returned).
    Iterator<Integer> iterator();

    // Returns 'true' if 'this' and 'o' represent the same polynomial (mathematically).
    boolean equals(Object o);

    // Returns the hashCode of the Polynomial.
    int hashCode();

    // Returns a string representation of the polynomial. The representation should resemble
    // a mathematical form describing the polynomial, with at least all non-zero coefficients,
    // the variable 'x' and all involved arithmetic operations.
    // Examples of different valid representations of the same polynomial:
    //      "(3 + x*(-2 + x*(0 + x*(7 + x*5))))" (Horner's scheme)
    //      "3*x^0 + -2*x^1 + 0*x^2 + 7*x^3 + 5*x^4" (List of monomials)
    String toString();

}

