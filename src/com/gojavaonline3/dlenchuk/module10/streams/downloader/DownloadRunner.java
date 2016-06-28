package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;

public class DownloadRunner {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        FileListener fileListener = new FileListener(System.getProperty("java.io.tmpdir") + "download.log");
        ConsoleListener consoleListener = new ConsoleListener();
        try {
            System.out.println("Please, give a link:");
            URL url = new URL(scanner.nextLine());
            Downloader<Listener> downloader = new Downloader<>(url);
            downloader.addListener(fileListener);
            downloader.addListener(consoleListener);
            Set<LinksExtractor.Link> links = downloader.extractLinks();


            System.out.println(links.toString());

            System.out.println("Please, give a file extension (mp3, avi, pdf, etc...) for downloading:");
            String regExp = scanner.nextLine();
            System.out.println("Please, give a destination directory:");
            String destinationDir = scanner.nextLine();

            System.out.println(downloader.downloadFiles(regExp, destinationDir).toString().replace(", ", "\n"));
        } finally {
            fileListener.writeToFile();
        }
    }

}
