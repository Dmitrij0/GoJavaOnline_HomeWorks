package com.gojavaonline3.dlenchuk.module08.observer;

public interface ObservableList<U extends Observer> {

    public boolean addObserver(U observer);

    public boolean removeObserver(U observer);

    public void notifyAllObservers();

}
