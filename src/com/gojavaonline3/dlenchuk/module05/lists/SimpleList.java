package com.gojavaonline3.dlenchuk.module05.lists;

import java.util.Iterator;

/**
 * Created by Dmitrij Lenchuk on 05.06.2016.
 * Interface SimpleArrayList
 */
public interface SimpleList<T extends Number & Comparable<T>> extends Iterable<T> {

    public int indexOf(T Item);

    public boolean add(T item);

    public void add(int index, T item);

    public void add(T[] list);

    public boolean remove(T item);

    public T remove(int index);

    public int length();

    public SimpleList<T> bubbleSort();

    public SimpleList<T> mergeSort();

    public T min();

    public T max();

    public Iterator<T> iterator();

}
