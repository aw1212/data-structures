package com.alex.structures.tree;

public class BinaryMinHeap<E extends Comparable<E>> {

    private static final int DEFAULT_ARRAY_SIZE = 10;
    private int nextElementIndex;

    private E[] elements;

    public BinaryMinHeap() {
        elements = (E[]) new Object[DEFAULT_ARRAY_SIZE];
    }

    public void insert(E value) {
        if (nextElementIndex > elements.length) {
            // resize
        }

        elements[nextElementIndex] = value;
        siftUp(nextElementIndex);
        nextElementIndex++;
    }

    private void siftUp(int index) {
        int parentIndex = index / 2;
        while (index > 0 && elements[index].compareTo(elements[parentIndex]) < 0) {
            E temp = elements[index];
            elements[index] = elements[parentIndex];
            elements[parentIndex] = temp;
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = index * 2;
        int rightChildIndex = leftChildIndex + 1;

        // TODO make sure not to go out of bounds
        while (elements[index].compareTo(elements[leftChildIndex]) > 0 || elements[index].compareTo(elements[rightChildIndex]) > 0) {
            E temp = elements[index];
            if (elements[leftChildIndex].compareTo(elements[rightChildIndex]) < 0) {
                elements[index] = elements[leftChildIndex];
                elements[leftChildIndex] = temp;
                index = leftChildIndex;
            } else {
                elements[index] = elements[rightChildIndex];
                elements[rightChildIndex] = temp;
                index = rightChildIndex;
            }
        }
    }

}
