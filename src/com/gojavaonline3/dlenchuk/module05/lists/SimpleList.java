package com.gojavaonline3.dlenchuk.module05.lists;

import java.util.Iterator;

/**
 * Created by Dmitrij Lenchuk on 05.06.2016.
 * Interface SimpleArrayList
 */
public interface SimpleList<T extends Number & Comparable<T>> extends Iterable<T> {

    T[] getList();

    int indexOf(T Item);

    boolean add(T item);

    void add(int index, T item);

    void add(T[] list);

    boolean remove(T item);

    T remove(int index);

    int length();

    SimpleList<T> bubbleSort();

    SimpleList<T> mergeSort();

    T min();

    T max();

    Iterator<T> iterator();

}
