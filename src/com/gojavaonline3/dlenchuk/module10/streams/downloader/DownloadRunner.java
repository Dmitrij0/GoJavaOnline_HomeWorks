package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadRunner {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.ex.ua/load/254776589");
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
