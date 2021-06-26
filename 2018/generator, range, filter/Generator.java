// Ein Generator liefert ganze Zahlen. Liefert 'hasNext()' den Wert 'false', ist der Generator verbraucht.
interface Generator {
    // liefert 'true' genau dann, wenn der Generator noch mindestens eine weitere Zahl liefert kann.
    boolean hasNext();

    // liefert die nächste ganze Zahl unter der Vorbedingung, dass 'hasNext()' den Wert 'true' liefert.
    Integer next();
    
    // liefert eine unabhängige Kopie (tiefe Kopie) des Generators in seinem aktuellen Zustand.
    Generator copy();
}