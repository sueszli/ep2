// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication {

    public static void main(String[] args) {

        Camel m = new Camel(2,3);
        System.out.println("t1: " + m); // 1 (3) 2

        Caravan cav = Caravan.create(new Camel[]{new Camel(2,3),new Camel(4,5), new Camel(3,5)});

        System.out.println("t2: " + cav); // [1 (3) 2 - 1 (5) 4 - 2 (5) 3], pace: 1

        cav.addUnitLoad();

        System.out.println("t3: " + cav); // [1 (3) 2 - 1 (5) 4 - 1 (5) 4], pace: 1

        cav = Caravan.create(new Camel[]{new Camel(2,3),new Camel(5,10), new Camel(3,5)});
        cav.addAfter(5,new Camel(20,30));
        System.out.println("t4: " + cav); // [1 (3) 2 - 5 (10) 5 - 10 (30) 20 - 2 (5) 3], pace: 1
        cav.addAfter(4,new Camel(11,33));
        System.out.println("t5: " + cav); // 22 (33) 11 - 1 (3) 2 - 5 (10) 5 - 10 (30) 20 - 2 (5) 3], pace: 1

        Caravan oneCamel =  Caravan.create(new Camel[]{null, new Camel(2,3), null});
        System.out.println("t6: " + oneCamel); // [1 (3) 2], pace: 1

        Caravan empty = Caravan.create(new Camel[]{null, null, null});
        System.out.println("t7: " + empty); // null

        empty = Caravan.create(new Camel[]{});
        System.out.println("t8: " + empty); // null

        empty = Caravan.create(null);
        System.out.println("t9: " + empty); // null

    }
}

