package com.alex.structures.linkedlist;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addToBeginning(3);
        doubleLinkedList.printList();

        doubleLinkedList.addToBeginning(1);
        doubleLinkedList.printList();

        doubleLinkedList.addToEnd(4);
        doubleLinkedList.printList();

        doubleLinkedList.add(1, 2);
        doubleLinkedList.printList();

        doubleLinkedList.removeFirstOccurrence(4);
        doubleLinkedList.printList();

        System.out.println(doubleLinkedList.get(1));
    }

}
