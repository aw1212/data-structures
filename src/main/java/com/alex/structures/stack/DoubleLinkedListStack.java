package com.alex.structures.stack;

import com.alex.structures.linkedlist.DoubleLinkedList;

public class DoubleLinkedListStack<E> implements Stack<E> {

    private DoubleLinkedList<E> doubleLinkedList;

    public DoubleLinkedListStack() {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int getSize() {
        return doubleLinkedList.getSize();
    }

    public boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }

    @Override
    public void push(E value) {
        doubleLinkedList.addToBeginning(value);
    }

    @Override
    public E pop() {
        if (doubleLinkedList.getSize() == 0) {
            throw new IllegalArgumentException("Cannot pop from empty stack");
        }
        return doubleLinkedList.removeFromBeginning();
    }

    @Override
    public E peek() {
        if (doubleLinkedList.getSize() == 0) {
            throw new IllegalArgumentException("Cannot peek empty stack");
        }
        return doubleLinkedList.get(0);
    }

    @Override
    public boolean contains(E element) {
        return doubleLinkedList.contains(element);
    }

    public void printStack() {
        doubleLinkedList.printListValueFirstToLast();
    }

}
