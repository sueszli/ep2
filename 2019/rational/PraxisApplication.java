// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication {
    public static void main(String[] args) {
        Rational r = Rational.create(1, 2);
        System.out.println(r); // 1/2
        System.out.println(r.value()); // 0.5
        Rational s = Rational.create(2, 0);
        System.out.println(s); // NaN
        System.out.println(s.value()); // NaN
        System.out.println(s.mult(r)); // NaN
        System.out.println(r.mult(s)); // NaN
        System.out.println(r.mult(r)); // 1/4
        System.out.println(s.mult(s)); // NaN
        RationalCollection m1 = new RationalCollection();
        m1.add(r);
        m1.add(Rational.create(2, -3));
        m1.add(Rational.create(-3, -4));
        m1.add(Rational.create(1, -3));
        System.out.println(m1); // [-2/3, -1/3, 1/2, 3/4]
        System.out.println(m1.product(-1)); // 6/72
        System.out.println(m1.product(0.5)); // 3/8
        System.out.println(m1.product(1)); // 1/1
    }
}