package com.alex.structures.queue;

import com.alex.structures.linkedlist.DoubleLinkedList;

public class LinkedListQueue<E> {

    private DoubleLinkedList<E> doubleLinkedList;

    public LinkedListQueue() {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public void enqueue(E value) {
        doubleLinkedList.addToBeginning(value);
    }

    public E dequeue() {
        return doubleLinkedList.removeFromEnd();
    }

    public int getSize() {
        return doubleLinkedList.getSize();
    }

    public void printQueue() {
        doubleLinkedList.printListValueLastToFirst();
    }

}
