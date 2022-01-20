package com.gorshkov.datastructures.lists;

import java.util.Objects;

public class ArrayList implements List {
    private final int INITIAL_CAPACITY = 4;

    private Object[] values;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;

    public ArrayList() {
        this.values = new Object[capacity];
    }

    public void add(Object value) {
        if (size >= capacity) {
            capacity *= 2;
            Object[] tmp = values;
            values = new Object[capacity];
            System.arraycopy(tmp, 0, values, 0, capacity / 2);
        }
        values[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            values[index] = value;
        }
    }

    @Override
    public Object remove(int index) {
        Object result = values[index];
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] tmp = values;
            System.arraycopy(tmp, 0, values, 0, index);
            System.arraycopy(tmp, index + 1, values, index, size - 1);
            values[size] = null;
        }
        return result;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else return values[index];
    }

    @Override
    public Object set(Object value, int index) {
        Object previousValue = values[index];
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            values[index] = value;
            return previousValue;
        }
    }

    @Override
    public void clear() {
        values = new Object[capacity];
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
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(values[i]);
            if (i < size - 1) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
