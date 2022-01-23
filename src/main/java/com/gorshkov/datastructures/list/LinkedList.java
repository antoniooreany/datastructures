package com.gorshkov.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList<V> implements List<V> {

    static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    private Node<V> first;
    private Node<V> last;
    private int size;

    @Override
    public void add(V value) {
        Node<V> newNode = new Node<>(value);
        if (first == null) {
            first = last = newNode;
        } else {
            this.last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(V value, int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is less than zero");
        }
        if (index >= size - 1) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is is larger than size");
        }
        Node<V> newNode = new Node<>(value);
        if (first == null) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        } else {
            Node<V> cursor = getNode(index - 1);
            newNode.next = cursor.next;
            cursor.next = newNode;
        }
        size++;
    }

    @Override
    public V remove(int index) {
        Node<V> cursor;
        Node<V> prev;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            cursor = first.next;
            prev = first;
            for (int i = 0; i < index - 1; i++) {
                cursor = cursor.next;
            }
            prev.next = cursor.next;
        }
        size--;
        return cursor.value;
    }

    @Override
    public V get(int index) {
        Node<V> cursor;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            cursor = first;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            return cursor.value;
        }
    }

    @Override
    public V set(V value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        }
        Node<V> node = getNode(index);
        V prevValue = node.value;
        node.value = value;
        return prevValue;
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
    public boolean contains(V value) {
        Node<V> current = first;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
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
        int result = -1;
        Node<V> cursor = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(cursor.value, value)) {
                result = i;
            }
            cursor = cursor.next;
        }
        return result;
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
        return new Iterator<>() {
            Node<V> cursor = first;
            int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public V next() {
                Node<V> tmpNode = cursor;
                index++;
                cursor = cursor.next;
                return tmpNode.value;
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
}
