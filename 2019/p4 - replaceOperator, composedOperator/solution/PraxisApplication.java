import java.util.Iterator;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication {

    public static void main(String[] args) {

        StringOperator singleRep = new ReplaceOperator('t','T');
        System.out.println(singleRep); // replace 't' with 'T'
        System.out.println(singleRep.apply("This is just a test!")); // This is jusT a TesT!

        StringOperator rep1 = new ReplaceOperator('a', 'A');
        for (int i = 1; i < 3; i++) {
            rep1 = rep1.andThen(new ReplaceOperator((char) ('a'+i), (char)('A'+i)));
        }
        System.out.println(rep1); // replace 'a' with 'A' and then replace 'b' with 'B' and then replace 'c' with 'C'
        System.out.println(rep1.apply("This is epic!")); // This is epiC!

        StringOperator rep2 = new ReplaceOperator((char) ('a'+3), (char)('A'+3));
        for (int i = 4; i < 26; i++) {
            rep2 = rep2.andThen(new ReplaceOperator((char) ('a'+i), (char)('A'+i)));
        }

        System.out.println(rep1.andThen(rep2).apply("Yet another test!")); // YET ANOTHER TEST!

        rep2 = rep1.andThen(singleRep);
        StringOperator rep2clone = rep1.andThen(new ReplaceOperator('t','T'));
        System.out.println(rep2.equals(rep2clone)); // true
        System.out.println(rep2.equals(rep2clone.andThen(new ReplaceOperator('t','T')))); // false

        Iterator<StringOperator> iter = singleRep.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        // replace 't' with 'T'

        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        // no operator!

        for(StringOperator op: rep1) {
            System.out.println(op);
        }

        /*
        replace 'a' with 'A'
        replace 'b' with 'B'
        replace 'c' with 'C'
         */


    }
}

