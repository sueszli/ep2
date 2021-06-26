// This class represents monomials of the form a*x^d ("a mal x hoch d"), where
// 'a' is the coefficient of the monomial and 'd' is the degree.
//
public class Monomial {
    private int coeff;
    private int degree;

    // A constructor with the coefficient 'coeff' and the 'degree' of this monomial.
    public Monomial(int coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;    }

    // Returns the product of 'this' and 'm'. The product is obtained by
    // multiplying the two coefficients and adding the two exponents.
    // 'this' and 'm' are not affected by calling this method.
    public Monomial mult(Monomial m) {
        return new Monomial(this.coeff * m.coeff, this.degree + m.degree);
    }

    // Returns the coefficient of this monomial.
    public int getCoeff() {
        return coeff;
    }

    // Returns the degree of this monomial.
    public int getDegree() {
        return degree;
    }

    // Returns a representation in mathematical notation, e.g. of the form "5*x^2".
    public String toString() {
        return coeff + "*x^" + degree;
    }


}




