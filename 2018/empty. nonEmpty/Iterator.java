// Ein Iterator über ganze Zahlen.
interface Iterator extends java.util.Iterator<Integer> {
    boolean hasNext();

    Integer next();
}