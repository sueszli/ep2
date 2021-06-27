// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("The Viper", 9);
        Fighter fighter2 = new Fighter("The Mountain", 10);
        fighter1.fights(fighter2);
        
        System.out.println(fighter1.isDead()); // true
        
        System.out.println(fighter2.isDead()); // false
        
        Fighter biter = new Fighter("Freddie", 2);
        
        Team undead = new Team(
                new Fighter[] { biter, new Fighter("Creeper", 2), new Fighter("Dan", 2), new Fighter("Abey", 2) });
        Team living = new Team(new Fighter[] { new Fighter("Andrea", 5), new Fighter("Bernd", 4) });
        System.out.println(living + " : " + undead);
        // [ *Andrea(5)* Bernd(4) ] : [ *Freddie(2)* Creeper(2) Dan(2) Abey(2) ]
        
        while (!(undead.isEmpty() || living.isEmpty())) {
            living.fight(undead);
            System.out.println(living + " : " + undead);
        }
        /*
         * [ *Andrea(5)* Bernd(4) ] : [ *Freddie(2)* Creeper(2) Dan(2) Abey(2) ] [
         * Andrea(3) *Bernd(4)* ] : [ *Creeper(2)* Dan(2) Abey(2) ] [ *Andrea(3)*
         * Bernd(2) ] : [ *Dan(2)* Abey(2) ] [ Andrea(1) *Bernd(2)* ] : [ *Abey(2)* ] [
         * *Andrea(1)* ] : [ ]
         */
    }
}
