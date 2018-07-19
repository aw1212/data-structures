package com.alex.structures.stack;

import com.alex.structures.linkedlist.DoubleLinkedList;

public class LinkedListStack<E> {

    private DoubleLinkedList<E> doubleLinkedList;

    public LinkedListStack() {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public void push(E value) {
        doubleLinkedList.addToBeginning(value);
    }

    public int getSize() {
        return doubleLinkedList.getSize();
    }

    public boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }

    public E pop() {
        if (doubleLinkedList.getSize() == 0) {
            throw new IllegalArgumentException("Cannot pop from empty stack");
        }
        return doubleLinkedList.removeFromBeginning();
    }

    public E peek() {
        if (doubleLinkedList.getSize() == 0) {
            throw new IllegalArgumentException("Cannot peek empty stack");
        }
        return doubleLinkedList.get(0);
    }

    public void printStack() {
        doubleLinkedList.printList();
    }

}
