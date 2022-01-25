package com.gorshkov.datastructures.map;

import java.util.Iterator;
import java.util.Set;

public interface Map<K, V> {

    V put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    int size();

    Set<Entry<K, V>> entrySet();

    default Iterator<Entry<K, V>> iterator() {
        return null;
    }
}

