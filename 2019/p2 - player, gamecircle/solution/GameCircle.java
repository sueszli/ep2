import java.util.Objects;

// This class represents players sitting in a circle in a counting game.
// Objects of type 'Player' are stored in a ring list (all nodes have a successor node != null).
// The first player starts counting "1", the second counts "2", etc., until the player, who reaches the
// specified dropout number. This player is removed from the game and the player next to his position
// starts counting again with "1" in the next round.
//
// Example (4 Players, dropout number is 3):
//
// Round 1:
// Player1      Player2     Player3     Player4
// "1"
//              "2"
//                          "3!"
// -> Player3 removed
//
// Round 2:
// Player1      Player2     Player4
//                          "1"
// "2"                      ⤶
//              "3!"
// -> Player2 removed
//
// Round 3:
// Player1      Player4
//              "1"
// "2"          ⤶
//              "3!"
// -> Player4 removed
// Player1 wins!
public class GameCircle {
    private Node starter;
    private Node printStarter; //only used by toString()

    // Initializes this GameCircle with the players created according to
    // 'playerNames'. The player playerNames[i] gets the number i+1.
    // playerNames[0] is the player who will start counting.
    // Preconditions: 'playerNames' is not null and has no 'null'-entries (need not be checked).
    public GameCircle(String[] playerNames) {
        for (String p : playerNames) {
            if (starter == null) printStarter = starter = new Node(new Player(p));
            else starter.nodeAddBehindStarter(new Player(p));
        }
    }

    // This method simulates one round of the counting game with
    // dropout number 'dropOutCount'. It returns the player who is removed
    // in this round. Returns 'null' if there is no player in the game circle.
    // Note that the starting position for counting depends on the previous round!
    // Precondition: dropOutCount > 0 (needs not be checked).
    public Player play(int dropOutCount) {
        if (starter.next.equals(starter)) {
            Player temp = starter.val;
            printStarter = starter = null;
            return temp;
        }
        Node dead = starter.nodeDropOut(dropOutCount);
        if (dead.equals(printStarter)) printStarter = printStarter.next;
        starter = dead.next;
        return dead.val;
    }

    // Returns 'true' if there is no player in the game circle.
    public boolean isEmpty() {
        return starter == null;
    }

    // Returns a representation of this game circle with all its (remaining) players in
    // brackets in order of their insertion (player with smallest number is left).
    // The player that starts counting in the next round is marked by '*'.
    // Returns "[]" if the circle is empty.
    public String toString() { return (isEmpty() ? "[ ]" : "[ " + printStarter.toString() + " ]"); }

    class Node {
        private final Player val;
        private Node next;

        public Node(Player val){
            this.val = val;
            this.next = this;
        }

        public Node(Player val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void nodeAddBehindStarter(Player p){
            if (next.equals(starter)) next = new Node(p, starter);
            else next.nodeAddBehindStarter(p);
        }

        public Node nodeDropOut(int count){
            if (count == 2) {
                Node temp = next;
                this.next = next.next;
                return temp;
            }
            return next.nodeDropOut(count-1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(val, node.val);
        }

        @Override
        public String toString() {
            return (this.equals(starter) ? "*" + val.toString() + "*" : val.toString()) +
                    (!next.equals(printStarter) ? " " + next.toString() : "");
        }
    }
}

