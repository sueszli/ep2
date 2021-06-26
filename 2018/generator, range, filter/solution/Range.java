import java.util.NoSuchElementException;

// 'Range' ist ein Generator der aufsteigenden Folge von aufeinander folgenden ganzen Zahlen im
// bestimmten Intervall von 'first' bis 'last' (inklusive).
// Der Generator liefert nur dann mindestens eine Zahl, wenn gilt first <= last,
// sonst liefert er keine Zahl.
class Range implements Generator {
    private int first; //pointer
    private int last; //upper boundary

    public Range(int first, int last){
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean hasNext() {
        return first <= last;
    }

    public Integer next(){
        if (!hasNext()) throw new NoSuchElementException("No such element!");
        return first++;
    }

    @Override
    public Generator copy() {
        return new Range(first, last);
    }
}
