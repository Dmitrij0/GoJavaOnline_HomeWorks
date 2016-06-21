package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.*;

public class SimpleHashMap<K extends Comparable<K>, V> extends SimpleMap<K, V> {

    @Override
    protected Set<Entry<K, V>> initItems() {
        return new HashSet<>();
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        entrySet().forEach(item -> keySet.add(item.getKey()));
        return keySet;
    }

}
