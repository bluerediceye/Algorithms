package com.algorithms.amazon9;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created on 31/03/2017
 *
 * @author Ming Li
 */

class LRUCache1 extends LinkedHashMap {
    private final int MAX_CACHE_SIZE;


    LRUCache1(int max_cache_size) {
        super((int) (Math.ceil(max_cache_size / 0.75f) + 1), 0.75f, true);
        MAX_CACHE_SIZE = max_cache_size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return MAX_CACHE_SIZE > size();
    }

    public static void main(String[] args) {
        final int cacheSize = 10;
//        Map cache = new LRUCache1(cacheSize);
        Map<Object, Object> cache = new LinkedHashMap<Object, Object>((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cacheSize < size();
            }
        };

        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);
        cache.put(8, 8);
        cache.put(9, 9);

        cache.get(9);
        cache.get(0);

        cache.put(10, 10);
        cache.put(11, 11);


        System.out.println(cache);

    }
}

class LRUCache2 {
    private final int MAX_CACHE_SIZE;
    private final Map<Object, Object> cache;

    public LRUCache2(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        cache = Collections.synchronizedMap(
                new LinkedHashMap<Object, Object>((int) Math.ceil(cacheSize / 0.75 + 1), 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                        return size() > MAX_CACHE_SIZE;
                    }
                });
    }

    public int size() {
        return cache.size();
    }

    public Object get(Object key) {
        return cache.get(key);
    }

    public Object put(Object key, Object value) {
        return cache.put(key, value);
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(10);
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);
        cache.put(8, 8);
        cache.put(9, 9);

        cache.get(9);
        cache.get(0);

        cache.put(10, 10);
        cache.put(11, 11);

        System.out.println(cache);
    }
}

class LRUCache3<K, V> {

    private java.util.HashMap<K, Entry<K, V>> cache;
    private Entry<K, V> first, last;

    public LRUCache3(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        cache = new HashMap<K, Entry<K, V>>((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f);
    }

    private final int MAX_CACHE_SIZE;

    static class Entry<K, V> {
        Entry<K, V> pre, next;
        K key;
        V value;

        @Override
        public String toString() {
            return "{" + key + "," + value + "}";
        }
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    public V remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return null;

        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry == first) {
            first = entry.next;
        }
        if (entry == last) {
            last = entry.pre;
        }

        return cache.remove(key).value;

    }

    public V put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {

            if (cache.size() >= MAX_CACHE_SIZE) {
                removeLast();
            }

            entry = new Entry<>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        cache.put(key, entry);
        return entry.value;
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return entry.value;
    }

    private void moveToFirst(Entry<K, V> entry) {
        if (first == entry) return;
        if (entry == last) last = last.pre;
        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            cache.remove(last.key);
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }

    public int size() {
        return cache.size();
    }

    private Entry<K, V> getEntry(K key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        LRUCache3<Object, Object> cache = new LRUCache3<>(10);
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);
        cache.put(8, 8);
        cache.put(9, 9);

        cache.get(9);
        cache.get(0);

        cache.put(10, 10);
        cache.put(11, 11);
        cache.put(12, 12);

        cache.remove(4);
        cache.remove(5);

        System.out.println(cache);
        System.out.println(cache.size());
    }
}

class LRU<K, V> {

    private Entry<K, V> first, last;
    private Map<K, Entry<K,V>> store;
    private int MAX_CACHE_SIZE;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> pre, next;
    }

    public LRU(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        this.store = new HashMap<K, Entry<K,V>>((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f);
    }

    public V get(K key){
        Entry<K, V> entry = getEntry(key);

        if(entry == null){
            return null;
        }

        moveToFirst(entry);
        return entry.value;
    }

    private void moveToFirst(Entry<K, V> entry) {
        if(entry == first) return;

        if(entry == last) last = last.pre;

        if(first == null || last == null){
            first = last = entry;
        }

        if(entry.pre != null){
            entry.pre.next = entry.next;
        }

        if(entry.next != null){
            entry.next.pre = entry.pre;
        }

        entry.next = first;
        first.pre = entry;
        entry.pre = null;
        first = entry;
    }

    private Entry<K, V> getEntry(K key) {
        return store.get(key);
    }

    public void remove(K key){
        Entry<K, V> entry = getEntry(key);
        if(entry != null){
            store.remove(key);

            if(entry.pre != null){
                entry.pre.next = entry.next;
            }

            if(entry.next != null){
                entry.next.pre = entry.pre;
            }

            if(first == entry){
                first = entry.next;
            }

            if(last == entry){
                last = last.pre;
            }
        }
    }

    public void put(K key, V value){
        Entry<K, V> entry = getEntry(key);

        if(entry == null){
            entry = new Entry<K, V>();
            entry.key = key;
            if(store.size() >= MAX_CACHE_SIZE){
                store.remove(key);
                removeLast();
            }
        }
        entry.value = value;
        moveToFirst(entry);
        store.put(key, entry);
    }

    private void removeLast() {

        if(last != null){
            store.remove(last.key);
            last = last.pre;
            if(last !=null) last.next =null;
            else first = null;
        }
    }

}
