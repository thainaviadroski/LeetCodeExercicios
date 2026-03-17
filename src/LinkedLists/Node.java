package LinkedLists;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Node{value=" + value + "}";
    }

    public void printList() {
        Node<T> current = this;
        StringBuilder sb = new StringBuilder();

        while (current != null) {
            sb.append("[").append(current.value).append("]");
            if (current.next != null) sb.append(" <-> ");
            current = current.next;
        }

        System.out.println(sb);
    }
}
