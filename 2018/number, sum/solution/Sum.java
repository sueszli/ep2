import java.util.NoSuchElementException;

// Eine Summe mit linkem und rechtem Summanden. Der Iterator iteriert über alle Zahlen des Ausdrucks von links nach rechts.
class Sum implements Expression {
    private final Expression left;
    private final Expression right;

    // Konstruktor
    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Sum add(Expression exp) { return new Sum(this, exp); }

    public int eval() {
        return left.eval() + right.eval();
    }

    public Iterator iterator() { return new TreeIterator(this); }

    public String toString() {
        String rStr = right.toString();
        boolean neg = rStr.charAt(0) == '-';
        return left.toString() + (neg ? rStr : "+" + rStr);
    }

    class TreeIterator implements Iterator{
        private final Iterator rIter;
        private final Iterator lIter;

        public TreeIterator(Sum treeNode) {
            this.lIter = treeNode.getLeft().iterator();
            this.rIter = treeNode.getRight().iterator();
        }

        @Override
        public boolean hasNext() {
            return rIter.hasNext() || lIter.hasNext();
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException("No such element!");
            if (rIter.hasNext()) return rIter.next();
            else return lIter.next(); //either rIter.hasNext() or lIter.hasNext() must be true
        }
    }
}