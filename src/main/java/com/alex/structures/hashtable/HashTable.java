package com.alex.structures.hashtable;

public class HashTable<K, V> {

    private static final int DEFAULT_DATA_SIZE = 10;
    private Node<K, V>[] data;
    private int size;

    public HashTable() {
        data = (Node<K, V>[]) new Node[DEFAULT_DATA_SIZE];
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        Node<K, V> entry = new Node<>(key, value, null);

        int index = getIndex(key);

        if (data[index] == null) {
            data[index] = entry;
            size++;
        } else {
            Node<K, V> current = data[index];
            while (current.getNext() != null) {
                if (current.getKey().equals(key)) {
                    entry.setNext(current.getNext());
                    current = entry;
                    break;
                }
                if (current.getKey() == null) {
                    current.setNext(entry);
                    size++;
                }
                current = current.getNext();
            }
        }
    }

    public boolean hasKey(K key) {
        int index = getIndex(key);
        Node<K, V> dataAtIndex = data[index];

        if (dataAtIndex == null) {
            return false;
        }

        if (dataAtIndex.getKey().equals(key)) {
            return true;
        }

        Node<K, V> next = dataAtIndex.getNext();
        if (next == null) {
            return false;
        }

        while (next != null) {
            if (next.getKey().equals(key)) {
                return true;
            }
            next = next.getNext();
        }

        return false;
    }

    public V get(K key) {
        int index = getIndex(key);

        if (data[index] == null) {
            return null;
        }

        Node<K, V> current = data[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);

        Node<K, V> first = data[index];

        if (first == null) {
            return null;
        }

        if (first.getKey().equals(key)) {
            // first element is the one we are looking for
            Node<K, V> second = first.getNext();
            if (second != null) {
                // There are more in the list so set the next one to be the new first
                data[index] = second;
            } else {
                // There was only one in the bucket so now the bucket will be empty;
                data[index] = null;
            }
            size--;
            return first.getValue();
        } else if (first.getNext() == null) {
            // It's not the first element and there are no more to check
            return null;
        }

        // First element is not the one and there are more to check
        Node<K, V> current = first.getNext();

        do {
            if (current.getKey().equals(key)) {
                Node<K, V> next = current.getNext();
                if (next != null) {
                    // set next.previous.next to next
                } else {
                    // set previous.next to null
                }
                size--;
                return current.getValue();
            }
            current = current.getNext();
        } while (current != null);

        return null;
    }

    private int getIndex(K key) {
        int hashcode = key.hashCode();
        return hashcode % data.length;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
