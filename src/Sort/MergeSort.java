package Sort;

import LinkedLists.Node;

public class MergeSort {
    static void main() {
        int[] values = {4, 2, 1, 3};
        Node head = parserArrayToLinkstList(values);
        Node sortedHead = mergeSort(head);
        System.out.print("Entrada:");
        for (int value : values) {
            System.out.print(value +",");
        }
        System.out.println("\n");
        System.out.print("Sorted Linked List: ");
        printLinkedList(sortedHead);
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> middle = findMiddle(head);
        Node<Integer> afterMiddle = middle.next;
        middle.next = null;

        Node<Integer> left = mergeSort(head);
        Node<Integer> right = mergeSort(afterMiddle);
        return mergeTowList(left, right);
    }

    public static Node<Integer> mergeTowList(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> head = new Node<>();
        Node<Integer> tail = head;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

    public static Node<Integer> findMiddle(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> parserArrayToLinkstList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node<Integer> head = new Node(values[0]);
        Node<Integer> current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        System.out.print("[");
        Node current = head;

        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }

        System.out.println("]");
    }

}
