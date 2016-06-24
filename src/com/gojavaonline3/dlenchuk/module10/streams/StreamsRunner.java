package com.gojavaonline3.dlenchuk.module10.streams;

import java.io.*;
import java.util.Scanner;

public class StreamsRunner {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        char[] buffer = new char[8192];
        int byteCount;

        System.out.println("Enter a shift of the Caesar algorithm: ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of an origin file: ");
        String fileName = scanner.nextLine();
        System.out.println("Enter the name of a new encoded file: ");
        String newFileName = scanner.nextLine();


        try (BufferedReader in = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new CaesarWriter(new BufferedWriter(new FileWriter(newFileName)), shift))) {

            while ((byteCount = in.read(buffer)) != -1)
                writer.write(buffer, 0, byteCount);


        } catch (IOException e) {
            if (!new File(newFileName).delete())
                e.addSuppressed(new IOException("Can't delete file '" + newFileName + '\''));
            throw e;
        }

        try (BufferedReader reader = new BufferedReader(new CaesarReader(new BufferedReader(new FileReader(newFileName)), shift))) {
            while ((byteCount = reader.read(buffer)) != -1)
                System.out.println(String.valueOf(buffer, 0, byteCount));
        }

    }

}
