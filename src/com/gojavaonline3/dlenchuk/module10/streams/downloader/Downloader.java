package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Downloader<L extends Listener> implements ObservableList<L> {

    private URL url;
    private Set<LinksExtractor.Link> links;

    private boolean extracted;


    public Downloader(URL url) {
        this.url = url;
        notifyAllListeners("Create Downloader " + url + "...\n");
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
        extracted = false;
        notifyAllListeners("URL is set to '" + url + '\'' + '\n');
    }

    public boolean isExtracted() {
        return extracted;
    }

    public void prepared() {
        if (url == null)
            throw new IllegalArgumentException("url == null");
    }

    public Set<LinksExtractor.Link> extractLinks() throws IOException {
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("c:\\temp\\First_ex_ua.html"))))) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(getUrl().openStream()))) {
            int byteCount;
            char[] buffer = new char[4096];
            StringBuilder stringBuilder = new StringBuilder();
            while ((byteCount = in.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, byteCount);
            }
            links = new LinksExtractor(stringBuilder.toString()).extractLinks();
            extracted = true;
        }
        notifyAllListeners("Links are extracted.\n");
        return links;
    }

    public List<File> downloadFiles(String matches, String destinationDir) throws IOException {
        FileDownloader fileDownloader = new FileDownloader();
        List<File> files = new ArrayList<>();
        int counter = 0;

        if (!extracted)
            extractLinks();

        for (LinksExtractor.Link link : links) {
            if (link.getLink().matches(".*" + matches + ".*") || link.getLinkText().matches(".*" + matches + ".*")) {
                if (link.getLink().charAt(0) == '/') {
                    fileDownloader.setUrl(new URL(
                            url.getProtocol() + "://" + url.getHost() + link.getLink()
                    ));
                } else {
                    fileDownloader.setUrl(new URL(link.getLink()));
                }

                fileDownloader.setFile(new File(destinationDir + "/file_" + counter + '.' + matches));
                fileDownloader.start();
                files.add(fileDownloader.getFile());
                counter++;
            }
        }

        return files;
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
