package com.alex.structures.queue;

import com.alex.structures.list.DoubleLinkedList;

public class DoubleLinkedListQueue<E> implements Queue<E> {

    private DoubleLinkedList<E> doubleLinkedList;

    public DoubleLinkedListQueue() {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    @Override
    public void enqueue(E value) {
        doubleLinkedList.addToBeginning(value);
    }

    @Override
    public E dequeue() {
        return doubleLinkedList.removeFromEnd();
    }

    @Override
    public int getSize() {
        return doubleLinkedList.getSize();
    }

    public void printQueue() {
        doubleLinkedList.printListValueLastToFirst();
    }

}
