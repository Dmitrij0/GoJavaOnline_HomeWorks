package com.gojavaonline3.dlenchuk.module08.observer;

import com.gojavaonline3.dlenchuk.module05.lists.SimpleList;

import java.io.*;

/**
 * File observer
 *
 * @author Dmitrij Lenchuk
 * @since 17.06.2016.
 */
public class FileListener<T extends Number & Comparable<T>> implements Listener<T> {

    private String fileName;

    public FileListener(String fileName) throws IOException {
        this.fileName = fileName;
    }

    @Override
    public void update(SimpleList<T> list) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(buildLine(list).toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("The File Writer " + fileName + " is crashed");;
        }

    }
}
