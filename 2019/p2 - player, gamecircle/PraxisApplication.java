// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisApplication {

    public static void main(String[] args) {

        GameCircle game = new GameCircle(new String[] {"Andrea", "Franz", "Marion", "Marion", "Markus"});
        System.out.println(game); // [ *Andrea(1)* Franz(2) Marion(3) Marion(4) Markus(5) ]

        System.out.println(Player.numberOfPlayers()); // 5

        Player eliminated;

        do {
            eliminated = game.play(4);
            System.out.println("Im Spiel ist noch " + game + " und ausgeschieden ist " + eliminated);
        } while (!game.isEmpty());

        System.out.println("Es gewinnt " + eliminated);

        /*
        Im Spiel ist noch [ Andrea(1) Franz(2) Marion(3) *Markus(5)* ] und ausgeschieden ist Marion(4)
        Im Spiel ist noch [ Andrea(1) Franz(2) *Markus(5)* ] und ausgeschieden ist Marion(3)
        Im Spiel ist noch [ *Andrea(1)* Franz(2) ] und ausgeschieden ist Markus(5)
        Im Spiel ist noch [ *Andrea(1)* ] und ausgeschieden ist Franz(2)
        Im Spiel ist noch [ ] und ausgeschieden ist Andrea(1)
        Es gewinnt Andrea(1)
        */

    }
}

