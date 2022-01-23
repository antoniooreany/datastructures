package com.gorshkov.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList<V> implements List<V>, Iterable<V> {
    private final int INITIAL_CAPACITY = 4;
    private final double LOAD_FACTOR = 1.5;

    private V[] values;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;

    public ArrayList() {
        this.values = (V[]) new Object[capacity];
    }

    @Override
    public void add(V value) {
//        if (size >= capacity) {
//            capacity *= LOAD_FACTOR;
//            Object[] tmp = values;
//            values = (V[]) new Object[capacity];
//            System.arraycopy(tmp, 0, values, 0, capacity / 2);
//        }
//        values[size] = value;
//        size++;

        if (values.length >= size) {
            increaseSize();
        }
        values[size] = value;
        size++;
    }

    @Override
    public void add(V value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            values[index] = value;
        }
    }

    @Override
    public V remove(int index) {
        V result = values[index];
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            V[] tmp = values;
            System.arraycopy(tmp, 0, values, 0, index);
            System.arraycopy(tmp, index + 1, values, index, size - 1);
            values[size] = null;
        }
        size--;
        return result;
    }

    @Override
    public V get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else return values[index];
    }

    @Override
    public V set(V value, int index) {
        V previousValue = values[index];
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
        } else {
            values[index] = value;
            return previousValue;
        }
    }

    @Override
    public void clear() {
        values = (V[]) new Object[capacity];
        size = 0;
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
    public boolean contains(V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(V value) {
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
    public Iterator<V> iterator() {

        return new Iterator<>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public V next() {
                return values[++index];
            }

            @Override
            public void remove() {
                ArrayList.this.remove(index - 1);
            }
        };
    }

    private void increaseSize() {
        V[] tmpValues = (V[]) new Object[(int) (values.length * LOAD_FACTOR)];
        System.arraycopy(values, 0, tmpValues, 0, size);
        values = tmpValues;

    }
}
