// This class represents a polynomial. A polynomial is a sum of multiple monomials (class 'Monomial'),
// such as 3*x^1 + -1*x^2 + 1*x^5.
// 'Polynomial' uses a binary search tree to store its monomials. The degree of the monomial is the key.
// A specific degree exists at most once in the polynomial.
public class Polynomial {
    private Node root;

    // Initializes this polynomial with multiple monomials. The coefficients of the monomials are
    // specified by 'coeffs', where coeffs[i] is the coefficient of the monomial of degree i.
    // Entries with value 0 are ignored, i.e. corresponding monomials are not stored in the polynomial.
    public Polynomial(int[] coeffs) {
        for (int i = 0; i < coeffs.length; i++) {
            this.add(coeffs[i], i);
        }
    }

    public void add(Monomial mon){
        this.add(mon.getCoeff(), mon.getDegree());
    }

    // Adds the monomial specified by 'coeff' and 'degree' to this polynomial, if coeff != 0,
    // otherwise 'add' has no effect.
    // If this polynomial already has a monomial of the same degree, no new monomial is added, instead
    // the coefficient of the monomial is modified accordingly ('combine' is called).
    public void add(int coeff, int degree) {
        if (coeff == 0) return;
        Monomial mon = new Monomial(coeff, degree);
        if (root == null) root = new Node(mon);
        else root.nodeAdd(mon);
    }

    // Adds all monomials of 'p' to this polynomial.
    // (The rules of 'add(int,int)' apply for each monomial to be added.)
    public void add(Polynomial p) {
        if (p.root == null || this.root == null) return;
        p.root.nodeAddTo(this);
    }

    // Returns the value of the polynomial for a specified value of 'x'
    public int eval(int x) {
        if (root == null) return 0;
        return root.nodeEval(x);
    }

    // Returns a polynomial representation in mathematical notation such as
    // "2*x^0 + 6*x^2 + -2*x^3", where monomials are ordered ascending according to
    // their degree. Note that a positive sign of the leftmost coefficient is
    // not shown.
    // Returns the string "0" if the polynomial has no monomials (is empty).
    public String toString() {
        if (root == null) return "0";
        return root.nodeToString();
    }

    class Node {
        private Monomial val;
        private Node left, right;

        public Node(Monomial val){
            this.val = val;
        }

        public Node(Monomial val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void nodeAdd(Monomial mon){ //L <= N < R
            if (this.val.combine(mon)) return;
            if (this.val.lowerDegreeThan(mon)) {
                if (right != null) right.nodeAdd(mon);
                else right = new Node(mon);
            } else {
                if (left != null) left.nodeAdd(mon);
                else left = new Node(mon);
            }
        }

        public void nodeAddTo(Polynomial dst){
            dst.add(val);
            if (left != null) left.nodeAddTo(dst);
            if (right != null) right.nodeAddTo(dst);
        }

        public int nodeEval(int x){
            return val.eval(x) + (left != null ? left.nodeEval(x) : 0) + (right != null ? right.nodeEval(x) : 0);
        }

        public String nodeToString(){
            return (left != null ? left.nodeToString() + " + " : "") + val.toString() +
                    (right != null ? " + " + right.nodeToString() : "");
        }
    }
}

