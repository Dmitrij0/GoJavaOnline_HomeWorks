package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Downloader<L extends Listener> implements ObservableList<L> {

    private URL url;

    public Downloader(URL url) {
        this.url = url;
        notifyAllListeners("Create Downloader " + url + "...\n");
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    private void prepared() {
        if (url == null)
            throw new IllegalArgumentException("url == null");
    }


    public List<File> start() throws IOException {
        List<File> result = null;

        try (InputStream in = new BufferedInputStream(getUrl().openStream())) {

        }

        return result;
    }

    private List<L> listeners = new ArrayList<>();

    @Override
    public boolean addListener(L listener) {
        return listeners.add(listener);
    }

    @Override
    public void addAllListeners(Collection<L> listeners) {
        this.listeners.addAll(listeners);
    }

    @Override
    public boolean removeListener(L listener) {
        return listeners.remove(listener);
    }

    @Override
    public void notifyAllListeners(String msg) {
        listeners.forEach(listener -> listener.update(msg));
    }
}
