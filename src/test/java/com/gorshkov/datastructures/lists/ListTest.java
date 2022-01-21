package com.gorshkov.datastructures.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    private final List list = new LinkedList();

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
}
