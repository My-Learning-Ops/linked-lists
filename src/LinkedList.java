
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

    // Clears the linked list
    public void clear() {
        first = last = null;
        count = 0;
    }

    // Check if the list contains a specific element
    public boolean contains(T element) {
        Node<T> current = first;
        while (current != null) {
            if (current.value.equals(element)) return true;
            current = current.next;
        }
        return false;
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

    // Adds an element to the start of the list
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element, first);
        first = newNode;
        if (last == null)
            last = newNode;
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
        Node<T> current = first;
        while (current.next != null && !current.next.value.equals(element)) {
            current = current.next;
        }

        // If found, unlink the node
        if (current.next != null) {
            if (current.next == last) {
                last = current;
            }
            current.next = current.next.next;
            count--;
        }
    }

    // Removes the first element from the list
    // Could also return the value of the element removed by changing return type to T
    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T val = first.value;
        first = first.next;
        if (first == null) last = null;
        count--;
    }

    // Converts the list into an array
    public Object[] toArray() {
        Object[] arr = new Object[count];
        Node<T> current = first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }

    // Returns a string representation of the linked list using string builder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
