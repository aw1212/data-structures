package com.alex.structures.queue;

public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_START_SIZE = 5;
    private Integer headIndex;
    private int size;
    private E[] queue;

    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_START_SIZE];
    }

    public void printQueueAsIs() {
        StringBuilder result = new StringBuilder();

        //move everything from headIndex -> end into new array
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == null) {
                result.append(" " + "[]" + " ");
            } else {
                result.append(" ").append(queue[i]).append(" ");
            }
        }

        System.out.println(result);
    }

    public void printQueue() {
        String queue = getQueueString();

        System.out.println(queue);
    }

    public String getQueueString() {
        StringBuilder result = new StringBuilder();

        if (headIndex == null) {
            return "empty queue";
        }

        //move everything from headIndex -> end into new array
        for (int i = headIndex; i < queue.length; i++) {
            if (queue[i] != null) {
                result.append(" ").append(queue[i]).append(" ");
            }
        }

        //move everything from 0 -> headIndex-1 into new array
        for (int i = 0; i < headIndex; i++) {
            if (queue[i] != null) {
                result.append(" ").append(queue[i]).append(" ");
            }
        }

        return result.toString();
    }

    @Override
    public void enqueue(E value) {
        if (size == queue.length) {
            growAndReAllocate();
        }

        int index = 0;
        if (headIndex == null) {
            headIndex = index;
        } else {
            index = getNextFreeIndex();
        }

        queue[index] = value;
        size++;
    }

    private int getNextFreeIndex() {

        for (int i = headIndex; i < queue.length; i++) {
            if (queue[i] == null) {
                return i;
            }
        }

        for (int i = 0; i < headIndex; i++) {
            if (queue[i] == null) {
                return i;
            }
        }

        throw new IllegalStateException("No free slots");
    }

    private void growAndReAllocate() {
        E[] copy = (E[]) new Object[queue.length * 2];
        int copyIndex = 0;

        //move everything from headIndex -> end into new array
        for (int i = headIndex; i < queue.length; i++) {
            copy[copyIndex] = queue[i];
            copyIndex++;
        }

        //move everything from 0 -> headIndex-1 into new array
        for (int i = 0; i < headIndex; i++) {
            copy[copyIndex] = queue[i];
            copyIndex++;
        }

        //set headIndex to 0
        headIndex = 0;

        //set copy to backing array
        queue = copy;
    }

    @Override
    public E dequeue() {
        if (headIndex == null) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }

        // get current head of queue value
        E value = queue[headIndex];

        // set current head of queue spot to null
        queue[headIndex] = null;

        size--;

        // set head of queue to next in line - or null if empty queue
        if (size == 0) {
            headIndex = null;
        } else if (headIndex == size - 1) {
            headIndex = 0;
        } else{
            headIndex++;
        }

        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
