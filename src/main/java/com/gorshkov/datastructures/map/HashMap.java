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
        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucketNumber = getBucketNumber(key);
        for (Entry<K, V> entry : buckets[bucketNumber]) {
            if (Objects.equals(entry.key, key)) {
                previousValue = entry.value;
                entry.value = value;
//                buckets[bucketNumber].remove(entry);
            }
        }
        buckets[bucketNumber].add(newEntry);
        entrySet.add(newEntry);
        size++;
        return previousValue;
    }

    @Override
    public V get(K key) {
        int bucketNumber = getBucketNumber(key);
        for (Entry<K, V> entry : buckets[bucketNumber]) {
            if (Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int bucketNumber = getBucketNumber(key);
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
//        return entrySet.iterator();
        return new Iterator<Entry<K, V>>() {
            Iterator<Entry<K, V>> bucketIterator = buckets[0].iterator();
            int currentBucketIndex = 0;

            @Override
            public boolean hasNext() {
                if (!bucketIterator.hasNext()) {
                    if (currentBucketIndex >= NUM_BUCKETS) {
                        return false;
                    } else {
                        return buckets[currentBucketIndex + 1].iterator().hasNext();
                    }
                } else {
                    return true;
                }
            }

            @Override
            public Entry<K, V> next() {
                if (!bucketIterator.hasNext()) {
                    if (currentBucketIndex >= NUM_BUCKETS) {
                        return null;
                    } else {
                        return buckets[++currentBucketIndex].iterator().next();
                    }
                } else {
                    return bucketIterator.next();
                }
            }
        };
    }

    private int getBucketNumber(K key) {
        return Math.abs(key.hashCode() % NUM_BUCKETS);
    }
}
