package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

import java.util.Date;

public interface Listener<T extends Number & Comparable<T>> {

    default StringBuilder buildLine(SimpleList<T> list) {
        final StringBuilder stringBuilder = new StringBuilder(new Date() + ": [");
        list.forEach(item -> stringBuilder.append(item).append(", "));
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]\n\n");

        return stringBuilder;
    }

    void update(SimpleList<T> list);

}
