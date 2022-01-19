package com.gorshkov.lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    LinkedList list = new LinkedList();

    @BeforeEach
    void setUp() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
    }

    @Test
    void add() {
        assertEquals("zero", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two", list.get(2));
        assertEquals("three", list.get(3));
        assertEquals("four", list.get(4));
    }

    @Test
    void testAdd() {
        // TODO
    }

    @Test
    void remove() {
        list.remove(1);
        for (int i = 0; i < 5; i++) {
            System.out.print(list.size + " ");
            System.out.println(list.get(i));
        }
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }
}