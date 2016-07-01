package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.URL;

public class FileDownloader {

    private URL url;
    private File file;

    public FileDownloader() {
    }


    public FileDownloader(URL url, File file) {
        this.url = url;
        this.file = file;
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

    public boolean download() {
        prepared();
        boolean result;
        System.out.println(getUrl().getFile());
        try(InputStream in = new BufferedInputStream(getUrl().openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(getFile()))) {
            int byteCount;
            byte[] buffer = new byte[8192];
            while ((byteCount = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteCount);
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
}
