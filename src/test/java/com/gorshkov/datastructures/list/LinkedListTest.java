package com.gorshkov.datastructures.list;

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
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
    }

    @Test
    void testAdd() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.add("Two", 1);

        assertEquals("Two", list.get(1));

    }

    @Test
    void remove() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.remove(1);

        assertEquals(4, list.size());
        assertEquals("three", list.get(1));
    }

    @Test
    void get() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals("four", list.get(3));
        assertEquals("five", list.get(4));
    }

    @Test
    void set() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.set("Two", 1);

        for (int i = 0; i < 6; i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    void clear() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    void size() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertFalse(list.contains("test"));
        assertTrue(list.contains("two"));
    }

    @Test
    void indexOf() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        assertEquals(1, list.indexOf("two"));
    }

    @Test
    void lastIndexOf() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.add("two");

        assertEquals(5, list.lastIndexOf("two"));
    }

    @Test
    void toStringTest() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals("[zero, one, two, three, four]", list.toString());
    }
}