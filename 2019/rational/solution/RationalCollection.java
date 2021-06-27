// This class represents a sorted collection of elements of type 'Rational'.
// The elements are sorted with respect to their value.
// 'RationalCollection' uses a binary search tree for storing elements.
// For simplicity it is assumed that rounding errors do not matter; don't worry about them.
// Duplicate elements (entries) can occur in the collection.
public class RationalCollection {
    private Node root;

    // Adds the specified Rational 'r' to this set.
    // Preconditions: r != null and r is not NaN (need not be checked).
    public void add(Rational r) {
        if (root == null) root = new Node(r);
        else root.nodeAdd(r);
    }

    // Returns the product of all elements of this collection with values
    // greater than or equal to 'lower'.
    // Returns 1/1 if there are no such elements in the collection.
    public Rational product(double lower) {
        return (root == null ? Rational.create(1,1) : root.nodeProductGEQ(lower));
    }

    // Returns a string representation of this collection. Elements are in
    // ascending order according to their values. Example: "[-2/3, -1/3, 1/2, 3/4]"
    public String toString() {
        return "[" + (root == null ? "" : root.nodeToString()) + "]";
    }

    class Node{
        private final Rational val;
        private Node left;
        private Node right;

        public Node(Rational val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public double value() { return val.value(); }

        public void nodeAdd(Rational rat){
            //L <= N < R
            if (rat.value() <= this.value()) {
                if (left == null) left = new Node(rat);
                else left.nodeAdd(rat);
            } else {
                if (right == null) right = new Node(rat);
                else right.nodeAdd(rat);
            }
        }

        public Rational nodeProductGEQ(double lower){
            Rational out = Rational.create(1, 1);
            if (this.value() >= lower) {
                out = out.mult(this.val);
                if (left != null && left.value() >= lower) out = out.mult(left.nodeProductGEQ(lower)); //if this is too small - no need to check left
            }
            if (right != null && right.value() >= lower) out = out.mult(right.nodeProductGEQ(lower));
            return out;
        }

        public String nodeToString(){
            return (left == null ? "" : left.nodeToString() + ", ") + this.val.toString() +
                    (right == null ? "" : ", " + right.nodeToString());
        }
    }
}