import java.util.NoSuchElementException;
import java.util.Objects;

// A 'Stick' has a specified weight, that can not be changed after
// initialisation. On the left and right end of the stick further mobiles are attached
// (recursive structure).
//
public class Stick implements Mobile {
    private final int weight;
    private final Mobile left;
    private final Mobile right;

    // Initialises 'this'.
    // Precondition: left != null, right != null
    public Stick(int weight, Mobile left, Mobile right) throws MobileUnbalancedException {
        assert left != null && right != null;
        if (left.getWeight() != right.getWeight()) throw new MobileUnbalancedException("Invalid arguments!");
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    @Override
    public int getWeight() {
        return weight + left.getWeight() + right.getWeight();
    }

    @Override
    public MobileIterator iterator() {
        MobileIterator leftIter = left.iterator();
        MobileIterator rightIter = right.iterator();
        return new MobileIterator() {
            @Override
            public boolean hasNext() {
                return leftIter.hasNext() || rightIter.hasNext();
            }

            @Override
            public Star next() {
                if (!hasNext()) throw new NoSuchElementException("No such element!");
                if (leftIter.hasNext()) return leftIter.next();
                else return rightIter.next();
            }
        };
    }

    @Override
    public String toString() {
        return "(" + left.toString() + ")-(" + this.weight + ")-(" + right.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stick other = (Stick) o;
        //equal even if nodes are swapped recursively
        boolean weightCheck = this.weight == other.weight;
        boolean leftCheck = this.left.equals(other.left) || this.left.equals(other.right);
        boolean rightCheck = this.right.equals(other.right) || this.right.equals(other.left);
        return weightCheck && leftCheck && rightCheck;
    }

    @Override
    public int hashCode() {
        return this.getWeight() * 31 + 13;
    }
}
