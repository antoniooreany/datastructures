package com.gorshkov.datastructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ListTest<V> {

    private final List<V> list = getList();

    abstract List<V> getList();

    @BeforeEach
    public void init() {
        list.add((V) "one");
        list.add((V) "two");
        list.add((V) "three");
        list.add((V) "four");
        list.add((V) "five");
    }

    @Test
    void add() {
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
    }

    @Test
    void testAdd() {
        list.add((V) "Two", 1);
        assertEquals("Two", list.get(1));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add((V) "minus one", -1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add((V) "plus six", 6));
    }

    @Test
    void remove() {
        assertEquals(5, list.size());
        list.remove(1);
        assertEquals(4, list.size());
        assertEquals("three", list.get(1));
    }

    @Test
    void get() {
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
    }

    @Test
    void set() {
        list.set((V) "Two", 1);
        assertEquals("Two", list.get(1));
    }

    @Test
    void clear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(list.contains((V) "test"));
        assertTrue(list.contains((V) "two"));
    }

    @Test
    void indexOf() {
        assertEquals(1, list.indexOf((V) "two"));
    }

    @Test
    void lastIndexOf() {
        list.add((V) "two");
        assertEquals(5, list.lastIndexOf((V) "two"));
    }

    @Test
    void toStringTest() {
        assertEquals("[one, two, three, four, five]", list.toString());
    }

    @Test
    void hasNextIteratorTest() {
        Iterator<V> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("one", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("two", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("three", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("four", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("five", iterator.next());
    }

    @Test
    void nextIteratorTest() {
        Iterator<V> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            iterator.next();
        }

        assertFalse(iterator.hasNext());
    }

    @Test
    void removeIteratorTest() {
        Iterator<V> iterator = list.iterator();
        iterator.remove();

        assertEquals("two", iterator.next());
    }
}
