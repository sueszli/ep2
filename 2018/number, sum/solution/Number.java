import java.util.NoSuchElementException;

// Diese Klasse repräsentiert eine ganze Zahl. Ihr Iterator liefert nur eine Zahl und ist danach verbraucht.
class Number implements Expression {
    private int num;

    public Number(int num) {
        this.num = num;
    }

    public int eval() { return num; }

    public Sum add(Expression exp) { return new Sum(this, exp); }

    public String toString() {
        return ""+this.num;
    }

    public Iterator iterator() {
        int temp = num;
        return new Iterator() {
            private int num = temp;
            boolean called;

            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException("No more numbers!");
                called = true;
                return num;
            }
        };
    }
}
