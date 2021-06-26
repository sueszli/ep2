// This class represents a caravan of camels. Objects of type 'Camel' are stored in a linked list.
public class Caravan {
    private Node root;

    // Returns a new caravan with the camels of 'camels', if it is not empty.
    // Returns 'null' if either 'camels' is 'null' or if camels.length == 0
    // or if all entries of 'camels' are 'null'.
    // Ignores 'null'-entries of 'camels'. There is no specified order.
    public static Caravan create(Camel[] camels) {
        if (camels == null || camels.length == 0) return null;

        boolean empty = true;
        for (Camel c : camels) { if (c != null) empty = false; }
        if (empty) return null;

        return new Caravan(camels);
    }

    // Initializes this caravan with the camels of 'camels'.
    // This constructor is only called within the class 'Caravan'.
    private Caravan(Camel[] camels) {
        for (Camel c : camels){
            if (c != null) addLast(c);
        }
    }

    // Adds 'camel' as the last camel to this caravan.
    // Precondition: 'camel' is not 'null'.
    public void addLast(Camel camel) {
        if (root == null) root = new Node(camel, null);
        else root.add(camel);
    }

    // Inserts 'camel' in the caravan right after the first camel (seen from the head
    // of the caravan) with a pace equal to 'searchPace'. Adds 'camel' as the head
    // of this caravan, if there is no such camel.
    // Precondition: 'camel' is not 'null' (needs not be checked).
    public void addAfter(int searchPace, Camel camel) {
        Camel found = (root == null ? null : root.searchPace(searchPace));
        if (found == null) {
            //add before 'root'
            root = new Node(camel, root);
        } else {
            //add after camel with the found pace
            root.addAfter(searchPace, camel);
        }
    }

    // Returns the pace of this caravan, which is the pace of the
    // slowest camel of this caravan.
    public int pace() {
        if (root == null) return 0;
        else return root.getMinPace();
    }

    // Adds one unit of load to the camel of this caravan, which
    // has the fastest pace (such that the likelihood of slowing
    // down the caravan by the additional load is minimized).
    // If there is more than one such camel, the one which
    // is closest to the head of the caravan takes the load.
    public void addUnitLoad() {
        if (root == null) return;
        int maxPace = root.getMaxPace();
        root.slowFastestDown(maxPace);
    }

    // Returns a representation of this caravan with all its camels in brackets
    // in corresponding order with head of the caravan on the left,
    // followed by the pace of the caravan.
    // Example: [1 (3) 2 - 1 (5) 4 - 2 (5) 3], pace: 1
    // Returns "[]" if the caravan is empty.
    public String toString() {
        return "[" + (root == null ? "" : root.toString()) + "], pace: " + this.pace();
    }

    class Node {
        private Camel val;
        private Node next;

        public Node(Camel val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void add(Camel val) {
            if (next == null) next = new Node(val, null);
            else next.add(val);
        }

        public void addAfter(int pace, Camel entry){
            if (this.val.pace() == pace) {
                this.next = new Node(entry, this.next);
            } else if (next != null) {
                next.addAfter(pace, entry);
            }
        }

        public int getMinPace(){
            return Math.min(val.pace(), (next == null ? Integer.MAX_VALUE : next.getMinPace()));
        }

        public int getMaxPace(){
            return Math.max(val.pace(), (next == null ? Integer.MIN_VALUE : next.getMaxPace()));
        }

        public void slowFastestDown(int maxPace){
            if (this.val.pace() == maxPace) this.val.changeLoad(1);
            else if (next != null) next.slowFastestDown(maxPace);
        }

        public Camel searchPace(int query){
            if (this.val.pace() == query) return this.val;
            return (next != null ? next.searchPace(query) : null);
        }

        @Override
        public String toString() {
            return val.toString() + (next == null ? "" : " - " + next.toString());
        }
    }
}

