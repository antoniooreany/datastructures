package com.gorshkov.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoubleLinkedList<V> implements List<V>, Iterable<V> {

    private Node<V> first;
    private Node<V> last;
    private int size;

    @Override
    public void add(V value) {
        add(value, size);
    }

    @Override
    public void add(V value, int index) {
        if (index > size) {
            throw new IllegalArgumentException("index = " + index + ", larger than size = " + size);
        }
        Node<V> cursor = getNode(index);
        if (cursor == null) {
            first = new Node<V>(null, value, null);
        } else if (cursor.prev == null && cursor.next == null) {
            Node<V> newNode = new Node<>(null, value, cursor);
            newNode.prev.next = newNode;
            first = newNode;
        } else if (cursor.next == null) { // TODO Adds an element in an incorrect order.
            Node<V> newNode = new Node<>(null, value, cursor);
            newNode.prev.next = newNode;
            first = newNode;
        } else { // TODO Adds an element in an incorrect order.
            Node<V> newNode = new Node<V>(cursor.next, value, cursor);
            newNode.next.prev = newNode;
            cursor.prev = newNode;
        }
        size++;
    }

    @Override
    public V remove(int index) {
        Node<V> cursor = getNode(index);
        if (cursor == null) {
            throw new IndexOutOfBoundsException("The list is empty. Nothing to remove.");
        } else if (cursor.prev == null && cursor.next == null) {
            first = null;
        } else if (cursor.prev == null) {
            cursor.next.prev = null;
            first = cursor.next;
        } else {
            cursor.next.prev = cursor.prev;
            cursor.prev.next = cursor.next;
        }
        return cursor.value;
    }

    @Override
    public V get(int index) {
        Node<V> cursor = getNode(index);
        return cursor.value;
    }

    @Override
    public V set(V value, int index) {
        Node<V> cursor = getNode(index);
        V prevValue = cursor.value;
        cursor.value = value;
        return prevValue;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(V value) {
        Node<V> cursor = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(cursor.value, value)) {
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    @Override
    public int indexOf(V value) {
        Node<V> cursor = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(cursor.value, value)) {
                return i;
            }
            cursor = cursor.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(V value) {
        Node<V> cursor = last;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(cursor.value, value)) {
                return i;
            }
            cursor = cursor.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<V> cursor = first;
        for (int i = 0; i < size; i++) {
            joiner.add((CharSequence) cursor.value);
            cursor = cursor.next;
        }
        return joiner.toString();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            Node<V> cursor = first;

            @Override
            public boolean hasNext() {
                return next() != null;
            }

            @Override
            public V next() {
                cursor = cursor.next;
                return cursor.value;
            }

            @Override
            public void remove() {
                cursor = cursor.next;
            }
        };
    }

    private Node<V> getNode(int index) {
        Node<V> cursor = first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

    private static class Node<V> {
        Node<V> next;
        V value;
        Node<V> prev;

        public Node(Node<V> next, V value, Node<V> prev) {
            this.next = next;
            this.value = value;
            this.prev = prev;
        }
    }
}
