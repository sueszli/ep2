import java.io.IOException;
import java.awt.Color;

public class PraxisApplicationU8 {

    public static void main(String[] args) throws BalancedSystemIllegalArgumentException {
        Body body1 = new Body("Body1", 20, 0, new Vector3(0, 0, 0), new Vector3(0, 0, 0), Color.YELLOW);
        Body body2 = new Body("Body2", 15, 0, new Vector3(0, 0, 0), new Vector3(0, 0, 0), Color.BLUE);
        Body body3 = new Body("Body3", 10, 0, new Vector3(0, 0, 0), new Vector3(0, 0, 0), Color.GRAY);
        Body body4 = new Body("Body4", 2, 0, new Vector3(0, 0, 0), new Vector3(0, 0, 0), Color.GRAY);
        Body body5 = new Body("Body5", 30, 0, new Vector3(0, 0, 0), new Vector3(0, 0, 0), Color.GRAY);

        BalancedSystem bs = null;
        System.out.println("Test 1: this should throw an exception");
        try {
            bs = new BalancedSystem(null, body2);
        } catch (IOException e) {
            System.out.println("ERROR! " + e.getMessage());
        }
        System.out.println();

        System.out.println("Test 2: this should create a new balanced system and print \"Left mass: 20.0, right mass: 15.0\"");
        try {
            bs = new BalancedSystem(body1, body2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(bs);

        System.out.println();

        System.out.println("Test 3: this tests the iterator of Body and should print \"Body2\" ");
        for (Body b : body2) {
            System.out.println(b);
        }

        System.out.println();

        System.out.println("Test4: this tests the iterator of BalancedSystem and should print Body1 and Body2 (in arbitrary order)");
        for (Body b : bs) {
            System.out.println(b);
        }

        System.out.println();

        System.out.println("Test 5: this tests the method numberofBodies() of BalancedSystem and should give 2:");
        System.out.println(bs.numberOfBodies());

        System.out.println();

        System.out.println("Test 6: this tests the method add() of Body and should print: \"Left mass: 10.0, right mass: 2.0\"");
        System.out.println(body3.add(body4));

        System.out.println();

        try {
            System.out.println("Test 7: this tests the method add() of BalancedSystem and should print:  \"Left mass: 52.0, right mass: 25.0\"");
            bs.add(body3);
            bs.add(body4);
            bs.add(body5);
            System.out.println(bs);
        } catch (IOException e) {
            System.out.println(bs);
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("Test 8: this tests again the method numberofBodies() of BalancedSystem and should give 5:");
        System.out.println(bs.numberOfBodies());

        System.out.println();

        System.out.println("Test 9: this tests again the iterator of BalancedSystem and should print Body1 to Body5 (in arbitrary order)");
        for (Body b : bs) {
            System.out.println(b);
        }

    }

}
