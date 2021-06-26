// A polynomial is a sum of multiple monomials , such as 3*x^1 + -1*x^2 + 1*x^5.
// 'Polynomial' uses a sorted linked list to store its monomials.
// A specific degree exists at most once in the polynomial.
public class Polynomial {
    private LLNode root;

    // Adds the monomial 'm' to this polynomial.
    // If the polynomial already has a monomial of the same degree, the corresponding monomial
    // is replaced by its sum with 'm' (which is a new Monomial of the same degree and a
    // coefficient corresponding to the sum of the coefficients).
    public void add(Monomial m) {
        if (root == null){
            root = new LLNode(m, null);
        }else {
            if (root.getDegree() > m.getDegree()) root = new LLNode(m, root);
            else root.nodeAdd(m);
        }
    }

    // Returns a new polynomial which is the product of 'this' and 'm', i.e. in which
    // each monomial of 'this' has been multiplied by 'm'. Calling this method does not
    // affect 'this'.
    public Polynomial mult(Monomial m) {
        Polynomial p = new Polynomial();
        if (root == null) {
            p.add(m);
        } else {
            root.nodeCopyAndMult(p, m);
        }
        return p;
    }

    // Returns a polynomial representation in mathematical notation such as
    // "2*x^0 + 6*x^2 + -2*x^3", where monomials are ordered ascending according to
    // their degree. Note that a positive sign of the leftmost coefficient is
    // not shown.
    // Returns the string "0" if the polynomial has no monomials (is empty).
    public String toString() {
        if (root == null) return "0";
        return root.toString();
    }

    class LLNode {
        private Monomial val;
        private LLNode next;

        public LLNode(Monomial val, LLNode next) {
            this.val = val;
            this.next = next;
        }

        public int getDegree(){
            return val.getDegree();
        }

        public void nodeAdd(Monomial m){
            int thisDeg = val.getDegree();
            int thatDeg = m.getDegree();
            if (thisDeg == thatDeg){
                val = new Monomial(val.getCoeff() + m.getCoeff(), thisDeg);
            } else {
                if (next == null){
                    next = new LLNode(m, null);
                } else {
                    if (next.getDegree() > thatDeg) next = new LLNode(m, next);
                    else next.nodeAdd(m);
                }
            }
        }

        public void nodeCopyAndMult(Polynomial dst, Monomial factor){
            Monomial mon = new Monomial(val.getCoeff(), val.getDegree());
            dst.add(mon.mult(factor));
            if (next != null) next.nodeCopyAndMult(dst, factor);
        }

        @Override
        public String toString() {
            return val.toString() + (next == null ? "" : " + " + next.toString());
        }
    }
}