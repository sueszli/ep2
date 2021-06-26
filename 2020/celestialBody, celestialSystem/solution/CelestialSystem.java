// A sorted linked list of celestial bodies. The list is ordered
// lexicographically according to the names of the celestial bodies.
//
public class CelestialSystem {
    private Node root;
    private int size;

    // Inserts the specified 'body' into the sorted list only if there is no body in the list with
    // the same name as that of 'body'. Returns 'true' if the list was changed as a result of the
    // call, 'false' otherwise.
    public boolean add(CelestialBody body) {
        boolean success;

        if (root == null) {
            root = new Node(body, null);
            success = true;
        } else {
            if (root.getVal().equals(body)) return false;
            if (root.getVal().getName().compareTo(body.getName()) > 0){
                //place before root
                root = new Node(body, root);
                success = true;
            } else {
                //place after root
                success = root.nodeAdd(body);
            }
        }

        if (success) size++;
        return success;
    }

    // Returns the index (position) of the body with the specified name in the sorted list.
    // Celestial bodies are ordered lexicographically according to their names.
    // The first entry in this lexicographical order has index 0.
    // Returns -1 of there is no body in the list with the specified name.
    // Precondition: name != null.
    public int indexof(String name) {
        if (root == null) return - 1;
        Node p = root;
        for (int i = 0; i < size(); i++) {
            if (p.getVal().getName().equals(name)) return i;
            p = p.getNext();
        }
        return -1;
    }

    // Returns the body with the specified name or 'null' if no such body exits in the list.
    // Precondition: name != null.
    public CelestialBody get(String name) {
        return (root == null ? null : root.nodeGet(name));
    }

    // returns the number of entries of the list.
    public int size() {
        return size;
    }

    // Returns a readable representation of all bodies of this system
    // lexicographically ordered according to their name.
    public String toString() {
        return  (root == null ? "" : root.nodeToString());
    }

    class Node{
        private CelestialBody val;
        private Node next;

        public Node(CelestialBody val, Node next) {
            this.val = val;
            this.next = next;
        }

        public CelestialBody getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public boolean nodeAdd(CelestialBody b){
            if (this.val.equals(b)) return false;
            boolean nextIsBigger = next != null && next.val.getName().compareTo(b.getName()) > 0;

            if (next == null || nextIsBigger) {
                next = new Node(b, next);
                return true;
            } else {
                return next.nodeAdd(b);
            }
        }

        public CelestialBody nodeGet(String name){
            if (this.val.getName().equals(name)) return val;
            else return (next == null ? null : next.nodeGet(name));
        }

        public String nodeToString(){
            return this.val.toString() + (next == null ? "" : "\n" + next.nodeToString());
        }
    }
}

