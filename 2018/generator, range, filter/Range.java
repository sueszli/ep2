// 'Range' ist ein Generator der aufsteigenden Folge von aufeinander folgenden ganzen Zahlen im
// bestimmten Intervall von 'first' bis 'last' (inklusive).
// Der Generator liefert nur dann mindestens eine Zahl, wenn gilt first <= last,
// sonst liefert er keine Zahl.
class Range implements Generator {
    public Range(int first, int last){
    }

    @Override
    public boolean hasNext() {
        return false;
    }
    
    public Integer next(){
        return null;
    }
    
    @Override
    public Generator copy() {
        return null;
    }
}