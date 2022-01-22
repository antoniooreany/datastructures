package com.gorshkov.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList<V> implements List, Iterable {

    private Node<V> first;
    private Node<V> last;
    private int size;

    @Override
    public void add(Object value) {
        if (last != null) {
            last.next = new Node<V>((V) value, null);
            last = last.next;
        } else {
            first = new Node<V>((V) value, null);
            last = first;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            Node<V> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current = new Node<V>((V) value, current.next);
            // TODO change the implementation to work correctly
        }
    }

    @Override
    public V remove(int index) {
        Node<V> current;
        Node<V> prev;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            current = first.next;
            prev = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            prev.next = current.next;
        }
        size--;
        return current.value;
    }

    @Override
    public V get(int index) {
        Node<V> current;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    @Override
    public V set(Object value, int index) {
        Node<V> current;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<V>((V) value, current.next);
            size++; //TODO Make it to set, not to push
            return current.value;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
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
    public boolean contains(Object value) {
        Node<V> current = first;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        int result = 0;
        Node<V> current = first;
        while (current != null) {
            if (current.value.equals(value)) return result;
            result++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0; //TODO implement it
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
                cursor = cursor.next;
                return cursor == null;
            }

            @Override
            public V next() {
                cursor = cursor.next;
                return (V) cursor;
            }

            @Override
            public void remove() {
                cursor = cursor.next;
            }
        };
    }

    static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }
}
