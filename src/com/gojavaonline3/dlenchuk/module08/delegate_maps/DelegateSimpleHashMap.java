package com.gojavaonline3.dlenchuk.module08.delegate_maps;

import java.util.*;

public class DelegateSimpleHashMap<K extends Comparable<K>, V> extends DelegateSimpleMap<K, V> {

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
