package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.*;

class SimpleMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int MAX_BUCKET_SIZE = 8;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;


    private int size;
    private SimpleNode<K, V>[] table;

    SimpleMap() {
        table = resize();
    }

    private SimpleNode<K, V>[] resize() {
        int newCapacity = calculateNewCapacity();
        SimpleNode<K, V>[] table = this.table;
        @SuppressWarnings({"rawtypes", "unchecked"})
        SimpleNode<K, V>[] newTable = (SimpleNode<K, V>[]) new SimpleNode[newCapacity];
        if (table == null || size() == 0) {
            return newTable;
        }
        for (SimpleNode<K, V> rootNode : table) {
            for (SimpleNode<K, V> currNode = rootNode; currNode != null; currNode = currNode.getNext()) {
                K key = currNode.getKey();
                V value = currNode.getValue();
                int hash = currNode.getHash();
                SimpleNode<K, V> newNode = new SimpleNode<>(key, value, hash, null);
                putNodeInToTable(newTable, newNode);
            }
        }
        return newTable;
    }

    private int calculateNewCapacity() {
        return table == null ? DEFAULT_CAPACITY : capacity() * 2;
    }

    private int capacity() {
        return capacity(table);
    }

    private int capacity(SimpleNode<K, V>[] table) {
        return table == null ? 0 : table.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        return getNode((K) key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        SimpleNode<K, V>[] table = this.table;
        V currValue;
        if (table == null || size() == 0) {
            return false;
        }
        for (SimpleNode<K, V> rootNode : table) {
            for (SimpleNode<K, V> currNode = rootNode; currNode != null; currNode = currNode.getNext()) {
                if ((currValue = currNode.getValue()) == value ||
                        (currValue != null && currValue.equals(value))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        SimpleNode<K, V> node = getNode((K) key);
        return node == null ? null : node.getValue();
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = getNode(key);
        if (entry == null) {
            if (needResizeByLoadFactor(1) || needResizeByBucketSize(key)) {
                table = resize();
            }
            int hash = hash(key);
            SimpleNode<K, V> newNode = new SimpleNode<>(key, value, hash, null);
            putNodeInToTable(table, newNode);
            size++;
            return null;
        } else {
            return entry.setValue(value);
        }
    }

    private boolean needResizeByBucketSize(K key) {
        return bucketSize(key) + 1 > MAX_BUCKET_SIZE;
    }

    private int bucketSize(K key) {
        SimpleNode<K, V> rootNode;
        if (table == null || size() == 0 || (rootNode = table[indexFor(key)]) == null) {
            return 0;
        } else {
            int counter = 1;
            while ((rootNode = rootNode.getNext()) != null) {
                counter++;
            }
            return counter;
        }
    }

    private boolean needResizeByLoadFactor(int newCount) {
        return capacity() == 0 || (size() + newCount) / capacity() > DEFAULT_LOAD_FACTOR;
    }

    private void putNodeInToTable(SimpleNode<K, V>[] table, SimpleNode<K, V> node) {
        int newIndex = indexFor(node.getHash(), capacity(table));
        SimpleNode<K, V> rootNode = table[newIndex];
        if (rootNode == null) {
            table[newIndex] = node;
        } else {
            while (rootNode.getNext() != null) {
                rootNode = rootNode.getNext();
            }
            rootNode.setNext(node);
        }
    }

    private SimpleNode<K, V> getNode(K key) {
        SimpleNode<K, V>[] table = this.table;
        int index = indexFor(key);
        if (table == null || table[index] == null) {
            return null;
        } else {
            for (SimpleNode<K, V> node = table[index]; node != null; node = node.getNext()) {
                K currKey;
                if ((currKey = node.getKey()) == key || (currKey != null && currKey.equals(key)))
                    return node;
            }
            return null;
        }
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private int indexFor(int hash) {
        return indexFor(hash, capacity());
    }

    private int indexFor(K key) {
        return indexFor(hash(key));
    }

    private int indexFor(int hash, int capacity) {
        return hash % capacity;
    }

    @Override
    public V remove(Object key) {
        SimpleNode<K, V>[] table = this.table;
        SimpleNode<K, V> prevNode = null;
        @SuppressWarnings("unchecked")
        K inKey = (K) key;
        K currKey;

        if (table == null || size() == 0) {
            return null;
        }

        int index = indexFor(inKey);
        SimpleNode<K, V> currNode = table[index];
        if (currNode == null) {
            return null;
        }
        if ((currKey = currNode.getKey()) == inKey ||
                (currKey != null && currKey.equals(inKey))) {
            V value = currNode.getValue();
            table[index] = currNode.getNext();
            size--;
            return value;
        }
        prevNode = currNode;
        for (currNode = currNode.getNext(); currNode != null; currNode = currNode.getNext()) {
            if ((currKey = currNode.getKey()) == inKey ||
                    (currKey != null && currKey.equals(inKey))) {
                V value = currNode.getValue();
                prevNode.setNext(currNode.getNext());
                size--;
                return value;
            }
            prevNode = currNode;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        map.entrySet().forEach(node -> put(node.getKey(), node.getValue()));
    }

    @Override
    public void clear() {
        table = null;
        table = resize();
    }

    @Override
    /*ToDo keySet() need to entrySet()*/
    public Set<K> keySet() {
        throw new UnsupportedOperationException("The method 'keySet()' is not implemented yet");
    }

    @Override
    /*ToDo values() need to entrySet()*/
    public Collection<V> values() {
        return null;
    }

    @Override
    /*ToDo entrySet() need to my SimpleHashSet*/
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("The method 'entrySet()' is not implemented yet");
    }

    private class SimpleNode<KI, VI> implements Entry<KI, VI> {

        private final KI key;
        private VI value;
        private int hash;
        private SimpleNode<KI, VI> next;

        SimpleNode(KI key, VI value, int hash, SimpleNode<KI, VI> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public KI getKey() {
            return key;
        }

        @Override
        public VI getValue() {
            return value;
        }

        @Override
        public VI setValue(VI value) {
            VI oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        int getHash() {
            return hash;
        }

        SimpleNode<KI, VI> getNext() {
            return next;
        }

        void setNext(SimpleNode<KI, VI> next) {
            this.next = next;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SimpleNode<KI, VI> that = (SimpleNode<KI, VI>) o;

            return key != null ? key.equals(that.key) : that.key == null;

        }

        @Override
        public String toString() {
            return "{" + key + " = " + value + '}';
        }
    }

    @Override
    /*ToDo toString() need to entrySet()*/
    public String toString() {
        return "SimpleMap";
    }

}
