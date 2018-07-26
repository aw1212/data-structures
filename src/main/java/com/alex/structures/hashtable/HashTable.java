package com.alex.structures.hashtable;

public class HashTable<K, V> {

    private static final int DEFAULT_DATA_SIZE = 10;

    private Node<K, V>[] data;
    private int size;

    public HashTable() {
        data = (Node<K, V>[]) new Node[DEFAULT_DATA_SIZE];
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
