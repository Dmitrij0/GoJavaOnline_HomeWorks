package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.*;

public class SimpleTreeMap<K extends Comparable<K>, V>
        extends SimpleMap<K, V>
        implements NavigableMap<K, V> {

    private Comparator<? super K> comparator;

    public SimpleTreeMap() {
        super();
    }

    public SimpleTreeMap(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    public SimpleTreeMap(Map<K, V> map) {
        super(map);
    }

    public SimpleTreeMap(Map<K, V> map, Comparator<? super K> comparator) {
        super(map);
        this.comparator = comparator;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new TreeSet<>();
        entrySet().forEach(item -> keySet.add(item.getKey()));
        return keySet;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        return ((TreeSet<Entry<K, V>>)entrySet()).lower(new Item<>(key, null));
    }

    @Override
    public K lowerKey(K key) {
        Entry<K, V> entry = lowerEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        return ((TreeSet<Entry<K, V>>)entrySet()).floor(new Item<>(key, null));
    }

    @Override
    public K floorKey(K key) {
        Entry<K, V> entry = floorEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return ((TreeSet<Entry<K, V>>)entrySet()).ceiling(new Item<>(key, null));
    }

    @Override
    public K ceilingKey(K key) {
        Entry<K, V> entry = ceilingEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        return ((TreeSet<Entry<K, V>>)entrySet()).higher(new Item<>(key, null));
    }

    @Override
    public K higherKey(K key) {
        Entry<K, V> entry = higherEntry(key);
        return entry == null ? null : entry.getKey();
    }

    @Override
    public Entry<K, V> firstEntry() {
        return ((TreeSet<Entry<K, V>>)entrySet()).first();
    }

    @Override
    public Entry<K, V> lastEntry() {
        return ((TreeSet<Entry<K, V>>)entrySet()).last();
    }

    @Override
    public Entry<K, V> pollFirstEntry() {
        return ((TreeSet<Entry<K, V>>)entrySet()).pollFirst();
    }

    @Override
    public Entry<K, V> pollLastEntry() {
        return ((TreeSet<Entry<K, V>>)entrySet()).pollLast();
    }

    /*ToDo*/
    @Override
    public NavigableMap<K, V> descendingMap() {
        throw new UnsupportedOperationException();
    }

    @Override
    public NavigableSet<K> navigableKeySet() {
        final NavigableSet<K> set = new TreeSet<>();
        this.entrySet().forEach(item -> set.add(item.getKey()));
        return set;
    }

    @Override
    public NavigableSet<K> descendingKeySet() {
        return navigableKeySet().descendingSet();
    }

    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        final NavigableMap<K, V> map = new SimpleTreeMap<>();
        entrySet()
            .stream()
            .filter(entry ->
                ((entry.getKey().compareTo(fromKey)) > 0 || (fromInclusive && entry.getKey().equals(fromKey))) &&
                ((entry.getKey().compareTo(toKey)) < 0 || (toInclusive && entry.getKey().equals(toKey))))
            .forEach(entry -> map.put(entry.getKey(), entry.getValue()));
        return map;
    }

    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return subMap(this.firstKey(), true, toKey, inclusive);
    }

    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return subMap(fromKey, inclusive, this.lastKey(), inclusive);
    }

    @Override
    public Comparator<? super K> comparator() {
        return comparator;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return subMap(this.firstKey(), true, toKey, false);
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return subMap(fromKey, true, this.lastKey(), true);
    }

    @Override
    public K firstKey() {
        return this.firstEntry().getKey();
    }

    @Override
    public K lastKey() {
        return this.lastEntry().getKey();
    }

    @Override
    protected Set<Entry<K, V>> initItems() {
        return new TreeSet<>();
    }

}
