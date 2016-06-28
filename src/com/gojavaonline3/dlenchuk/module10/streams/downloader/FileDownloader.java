package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileDownloader<L extends Listener> implements ObservableList<L> {

    private URL url;
    private File file;

    public FileDownloader() {
        notifyAllListeners("Create Empty File Downloader" + '\n');
    }


    public FileDownloader(URL url, File file) {
        this.url = url;
        this.file = file;
        notifyAllListeners("Create File Downloader url = " + url + "; file = " + file + '\n');
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean start() {
        prepared();
        boolean result;
        try(InputStream in = new BufferedInputStream(getUrl().openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(getFile()))) {
            int byteCount;
            byte[] buffer = new byte[8192];
            notifyAllListeners(file + " downloading...\n");
            while ((byteCount = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteCount);
                notifyAllListeners(".");
            }
            result = true;
        } catch (IOException e) {
            result = false;
        }
        return result;
    }

    private void prepared() {
        if (url == null || file == null)
            throw new IllegalArgumentException("url == null || file == null: " + "url = " + url + "; file = " + file);
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
