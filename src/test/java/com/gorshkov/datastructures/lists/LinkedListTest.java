package com.gorshkov.datastructures.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList list = new LinkedList();

    @BeforeEach
    void setUp() {

    }

    @Test
    void add() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
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

        list.remove(1);

        assertEquals(4, list.size);
        assertEquals("two", list.get(1));
    }

    @Test
    void get() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
    }

    @Test
    void set() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.set("Two", 2);

        for (int i = 0; i < 6; i++) {
            System.out.println(list.get(i));
        }
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
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertFalse(list.contains("test"));
        assertTrue(list.contains("two"));
    }

    @Test
    void indexOf() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assertEquals(2, list.indexOf("two"));
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
}