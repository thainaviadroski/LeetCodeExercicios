package LinkedLists;

public class DoublyLinkedList<T> {
    private Node<T> head, tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }


    public void addToTail(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T removeToHead() {
        if (head == null) {
            return null;
        }

        T removedValue = head.value;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return removedValue;
    }


    public T removeToTail() {
        if (tail == null) {
            return null;
        }
        T removedValue = tail.value;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return removedValue;
    }

    public void reverseLinkedList() {
        if (head == null || head == tail) {
            return;
        }

        Node<T> current = head;
        Node<T> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public Node<T> middleLinkedList() {
        Node<T> ahead = head;

        while (ahead != null && ahead.next != null) {
            ahead = ahead.next.next;
            head = head.next;
        }
        return head;
    }

    public Boolean hasCycle() {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public void createLoopForTesting(int position) {
        if (head == null) return;

        Node<T> current = head;
        Node<T> loopNode = null;
        int index = 0;

        while (current.next != null) {
            if (index == position) {
                loopNode = current;
            }
            current = current.next;
            index++;
        }

        if (loopNode != null) {
            current.next = loopNode;
            loopNode.prev = current;
        }
    }

    public void display() {
        Node<T> current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

}
