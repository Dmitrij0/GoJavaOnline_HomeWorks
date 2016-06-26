package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.util.Collection;

public interface ObservableList<L extends Listener> {

    public boolean addListener(L listener);

    public void addAllListeners(Collection<L> listeners);

    public boolean removeListener(L listener);

    public void notifyAllListeners(String msg);

}
