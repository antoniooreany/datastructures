package com.gorshkov.datastructures.lists;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList<V> implements List, Iterable {
    private final int INITIAL_CAPACITY = 4;

    private V[] values;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;

    public ArrayList() {
        this.values = (V[]) new Object[capacity];
    }

    @Override
    public void add(Object value) {
        if (size >= capacity) {
            capacity *= 2;
            Object[] tmp = values;
            values = (V[]) new Object[capacity];
            System.arraycopy(tmp, 0, values, 0, capacity / 2);
        }
        values[size] = (V) value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            values[index] = (V) value;
        }
    }

    @Override
    public V remove(int index) {
        V result = values[index];
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            V[] tmp = values;
            System.arraycopy(tmp, 0, values, 0, index);
            System.arraycopy(tmp, index + 1, values, index, size - 1);
            values[size] = null;
        }
        return result;
    }

    @Override
    public V get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else return values[index];
    }

    @Override
    public V set(Object value, int index) {
        V previousValue = values[index];
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            values[index] = (V) value;
            return previousValue;
        }
    }

    @Override
    public void clear() {
        values = (V[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add((CharSequence) values[i]);
        }
        return joiner.toString();
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            V cursor = values[0];
            static int index;

            @Override
            public boolean hasNext() {
                return next() != null;
            }

            @Override
            public V next() {
                return values[index++];
            }

            @Override
            public void remove() {
                Iterator.super.remove();
                //TODO implement it: remove cursor
            }
        };
    }
}
