package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleArrayList;
import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

import java.util.Set;

public class ObservableArrayList<T extends Number & Comparable<T>, U extends Observer<T>>
        implements ObservableList<U> {

    private SimpleList<T> list;

    private Set<U> observers;

    ObservableArrayList(T[] list, Set<U> observers) {
        this.list = new SimpleArrayList<>(list);
        this.observers = observers;
        notifyAllObservers();
    }

    public boolean add(T item) {
        boolean result = list.add(item);
        notifyAllObservers();
        return result;
    }

    public void add(int index, T item) {
        list.add(index, item);
        notifyAllObservers();
    }

    public boolean remove(T item) {
        boolean result = list.remove(item);
        notifyAllObservers();
        return result;
    }

    public T remove(int index) {
        final T result = list.remove(index);
        notifyAllObservers();
        return result;
    }

    public SimpleList<T> bubbleSort() {
        list = list.bubbleSort();
        notifyAllObservers();
        return list;
    }

    public SimpleList<T> mergeSort() {
        list = list.mergeSort();
        notifyAllObservers();
        return list;
    }

    @Override
    public boolean addObserver(U observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(U observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        observers.forEach(observer -> observer.update(list));
    }

}
