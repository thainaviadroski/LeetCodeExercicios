package LinkedLists;

import java.util.LinkedList;

public class TestDoubleLinkedList {

    static void main() {
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
        intList.addToHead(1);
        intList.addToTail(2);
        intList.addToHead(0);
        intList.display();

        System.out.println("Removido do início: " + intList.removeToHead());
        intList.display();
        System.out.println("Removido do final: " + intList.removeToTail());

        System.out.println("-----------------------------------------");


        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        stringList.addToTail("Mundo");
        stringList.addToHead("Olá");
        stringList.addToTail("!");
        stringList.display();

        System.out.println("Removido: " + stringList.removeToHead());
        stringList.display();

        System.out.println("-----------------------------------------");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);

        System.out.println("Antes:");
        list.display(); // Lista: 1 2 3 4

        list.reverseLinkedList();

        System.out.println("Depois:");
        list.display(); // Lista: 4 3 2 1


        System.out.println("-----------------------------------------");

        Node<Integer> middle = list.middleLinkedList();
        System.out.println(middle.value);

        System.out.println("-----------------------------------------");
        DoublyLinkedList<Integer> listWithLoop = new DoublyLinkedList<>();
        listWithLoop.addToTail(1);
        listWithLoop.addToTail(2);
        listWithLoop.addToTail(3);
        listWithLoop.addToTail(4);
        listWithLoop.createLoopForTesting(1);

        System.out.println("\nLista com loop:");
        System.out.println("Tem loop? " + listWithLoop.hasCycle());

    }
}
