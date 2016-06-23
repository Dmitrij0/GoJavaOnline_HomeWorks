package com.gojavaonline3.dlenchuk.module10.streams;

import java.io.*;
import java.util.Scanner;

public class StreamsRunner {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        char[] buffer = new char[8192];
        int byteCount;

        System.out.println("Enter the name of an origin file: ");
        String fileName = scanner.nextLine();

        try (BufferedReader in = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new CaesarWriter(new BufferedWriter(new FileWriter("cipher.txt")), 2))) {

            while ((byteCount = in.read(buffer)) != -1)
                writer.write(buffer, 0, byteCount);


        } catch (IOException e) {
            if (!new File("cipher.txt").delete())
                e.addSuppressed(new IOException("Can't delete file 'cipher.txt'"));
            throw e;
        }

        try (BufferedReader reader = new BufferedReader(new CaesarReader(new BufferedReader(new FileReader("cipher.txt")), 2))) {
            while ((byteCount = reader.read(buffer)) != -1)
                System.out.println(String.valueOf(buffer, 0, byteCount));
        }

    }

}
