package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

public class ConsoleListener<T extends Number & Comparable<T>> implements Listener<T> {

    @Override
    public void update(SimpleList<T> list) {
        System.out.print(buildLine(list));
    }
}
