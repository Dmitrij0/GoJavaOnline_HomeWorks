package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;

public class DownloadRunner {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Please, give a link:");
        URL url = new URL(scanner.nextLine());
        Downloader<Listener> downloader = new Downloader<>(url);
        Set<LinksExtractor.Link> links = downloader.extractLinks();

        System.out.println(links.toString());

        System.out.println("Please, give a file extension (mp3, avi, pdf, etc...) for downloading:");
        String regExp = scanner.nextLine();
        System.out.println("Please, give a destination directory:");
        String destinationDir = scanner.nextLine();

        downloader.downloadFiles(regExp, destinationDir);
    }

    public static void downloadFile() throws MalformedURLException  {
        URL url = new URL("http://www.ex.ua/102304751?r=70538,23775");
        try (InputStream in = new BufferedInputStream(url.openStream());
             OutputStream outConsole = new BufferedOutputStream(System.out);
             OutputStream outFile = new BufferedOutputStream(new FileOutputStream(new File("c:/Temp/ex_ua.html")))) {
            int byteCount;
            byte[] byteBuffer = new byte[8192];
            while ((byteCount = in.read(byteBuffer)) != -1) {
                outConsole.write(byteBuffer, 0, byteCount);
                outFile.write(byteBuffer, 0, byteCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
