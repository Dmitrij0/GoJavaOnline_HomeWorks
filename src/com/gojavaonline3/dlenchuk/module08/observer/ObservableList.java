package com.gojavaonline3.dlenchuk.module08.observer;

public interface ObservableList<U extends Listener> {

    public boolean addListener(U listener);

    public boolean removeListener(U listener);

    public void notifyAllListeners();

}
