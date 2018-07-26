package com.alex.structures.queue;

public interface Queue<E> {

    void enqueue(E value);

    E dequeue();

    int getSize();

}
