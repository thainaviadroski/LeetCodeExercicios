package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class ReversLinkedList {
    static void main() {
        Node<Integer> list = createList(1, 2, 3, 10, 69);
        list.printList();
        System.out.println("++++++++++++++++++++++++");
        Node<Integer> head = revert(list);
        head.printList();
    }

    public static Node revert(Node head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add((Integer) head.value);
            head = head.next;
        }

        list = list.reversed();

        Node newHead = null;
        Node prev = null;
        for (Integer item : list) {
            Node node = new Node(item);
            if (newHead == null) newHead = node;
            if (prev != null) {
                prev.next = node;
                node.prev = prev;
            }
            prev = node;
        }
        return newHead;
    }

    public static <T> Node<T> createList(T... values) {
        if (values.length == 0) return null;

        Node<T> head = new Node<>(values[0]);
        Node<T> current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node<>(values[i]);
            current.next.prev = current;
            current = current.next;
        }
        return head;
    }
}
