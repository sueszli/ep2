import java.util.Objects;

// A team consists of multiple fighters stored in a ring list (all nodes have a successor node != null).
// One fighter of the team is active and engages a one-on-one fight with the active fighter
// of the opponent team. After that, the next fighter becomes active in each team.
//
public class Team {
    private Node active;
    private Node printStart; //only used by toString()

    // Initializes this team with the fighters from 'fighters' and sets the first
    // fighter in the list active.
    // Preconditions: fighters != null and has no entries equal to 'null' (need not
    // be checked).
    public Team(Fighter[] fighters) {
        for (Fighter f : fighters) {
            if (active == null) printStart = active = new Node(f);
            else active.nodeAddBehindActive(f);
        }
    }

    // Simulates a one-on-one fight: the active fighter of this team fights
    // the active fighter of team 'opponent' by calling the method 'fight' of class
    // 'Fighter'.
    // Dead fighters are removed from their team (from the ring list) after
    // the one-on-one fight. After a fight, the next fighter becomes active in each
    // team.
    // If 'this' or 'opponent' is empty, calling this method has no effect.
    // Precondition: opponent != null (needs not be checked).
    public void fight(Team opponent) {
        this.active.val.fights(opponent.active.val);
        this.nextRound();
        opponent.nextRound();
    }

    private void nextRound(){
        if (active.val.isDead()){
            if (active.equals(printStart)) printStart = printStart.next;
            if (active.next.equals(active)){
                active = null;
                return;
            }
            active.nodeRemoveActive();
        }
        active = active.next;
    }

    // Returns 'true' if there is no fighter in the team.
    public boolean isEmpty() { return active == null; }

    // Returns a representation of this team with all its (remaining) fighters in
    // brackets in order of their insertion. The active fighter is marked by '*'.
    // Returns "[]" if the team is empty.
    public String toString() { return "[ " + (isEmpty() ? "" : printStart.toString()) + " ]"; }

    class Node {
        private final Fighter val;
        private Node next;

        public Node(Fighter val){
            this.val = val;
            this.next = this;
        }

        public Node(Fighter val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void nodeAddBehindActive(Fighter f){
            if (next.equals(active)) next = new Node(f, active);
            else next.nodeAddBehindActive(f);
        }

        public void nodeRemoveActive(){
            if (next.equals(active)) next = next.next;
            else next.nodeRemoveActive();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node rlNode = (Node) o;
            return Objects.equals(val, rlNode.val);
        }

        @Override
        public String toString() {
            return (this.equals(active) ? "*" + val.toString() + "*" : val.toString()) +
                    (!next.equals(active) ? " " + next.toString() : "");
        }
    }
}