package com.gorshkov.datastructures.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    private final HashMap<Integer, String> map = new HashMap<>();

    private static final int SIZE = 5;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < SIZE; i++) {
            map.put(i, "_" + i);
        }
    }

    @Test
    void put() {
        assertEquals("_0", map.get(0));
        assertEquals("_1", map.get(1));
        assertEquals("_2", map.get(2));
        assertEquals("_3", map.get(3));
        assertEquals("_4", map.get(4));
    }

    @Test
    void get() {
        assertEquals("_0", map.get(0));
        assertEquals("_1", map.get(1));
        assertEquals("_2", map.get(2));
        assertEquals("_3", map.get(3));
        assertEquals("_4", map.get(4));
    }

    @Test
    void containsKey() {
        assertTrue(map.containsKey(0));
        assertTrue(map.containsKey(1));
        assertTrue(map.containsKey(2));
        assertTrue(map.containsKey(3));
        assertTrue(map.containsKey(4));

        assertFalse(map.containsKey(5));
    }

    @Test
    void size() {
        assertEquals(5, map.size());
    }

    @Test
    void entrySet() {
        Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();

        assertEquals("_0", iterator.next().value);
        assertEquals("_3", iterator.next().value);
        assertEquals("_1", iterator.next().value);
        assertEquals("_4", iterator.next().value);
        assertEquals("_2", iterator.next().value);
    }

    @Test
    void iteratorHasNext() {
        Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());

        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorNext() {
        Iterator<Entry<Integer, String>> iterator = map.iterator();

        assertEquals("_0", iterator.next().value);
        assertEquals("_1", iterator.next().value);
        assertEquals("_2", iterator.next().value);
        assertEquals("_3", iterator.next().value);
        assertEquals("_4", iterator.next().value);

        assertNull(iterator.next());
        assertNull(iterator.next());

    }
}