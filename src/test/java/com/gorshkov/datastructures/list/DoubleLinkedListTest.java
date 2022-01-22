package com.gorshkov.datastructures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    private DoubleLinkedList<String> list = new DoubleLinkedList<>();

    @Test
    void add() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals("zero", list.get(0));


    }

    @Test
    void testAdd() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.add("Two", 2);

        assertEquals("Two", list.get(2));
    }

    @Test
    void remove() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals(5, list.size());
        list.remove(2);
        assertEquals(4, list.size());
    }

    @Test
    void get() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals("two", list.get(2));
    }

    @Test
    void set() {
        list.set("Two", 2);
        assertEquals("Two", list.get(2));
    }

    @Test
    void clear() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(list.contains("two"));
    }

    @Test
    void indexOf() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals("two", list.get(2));
    }

    @Test
    void lastIndexOf() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.add("two");

        assertEquals(5, list.lastIndexOf("two"));
    }

    @Test
    void testToString() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals("[zero, one, two, three, four]", list.toString());
    }

    @Test
    void iteratorHasNext() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertTrue(list.iterator().hasNext());
        assertTrue(list.iterator().hasNext());
        assertTrue(list.iterator().hasNext());
        assertTrue(list.iterator().hasNext());
        assertTrue(list.iterator().hasNext());
        assertFalse(list.iterator().hasNext());
    }

    @Test
    void iteratorNext() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals("zero", list.iterator().next());
        assertEquals("one", list.iterator().next());
        assertEquals("two", list.iterator().next());
        assertEquals("three", list.iterator().next());
        assertEquals("four", list.iterator().next());
    }

    @Test
    void iteratorRemove() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.iterator().remove();
        assertEquals("one", list.iterator().next());
    }
}