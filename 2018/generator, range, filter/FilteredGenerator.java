// Ein Generator, der nur bestimmte Zahlen liefern kann.
// Alle Zahlen 'i', für die 'pass(i)' den Wert 'false' liefert,
// können nicht Element der gelieferten Zahlenfolge sein.
interface FilteredGenerator extends Generator {
    // liefert 'true', wenn 'i' vom Filter durchgelassen wird.
    boolean pass(int i);
    
    // liefert eine unabhängige Kopie des Generators in seinem aktuellen Zustand.
    FilteredGenerator copy();
}
