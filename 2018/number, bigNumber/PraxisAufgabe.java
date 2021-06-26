import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Schreiben bzw. vervollständigen Sie bitte gekennzeichnete Programmteile wie
 * in den Kommentaren beschrieben. Verändern Sie aber nicht vorgegebene
 * Methodenköpfe oder andere vorgegebene Programmteile. Die erfolgreiche
 * Ausführung der Testfälle in 'main' stellt nicht sicher, dass die Lösung
 * korrekt ist.
 */
public class PraxisAufgabe {
    /*
     * Aufgabe: Klassen und Objekte, rekursive Datenstrukturen. Ergänzen Sie bitte
     * fehlende Teile der Klassen 'Number' und 'BigNumber' entsprechend den
     * Kommentaren an den mit TODO gekennzeichneten Stellen. Punkte (in Summe
     * maximal 75): 20 Punkte in Summe für die Klasse 'Number'. 55 Punkte in Summe
     * für die Klasse 'BigNumber', aufgeteilt wie folgt: 40 Punkte für die
     * Implementierung einer einfach oder doppelt verketteten Liste zum Speichern
     * beliebig vieler (8er-Gruppen von) Stellen der Zahl. 15 Punkte für die
     * korrekte Funktionalität (unabhängig von der Implementierung). Hinweis: Wird
     * statt einer eigenen Implementierung der verketteten Liste eine vorgefertigte
     * Java Collection Klasse oder ein Array genutzt, können für die Klasse
     * 'BigNumber' maximal 15 Punkte erreicht werden. Die Anzahl der dargestellten
     * führenden Nullen ist beliebig, d.h. Lösungen mit und ohne führende Nullen
     * sind erlaubt. Auch für teilweise korrekte Lösungen werden Punkte vergeben.
     */
    // 'main' ist zum Testen verwendbar und kann beliebig geändert werden.
    // Das Testen wird nicht beurteilt.
    public static void main(String[] args) {
        // Hinweis: Die Anzahl der dargestellten führenden Nullen darf von den hier gezeigten
        // Sollausgaben abweichen.
        Number n = new Number(99999154);
        System.out.println(n.toString()); // 99999154

        for(int i = 0; i < 1000000; i++) {
            n.increment();
        }

        System.out.println(n.toString()); // 00999154
        
        for(int i = 0; i < 1000000; i++) {
            n.increment();
        }
        System.out.println(n.toString()); // 01999154
        
        BigNumber bn = new BigNumber(Long.MAX_VALUE);
        System.out.println(bn.toString()); // 000009223372036854775807
        
        for(int i = 0; i < 1234567; i++) {
            bn.increment();
        }
        
        System.out.println(bn.toString()); // 000009223372036856010374
        
        bn = new BigNumber("725473526600001886534325642623");
        bn.increment();
        System.out.println(bn.toString()); // 00725473526600001886534325642624
        
        bn.setDigit(50,2);
        System.out.println(bn.toString()); // 00000200000000000000000000725473526600001886534325642624
        
        bn.setDigit(50,0);
        System.out.println(bn.toString()); // 00000000000000000000000000725473526600001886534325642624
    }
}
