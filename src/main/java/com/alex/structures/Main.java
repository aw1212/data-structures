package com.alex.structures;

import com.alex.structures.queue.ArrayQueue;

public class Main {

    public static void main(String[] args) {


        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);

        arrayQueue.printQueueAsIs();

        arrayQueue.dequeue();
        arrayQueue.dequeue();

        arrayQueue.printQueueAsIs();

        arrayQueue.enqueue(6);
        arrayQueue.enqueue(7);

        arrayQueue.printQueueAsIs();

        arrayQueue.enqueue(8);

        arrayQueue.printQueueAsIs();

        arrayQueue.dequeue();

        arrayQueue.printQueueAsIs();

        arrayQueue.enqueue(9);

        arrayQueue.printQueueAsIs();

        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        System.out.println();
        arrayQueue.printQueue();
        arrayQueue.printQueueAsIs();

    }

}
