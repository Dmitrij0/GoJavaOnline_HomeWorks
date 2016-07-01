package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Downloader {

    private URL url;
    private Set<LinksExtractor.Link> links;

    private boolean extracted;


    public Downloader(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
        extracted = false;
    }

    public boolean isExtracted() {
        return extracted;
    }

    public void prepared() {
        if (url == null)
            throw new IllegalArgumentException("url == null");
    }

    public Set<LinksExtractor.Link> extractLinks() throws IOException {
        prepared();
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
                    fileDownloader.setUrl(new URL(url.getProtocol() + "://" + url.getHost() + link.getLink()));
                } else {
                    fileDownloader.setUrl(new URL(link.getLink()));
                }

                fileDownloader.setFile(new File(destinationDir + '/' + link.getLinkText()+ '_' + (counter + 1) + '.' + matches));
                fileDownloader.download();
                files.add(fileDownloader.getFile());
                counter++;
            }
        }

        return files;
    }
}
