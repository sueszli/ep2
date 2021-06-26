// Repräsentiert einen konstanten arithmetischen Summenausdruck
// (Ausdruck in dem Zahlen durch Addition verknüpft werden).
interface Expression extends Iterable {
    // Liefert den Wert des Ausdrucks.
    int eval();

    // Liefert eine lesbare Darstellung des Ausdrucks ohne Klammern.
    String toString();

    // Liefert einen neuen Ausdruck, in dem 'exp' als rechter Summand hinzugefügt wurde.
    Expression add(Expression exp);
}
