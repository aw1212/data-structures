package com.alex.structures.linkedlist;

public class DoubleLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public E getFirst() {
        return first.getValue();
    }

    public E getLast() {
        return last.getValue();
    }

    public int getSize() {
        return size;
    }

    public void addToEnd(E newNodeValue) {
        if (size == 0) {
            Node<E> newNode = new Node<E>(newNodeValue, null, null);
            first = newNode;
            last = newNode;
        } else {
            Node<E> oldLast = last;
            Node<E> newLast = new Node<E>(newNodeValue, oldLast, null);
            oldLast.setNext(newLast);

            last = newLast;
        }

        size++;
    }

    public void addToBeginning(E newNodeValue) {
        if (size == 0) {
            Node<E> newNode = new Node<E>(newNodeValue, null, null);
            first = newNode;
            last = newNode;
        } else {
            Node<E> oldFirst = first;
            Node<E> newFirst = new Node<E>(newNodeValue, null, oldFirst);
            oldFirst.setPrevious(newFirst);

            first = newFirst;
        }

        size++;
    }

    public E removeFromEnd() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            Node<E> onlyNode = first;
            first = null;
            last = null;
            size = 0;
            return onlyNode.getValue();
        }

        Node<E> oldLast = last;
        Node<E> newLast = last.getPrevious();

        newLast.setNext(null);
        last = newLast;

        size--;

        return oldLast.getValue();
    }

    public E removeFromBeginning() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            Node<E> onlyNode = first;
            first = null;
            last = null;
            size = 0;
            return onlyNode.getValue();
        }

        Node<E> oldFirst = first;
        Node<E> newFirst = first.getNext();

        newFirst.setPrevious(null);
        first = newFirst;

        size--;

        return oldFirst.getValue();
    }

    public void add(int index, E newNodeValue) {
        if (index < 0) {
            throw new IllegalArgumentException("Minimum index is 0");
        }

        if (index > size) {
            throw new IllegalArgumentException("Cannot add to index greater than size of list");
        }

        int counter = 0;


        while (counter < index) {
            // TODO
        }
    }

    public void remove(int index) {
        // TODO
    }

    public void removeFirstOccurence(E valueToRemove) {
        // TODO
    }

    private class Node<E> {

        private E value;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }

}
