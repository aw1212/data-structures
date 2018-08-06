package com.alex.structures.stack;

public interface Stack<E> {

    void push(E element);

    E pop();

    E peek();

    boolean contains(E element);

    boolean isEmpty();

    int getSize();

}
