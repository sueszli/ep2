import java.util.*;

// This class implements 'StringOperator' and represents a composition of two 'StringOperator' objects that
// are applied in succession (both can be 'ComposedOperator' objects themselves).
// Calling this object's 'apply' method returns the result of applying the second 'StringOperator'
// on the result of applying the first one on the specified string.
// 'ComposedOperator' objects can be build using the 'andThen' method specified in the interface 'StringOperator'.
//
public class ComposedOperator implements StringOperator{
    private StringOperator left;
    private StringOperator right;

    public ComposedOperator(StringOperator left, StringOperator right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String apply(String operand) { return right.apply(left.apply(operand)); }

    @Override
    public StringOperator andThen(StringOperator after) {
        return new ComposedOperator(this, after);
    }

    @Override
    public Iterator<StringOperator> iterator() {
        return new Iterator<>() {
            private Iterator<StringOperator> leftIter = left.iterator();
            private Iterator<StringOperator> rightIter = right.iterator();

            @Override
            public boolean hasNext() { return leftIter.hasNext() || rightIter.hasNext(); }

            @Override
            public StringOperator next() {
                if (!hasNext()) throw new NoSuchElementException("No operator!");
                if (leftIter.hasNext()) return leftIter.next();
                return rightIter.next();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposedOperator that = (ComposedOperator) o;
        return Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() { return Objects.hash(left, right); }

    @Override
    public String toString() { return left.toString() + " and then " + right.toString(); }
}

