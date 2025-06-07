
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

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(T element) {
    }

    public void remove(T element) {
    }

    








}
