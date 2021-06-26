// Diese Klasse repräsentiert eine ganze Zahl. Ihr Iterator liefert nur eine Zahl und ist danach verbraucht.
class Number implements Expression {
    public Number(int num) {
    }

    public int eval() {
        return 0;
    }

    public Sum add(Expression exp) {
        return null;
    }

    public String toString() {
        return "";
    }

    public Iterator iterator() {
        return null;
    }
}
