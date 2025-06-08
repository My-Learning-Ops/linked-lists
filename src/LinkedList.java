
// Generic LinkedList implementation

public class LinkedList<T> {

    // Node class representing each node in the linked list
    class Node<T> {
        T value;
        Node<T> next;

        // Constructs a node and links to the next
        Node(T val, Node<T> n) {
            value = val;
            next = n;
        }

        // Constructs a node with no link to the next
        Node(T val) {
            this(val, null);
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int count;

    // Construct a new linked list
    public LinkedList() {
        first = null;
        last = null;
        count = 0;
    }

    // Returns the size of the list
    public int size() {
        return count;
    }

    // Checks if the linked list is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Adds an element to the end of the list
    public void add(T element) {
        if (isEmpty()) {
            // If list is empty, create a new node as the first node and last node
            first = new Node<T>(element, null);
            last = first;
        } else {
            // If the list isnt empty, create a new node as the last, link old last to new last
            last.next = new Node<T>(element, null);
            last = last.next;
        }
        count++;
    }

    // Removes an element from the list
    public void remove(T element) {
        if (isEmpty()) return;

        // Check if first node is one to remove
        if (first.value.equals(element)) {
            first = first.next;
            if (first == null) {
                last = null;
            }
            count--;
            return;
        }

        // Traverse to find node before one to remove

        // If found, unlink the node



    }
}
