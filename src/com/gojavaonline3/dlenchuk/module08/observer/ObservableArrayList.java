package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleArrayList;
import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

import java.util.HashSet;
import java.util.Set;

public class ObservableArrayList<T extends Number & Comparable<T>, U extends Listener<T>>
        extends SimpleArrayList<T>
        implements ObservableList<U> {

    private Set<U> observers = new HashSet<>();

    ObservableArrayList() {
    }

    ObservableArrayList(T[] list, Set<U> observers) {
        super(list);
        this.observers = observers;
        notifyAllListeners();
    }

    @Override
    public boolean add(T item) {
        boolean result = super.add(item);
        notifyAllListeners();
        return result;
    }

    @Override
    public void add(int index, T item) {
        super.add(index, item);
        notifyAllListeners();
    }

    @Override
    public void add(T[] list) {
        super.add(list);
        notifyAllListeners();
    }

    @Override
    public boolean remove(T item) {
        boolean result = super.remove(item);
        notifyAllListeners();
        return result;
    }

    @Override
    public T remove(int index) {
        final T result = super.remove(index);
        notifyAllListeners();
        return result;
    }

    @Override
    public SimpleList<T> bubbleSort() {
        list = super.bubbleSort();
        notifyAllListeners();
        return list;
    }

    @Override
    public SimpleList<T> mergeSort() {
        list = super.mergeSort();
        notifyAllListeners();
        return list;
    }

    @Override
    public boolean addListener(U listener) {
        return observers.add(listener);
    }

    @Override
    public boolean removeListener(U listener) {
        return observers.remove(listener);
    }

    @Override
    public void notifyAllListeners() {
        observers.forEach(observer -> observer.update(this));
    }

}
