package com.gojavaonline3.dlenchuk.module11;

import java.io.*;

public class TryTest {
    public static void main(String[] args) {
        try (InputStream in = new BufferedInputStream(new MyFileInputStream(new File("c:\\temp\\April.bmp")))) {
            System.out.println("in try!");
            return;
        } catch (IOException e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("End");
    }
}

class MyFileInputStream extends FileInputStream {

    public MyFileInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void close() throws IOException {
        System.out.println("close resources");
        super.close();
    }
}
