// This class represents monomials of the form a*x^d ("a mal x hoch d"), where
// 'a' is the coefficient of the monomial and 'd' is the degree.
public class Monomial {
    private int coeff;
    private int degree;

    // A constructor with the coefficient 'coeff' and the 'degree' of this monomial.
    public Monomial(int coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    public int getCoeff() {
        return coeff;
    }

    public int getDegree() {
        return degree;
    }

    // Copy-constructor: uses 'coeff' and 'degree' of 'm' to initialize this monomial.
    public Monomial(Monomial m) {
        this.coeff = m.coeff;
        this.degree = m.degree;
    }

    // Adds the monomial 'm' to this monomial, if both monomials have the same degree.
    // In this case this monomial's coefficient is replaced by the sum of this monomial's
    // coefficient and the coefficient of 'm'. In this case the method returns 'true'.
    // If 'm' has not the same degree as 'this', the method has no effect and
    // returns 'false'.
    public boolean combine(Monomial m) {
        if (this.degree == m.degree){
            this.coeff = this.coeff + m.coeff;
            return true;
        }
        return false;
    }

    // Returns 'true' if 'm' has a higher degree than 'this', and 'false' otherwise.
    public boolean lowerDegreeThan(Monomial m) {
        return m.degree > this.degree;
    }

    // Returns the value of the monomial for a specified value of 'x'
    public int eval(int x) {
        return (int) (coeff * (Math.pow(x, degree)));
    }

    // Returns a representation in mathematical notation, e.g. of the form "5*x^2".
    public String toString() {
        return coeff + "*x^" + degree;
    }
}




