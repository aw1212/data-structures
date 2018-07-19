package com.alex.structures.stack;

public class ArrayStack<E> {

    private static final int DEFAULT_START_SIZE = 5;

    private E[] stackArray;
    private int size;
    private int headIndex;

    public ArrayStack() {
        stackArray = (E[])new Object[DEFAULT_START_SIZE];
    }

    public ArrayStack(int startSize) {
        stackArray = (E[])new Object[startSize];
    }

    public void push(E value) {
        if (stackArray.length == size) {
            // copy over to bigger array
        }
        stackArray[size] = value;
        headIndex = size;
        size++;
    }

    public E pop() {
        if (size == 0) {
            throw new IllegalArgumentException("Cannot pop from empty stack");
        }

        E element = stackArray[headIndex];
        stackArray[headIndex] = null;
        headIndex--;
        size--;
        return element;
    }

    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Cannot peek an empty stack");
        }

        return stackArray[headIndex];
    }

    public void printStack() {
        for (int i = 0; i < size; i++) {
            if (i == headIndex) {
                System.out.print("[" + stackArray[i] + "]");
            } else {
                System.out.print(stackArray[i]);
            }
        }
    }

}
