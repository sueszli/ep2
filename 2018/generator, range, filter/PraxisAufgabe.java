import java.util.*;

/**
 * D1 Schreiben bzw. vervollständigen Sie bitte gekennzeichnete Programmteile
 * wie in den Kommentaren beschrieben. Verändern Sie aber nicht vorgegebene
 * Methodenköpfe oder andere vorgegebene Programmteile. Neben den Testfällen in
 * 'main' müssen auch alle Zusicherungen in den Kommentaren und Bedingungen auf
 * dem Aufgabenblatt gelten.
 */
public class PraxisAufgabe {
    /*
     * Aufgabe: siehe Angabeblatt Ergänzen Sie bitte fehlende Teile der Klassen an
     * den mit TODO gekennzeichneten Stellen. Auch für teilweise korrekte Lösungen
     * werden Punkte vergeben.
     */
    // 'main' enthält vorgefertigte Testfälle jeweils mit Sollausgabe als Kommentar.
    // Ergänzen weiterer Testfälle ist hier erlaubt.
    // Das Testen wird nicht beurteilt.

    public static void main(String[] args) {
        Generator s = new Range(-5, 5);
        while (s.hasNext()) {
            System.out.print(s.next() + " ");
        }
        System.out.println();
        // -5 -4 -3 -2 -1 0 1 2 3 4 5
        
        s = new Range(-10, 5);
        FilteredGenerator f = new FilterMultiples(s, 2);
        System.out.println(f.next());
        // -9
        
        System.out.println(s.next());
        // -8
        
        FilteredGenerator g = f.copy();
        while (g.hasNext()) {
            System.out.print(g.next() + " ");
        }
        System.out.println();
        // -7 -5 -3 -1 1 3 5
        
        System.out.println(s.next());
        // -7
        
        System.out.println(f.next());
        // -5
        
        try {
            System.out.println(g.next());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            // FilterMultiples has no more numbers!
        }
        
        // Folgende Schleife gibt nur Primzahlen aus (Sieb des Eratosthenes):
        Generator primes = new Range(2, 50);
        while (primes.hasNext()) {
            int prime = primes.next();
            System.out.print(prime + " ");
            primes = new FilterMultiples(primes, prime);
        }
        // 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
    }
}
