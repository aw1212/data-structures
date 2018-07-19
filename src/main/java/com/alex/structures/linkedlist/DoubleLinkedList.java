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

    public void printList() {
        String nodes = getListString(first, "");
        System.out.println(nodes);
    }

    private String getListString(Node<E> node, String result) {
        if (node == null) {
            return result;
        }

        if (node.getNext() == null) {
            result += node;
        } else {
            result += node + " -> ";
        }
        return getListString(node.next, result);
    }

    public void addToEnd(E newNodeValue) {
        if (size == 0) {
            Node<E> newNode = new Node<>(newNodeValue, null, null);
            first = newNode;
            last = newNode;
        } else {
            Node<E> oldLast = last;
            Node<E> newLast = new Node<>(newNodeValue, oldLast, null);
            oldLast.setNext(newLast);

            last = newLast;
        }

        size++;
    }

    public void addToBeginning(E newNodeValue) {
        if (size == 0) {
            Node<E> newNode = new Node<>(newNodeValue, null, null);
            first = newNode;
            last = newNode;
        } else {
            Node<E> oldFirst = first;
            Node<E> newFirst = new Node<>(newNodeValue, null, oldFirst);
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
            throw new IndexOutOfBoundsException("Minimum index is 0");
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("Cannot add to index greater than size of list");
        }

        if (index == 0) {
            addToBeginning(newNodeValue);
        } else if (index == size) {
            addToEnd(newNodeValue);
        } else {
            int counter = 0;

            Node<E> nodeBefore = first;

            while (counter < index - 1) {
                nodeBefore = nodeBefore.getNext();
                counter++;
            }

            Node<E> nodeAfter = nodeBefore.getNext();


            Node<E> newNode = new Node<>(newNodeValue, nodeBefore, nodeAfter);

            nodeBefore.setNext(newNode);
            if (nodeAfter != null) {
                nodeAfter.setPrevious(newNode);
            }
        }

    }

    public E remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Minimum index is 0");
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("Cannot remove from index greater than size of list");
        }

        if (index == 0) {
            return removeFromBeginning();
        }

        if (index == size) {
            return removeFromEnd();
        }

        int counter = 0;

        Node<E> nodeBefore = first;

        while (counter < index - 1) {
            nodeBefore = nodeBefore.getNext();
            counter++;
        }

        Node<E> nodeToRemove = nodeBefore.getNext();

        Node<E> nodeAfter = nodeToRemove.getNext();

        nodeBefore.setNext(nodeAfter);
        if (nodeAfter != null) {
            nodeAfter.setPrevious(nodeBefore);
        }

        return nodeToRemove.value;
    }

    public E removeFirstOccurence(E valueToRemove) {
        Node<E> currentNode = first;

        for (int i = 0; i <= size; i++) {
            if (currentNode.getValue().equals(valueToRemove)) {
                return remove(i);
            }
            currentNode = currentNode.getNext();
        }

        return null;
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

        @Override
        public String toString() {
            String prev = previous == null ? "null" : previous.value.toString();
            String nxt = next == null ? "null" : next.value.toString();
            return "[" + prev + "|" + value + "|" + nxt +"]";
        }
    }

}