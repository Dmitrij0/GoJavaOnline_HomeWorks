package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

public class ConsoleObserver<T extends Number & Comparable<T>> implements Observer<T> {

    @Override
    public void update(SimpleList<T> list) {
        System.out.print(buildLine(list));
    }
}
