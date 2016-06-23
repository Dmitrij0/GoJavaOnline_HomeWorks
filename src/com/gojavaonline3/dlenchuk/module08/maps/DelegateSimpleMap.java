package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.*;

public abstract class DelegateSimpleMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Set<Entry<K, V>> items;

    public DelegateSimpleMap() {
        clear();
    }

    public DelegateSimpleMap(Map<K, V> map) {
        this();
        putAll(map);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        return items
                .stream()
                .filter(item -> item.getKey().equals((K)key)).count() != 0;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry item : items) {
            if (item.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        final Entry<K, V> item = findEntry((K) key);
        return item == null ? null : item.getValue();
    }

    public Entry<K, V> findEntry(K key) {
        try {
            return items
                    .stream()
                    .filter(item -> item.getKey().equals(key))
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> item = this.findEntry(key);
        V result = null;
        if (item == null) {
            items.add(new Item<>(key, value));
        } else {
            result = item.getValue();
            item.setValue(value);
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V result = this.get(key);
        Entry<K, V> entry = this.findEntry((K) key);
        if (entry == null) {
            return null;
        } else {
            items.remove(entry);
            return result;
        }
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public void putAll(Map<? extends K, ? extends V> map) {
        map.entrySet().forEach(entry -> this.put(entry.getKey(), entry.getValue()));
    }

    @Override
    public void clear() {
        items = initItems();
    }

    protected abstract Set<Entry<K, V>> initItems();

    @Override
    @SuppressWarnings("NullableProblems")
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        items.forEach(item -> values.add(item.getValue()));
        return values;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Set<Entry<K, V>> entrySet() {
        return items;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + items;
    }

    protected class Item<KI extends Comparable<KI>, VI> implements Entry<KI, VI>, Comparable<Entry<KI, VI>> {

        private final KI key;
        private VI value;

        public Item(KI key, VI value) {
            this.key = key;
            this.value = value;
        }

        public KI getKey() {
            return key;
        }

        public VI setValue(VI value) {
            VI result = this.value;
            this.value = value;
            return result;
        }

        public VI getValue() {
            return value;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object thatObject) {
            if (this == thatObject) return true;
            if (thatObject == null || getClass() != thatObject.getClass()) return false;

            Item that = (Item) thatObject;

            return (key.equals(that.key));

        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + '}';
        }

        @Override
        @SuppressWarnings("NullableProblems")
        public int compareTo(Entry<KI, VI> that) {
            if (that == null) return -1;
            if (this == that) return 0;

            return this.getKey().compareTo(that.getKey());
        }
    }
}
