package com.gorshkov.datastructures.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {

    ArrayList<String> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
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
        list.add("Two", 1);
        assertEquals("Two", list.get(1));
    }

    @Test
    void remove() {
        Object o = list.remove(1);
        assertEquals("two", o);
        assertEquals("one", list.get(0));
        assertEquals("three", list.get(1));
        assertEquals("four", list.get(2));
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
        Object previousValue = list.set("Three", 2);
        assertEquals("three", previousValue);
    }

    @Test
    void clear() {
        list.clear();
        assertNull(list.get(0));
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
        assertTrue(list.contains("two"));
    }

    @Test
    void indexOf() {
        assertEquals(2, list.indexOf("three"));
    }

    @Test
    void lastIndexOf() {
        list.add("two", 3);
        assertEquals(3, list.lastIndexOf("two"));
    }

    @Test
    void toStringTest() {
        assertEquals("[one, two, three, four, five]", list.toString());
    }

    @Test
    void iteratorTest() {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}