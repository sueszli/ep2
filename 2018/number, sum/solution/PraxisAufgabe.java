import java.util.*;
import java.util.Iterator;

/**
 * B3
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

        Expression a = new Sum(new Sum(new Number(5),new Number(-3)),new Number(7));
        System.out.println(a); // 5-3+7

        a = a.add(new Number(-10));
        System.out.println(a); // 5-3+7-10

        for (Integer i: a) {
            System.out.print(i+" ");
        }
        System.out.println();
        // 5 -3 7 -10

        Expression n = new Number(13);
        Iterator iter = n.iterator();
        System.out.println(iter.hasNext()); // true
        System.out.println(iter.next()); // 13

        try {
            System.out.println(iter.next());
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()); // No more numbers!
        }

        a = a.add(a);
        System.out.println(a); // 5-3+7-10+5-3+7-10

        System.out.println(a.eval()); // -2
    }
}

