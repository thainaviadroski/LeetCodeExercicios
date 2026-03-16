package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class LinkedListPalindrome {

    static void main() {


        Node<Integer> list = createList(1, 2, 3, 2, 1);

        System.out.println("Palindrome" + isPalindrome(list));

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

    public static boolean isPalindrome(Node head) {
        List<Integer> list = new ArrayList();
        while(head != null){
            list.add((Integer) head.value);
            head = head.next;
        }
        return list.equals(list.reversed());
    }
}
