// Ein 'Interval' ist eine aufsteigend iterierbare Menge
// von aufeinander folgenden ganzen Zahlen und stellt einfache
// Mengenoperationen zur Verfügung.
interface Interval extends Iterable {

    // liefert 'true' genau dann, wenn 'n' in der Menge enthalten ist
    boolean contains(Integer n);

    // liefert 'true' genau dann, wenn alle Zahlen aus 'iv' enthalten sind.
    boolean containsAll(Interval iv);

    // liefert ein Objekt von 'Interval', das der Schnittmenge mit 'iv' entspricht.
    Interval intersect(Interval iv);

    // liefert 'true' genau dann, wenn das Objekt die leere Menge repräsentiert.
    boolean isEmpty();

    // liefert 'true' genau dann, wenn die Menge genau die gleichen Zahlen
    // enthält wie 'o' (und 'o' auch ein 'Interval'-Objekt ist).
    boolean equals(Object o);

    // liefert den hashcode
    int hashCode();
}
