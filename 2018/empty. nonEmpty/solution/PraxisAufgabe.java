import java.util.*;
/**
 * A1
 * Schreiben bzw. vervollständigen Sie bitte gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
 * Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile.
 * Neben den Testfällen in 'main' müssen auch alle Zusicherungen in den Kommentaren und Bedingungen
 * auf dem Aufgabenblatt gelten.
 */

public class PraxisAufgabe {
    // 'main' enthält vorgefertigte Testfälle jeweils mit Sollausgabe als Kommentar.
    // Ergänzen weiterer Testfälle ist hier erlaubt.
    // Das Testen wird nicht beurteilt.
    public static void main(String[] args) {

        Interval i1 = new NonEmpty(-1, 10);
        Interval i2 = new NonEmpty(5, 20);
        Interval i3 = new NonEmpty(20, 25);

        try {
            i3 = new NonEmpty(20, -25);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // lower (20) must not be greater than upper (-25)!
        }

        System.out.println(i1.intersect(i2)); //[5, 10]
        System.out.println(i2.intersect(i3)); //[20, 20]
        System.out.println(i1.intersect(i3)); //[]

        System.out.println(i1.containsAll(i1.intersect(i2))); // true

        Iterator iter = Empty.EMPTY.iterator();
        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage()); // EMPTY has no elements!
        }

        Interval i4 = new NonEmpty(-5, 20);

        System.out.println();
        System.out.println("My tests");
        System.out.println(i1.intersect(i4));
        System.out.println(i4.intersect(i1));
        System.out.println(i1);
        for (int i : i1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(i1 + " " + i2);
        System.out.println(i1.containsAll(i2));

        System.out.println(Empty.EMPTY.equals(Empty.EMPTY));
        System.out.println(Empty.EMPTY.hashCode());

        Interval i5 = new NonEmpty(-5, 20);
        Interval i6 = new NonEmpty(-5, 20);

        System.out.println(i5.equals(Empty.EMPTY));
        System.out.println(i5.equals(i6));
        System.out.println(i5.hashCode());

    }
}
