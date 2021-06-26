// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
public class PraxisApplicationTest1 {

    public static void main(String[] args) {


        System.out.println("Test1: PASSED -> Body works");
        Body b1 = new Body(3.0, new Vector3(0,0,0));
        Body b2 = new Body(5.0, new Vector3(1,-7,0));

        System.out.println(b1.toString()); // 3.0 <0;0;0>
        System.out.println(b2.toString()); // 5.0 <1;-7;0>

        System.out.println();
        System.out.println("Test2: PASSED -> adding works");
        CosmicSystem s1 = new CosmicSystem();
        s1.append(b1);
        s1.append(b2);
        s1.append(new Body(1d, new Vector3(1,0,0)));
        s1.append(new Body(2d, new Vector3(0,1,0)));

        System.out.println(s1.toString());
        /*
        3.0 <0;0;0>
        5.0 <1;-7;0>
        1.0 <1;0;0>
        2.0 <0;1;0>
         */

        System.out.println();
        System.out.println("Test3: -> passed");
        System.out.println(s1.getRecentCollision());
        // null

        System.out.println();
        System.out.println("Test4: PASSED -> adding works");
        s1.append(b2);
        s1.append(new Body(1d, new Vector3(1, -7, 0)));
        s1.append(new Body(6d, new Vector3(0, 0, -5)));
        System.out.println(s1.toString());
        /*
        3.0 <0;0;0>
        11.0 <1;-7;0>
        1.0 <1;0;0>
        2.0 <0;1;0>
        6.0 <0;0;-5>
         */

        System.out.println();
        System.out.println("Test5: -> passed");
        System.out.println(s1.getRecentCollision());
        // 11.0 <1;-7;0>

        System.out.println();
        System.out.println("Test6: PASSED -> git first and last works");
        System.out.println(s1.getFirstAndLast().toString());
        /*
        3.0 <0;0;0>
        6.0 <0;0;-5>
         */

        System.out.println();
        System.out.println("Test7: -> passed");
        System.out.println(s1.remove(new Vector3(0, 1, 0)).toString());
        // 2.0 <0;1;0>

        System.out.println();
        System.out.println(s1.toString());
        /*
        3.0 <0;0;0>
        11.0 <1;-7;0>
        1.0 <1;0;0>
        6.0 <0;0;-5>
         */

    }
}
