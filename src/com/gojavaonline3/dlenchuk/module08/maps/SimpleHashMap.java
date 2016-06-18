package com.gojavaonline3.dlenchuk.module08.maps;

import java.util.*;

public class SimpleHashMap<K, V> extends SimpleMap<K,V> {

    public SimpleHashMap() {
        clear();
    }

    @Override
    protected Set<Entry<K, V>> initItems() {
        return new HashSet<>();
    }
}
