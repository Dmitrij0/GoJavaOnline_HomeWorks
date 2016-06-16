package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

import java.io.*;
import java.util.Iterator;

/**
 * File observer
 *
 * @author Dmitrij Lenchuk
 * @since 17.06.2016.
 */
public class FileObserver<T extends Number & Comparable<T>> implements Observer<T> {

    private FileWriter writer;
    private String fileName;

    public FileObserver(String fileName) throws IOException {
        this.fileName = fileName;
        writer = new FileWriter(fileName);
    }

    @Override
    public void update(SimpleList<T> list) {
        try {
            writer.write(generateLine(list).toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("The File Writer " + fileName + " is crashed");;
        }

    }
}
