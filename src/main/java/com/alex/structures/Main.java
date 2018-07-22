package com.alex.structures;

import com.alex.structures.linkedlist.DoubleLinkedList;
import com.alex.structures.queue.ArrayQueue;
import com.alex.structures.queue.LinkedListQueue;
import com.alex.structures.stack.ArrayStack;
import com.alex.structures.stack.LinkedListStack;

public class Main {

    public static void main(String[] args) {
//        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
//        doubleLinkedList.addToBeginning(2);
//        doubleLinkedList.addToEnd(3);
//        doubleLinkedList.addToBeginning(1);
//
//        doubleLinkedList.printListValueFirstToLast();
//        doubleLinkedList.printListValueLastToFirst();

//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//
//        linkedListStack.push(3);
//        linkedListStack.push(2);
//        linkedListStack.push(1);
//
//        linkedListStack.printStack();

//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//
//        arrayStack.push(1);
//        arrayStack.push(2);
//        arrayStack.push(3);
//
//        arrayStack.printStack();

//        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
//        linkedListQueue.enqueue(1);
//        linkedListQueue.enqueue(2);
//        linkedListQueue.enqueue(3);
//
//        linkedListQueue.printQueue();

        //1 2 3 4 5
        //[] [] 3 4 5
        //6 7 3 4 5
        //3 4 5 6 7 8 [] [] [] []
        //[] 4 5 6 7 8 [] [] [] []
        //[] 4 5 6 7 8 9 [] [] []

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
