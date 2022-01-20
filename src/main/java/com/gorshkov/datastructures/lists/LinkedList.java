package com.gorshkov.datastructures.lists;

import java.util.Iterator;

public class LinkedList implements List, Iterable {

    private Node first;
    private Node last;
    private int size;

    static class Node {

        Object value;
        Node next;
        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
    @Override
    public void add(Object value) {
        if (last != null) {
            last.next = new Node(value, null);
            last = last.next;
        } else {
            first = new Node(value, null);
            last = first;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current = new Node(value, current.next);
            // TODO change the implementation to work correctly
        }
    }

    @Override
    public Object remove(int index) {
        Node current;
        Node prev;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
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
    public Object get(int index) {
        Node current;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    @Override
    public Object set(Object value, int index) {
        Node current;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node(value, current.next);
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
        Node current = first;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        int result = 0;
        Node current = first;
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
    public Iterator iterator() {
        return new Iterator() {
            Node cursor = first;

            @Override
            public boolean hasNext() {
                cursor = cursor.next;
                return cursor == null;
            }

            @Override
            public Object next() {
                cursor = cursor.next;
                return cursor;
            }

            @Override
            public void remove() {
                //TODO implement it
            }
        };
    }
}
