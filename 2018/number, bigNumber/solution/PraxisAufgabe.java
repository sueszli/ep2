public class PraxisAufgabe {
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
        System.out.println(bn.toString());  // 000009223372036854775807

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
