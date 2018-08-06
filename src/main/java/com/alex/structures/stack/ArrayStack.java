package com.alex.structures.stack;

public class ArrayStack<E> implements Stack<E> {

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

    @Override
    public void push(E value) {
        if (stackArray.length == size) {
            E[] newArray = (E[]) new Object[stackArray.length * 2];
            for (int i = 0; i < stackArray.length; i++) {
                newArray[i] = stackArray[i];
                stackArray = newArray;
            }
        }
        stackArray[size] = value;
        headIndex = size;
        size++;
    }

    @Override
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

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Cannot peek an empty stack");
        }

        return stackArray[headIndex];
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (stackArray[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void printStack() {
        int index = headIndex;
        while (index >= 0) {
            System.out.print(" " + stackArray[index] + " ");
            index--;
        }
    }

}
