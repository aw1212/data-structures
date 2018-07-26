package com.alex.structures.list;

public class SingleLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void addToBeginning(E value) {
        if (size == 0) {
            addFirstNode(value);
        } else {
            Node<E> newNode = new Node<>(value, first);
            first = newNode;
        }

        size++;
    }

    public void addToEnd(E value) {
        if (size == 0) {
            addFirstNode(value);
        } else {
            Node<E> newNode = new Node<>(value, null);
            last.setNext(newNode);
            last = newNode;
        }

        size++;
    }

    private void addFirstNode(E value) {
        Node<E> node = new Node<>(value, null);
        first = node;
        last = node;
    }

    public E removeFromBeginning() {
        E value = first.getValue();

        first = first.getNext();

        size--;

        return value;
    }

    public E removeFromEnd() {
        E value = last.getValue();

        Node<E> current = first;
        while (!current.getNext().equals(last)) {
            current = current.getNext();
        }

        current.setNext(null);

        last = current;

        size--;

        return value;
    }

    private class Node<E> {

        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
