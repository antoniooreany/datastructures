package com.gorshkov.datastructures.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

    private static final int NUM_BUCKETS = 10;

    private int size = 0;
    private final Set<Entry<K, V>> entrySet = new HashSet<>();
    private final ArrayList<Entry<K, V>>[] buckets = new ArrayList[NUM_BUCKETS];

    public HashMap() {
        this.size = 0;
        for (int i = 0; i < NUM_BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    @Override
    public V put(K key, V value) {
        V previousValue = null;
        int bucketNumber = key.hashCode() % NUM_BUCKETS;
        for (Entry<K, V> entry : buckets[bucketNumber]) {
            if (Objects.equals(entry.key, key)) {
                previousValue = entry.value;
            }
        }
        Entry<K, V> entry = new Entry<>(key, value);
        buckets[bucketNumber].add(entry);
        entrySet.add(entry);
        size++;
        return previousValue;
    }

    @Override
    public V get(K key) {
        int bucketNumber = key.hashCode() % NUM_BUCKETS;
        for (Entry<K, V> entry : buckets[bucketNumber]) {
            if (Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int bucketNumber = key.hashCode() % NUM_BUCKETS;
        for (Entry<K, V> entry : buckets[bucketNumber]) {
            if (Objects.equals(entry.key, key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return entrySet.iterator();
    }
}
