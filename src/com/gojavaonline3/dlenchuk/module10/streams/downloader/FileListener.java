package com.gojavaonline3.dlenchuk.module10.streams.downloader;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File observer
 *
 * @author Dmitrij Lenchuk
 * @since 17.06.2016.
 */
public class FileListener implements Listener {

    private String fileName;
    private StringBuilder buffer = new StringBuilder();

    private final short SCHEDULE_BUFFER_SIZE = 4096;

    public FileListener(String fileName) throws IOException {
        this.fileName = fileName;
    }

    @Override
    public void update(String msg) {
        if (buffer.append(msg).length() >= SCHEDULE_BUFFER_SIZE) {
            writeToFile();
        }
    }

    public void writeToFile() {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(buffer.toString());
        } catch (IOException e) {
            System.out.println("The File Writer " + fileName + " is crashed");
        }
    }

}
