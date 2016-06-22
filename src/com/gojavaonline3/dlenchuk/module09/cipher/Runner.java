package com.gojavaonline3.dlenchuk.module09.cipher;

import com.gojavaonline3.dlenchuk.module03.flowers.Color;
import com.gojavaonline3.dlenchuk.module03.flowers.Rosebush;
import com.gojavaonline3.dlenchuk.module08.flowers.Greenhouse;

import java.util.Scanner;

public class Runner {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CloneNotSupportedException, IllegalAccessException {
        Greenhouse greenhouse = new Greenhouse(new Rosebush(Color.RED, true), 100, 100);

//        Cipher encoder = (ch, shift, norma, power) -> (char) ((ch - norma + shift) % power + norma);
//        Cipher decoder = (ch, shift, norma, power) -> (char) ((ch - norma - shift + power) % power + norma);
        Caesar caesar = new Caesar();

        System.out.println("Please, enter a shift of the algorithm: ");
        int shift = scanner.nextInt();
        if (shift < 0 || shift > 10)
            throw new IllegalAccessException("The shift must be in the range [0, 10]");

        System.out.println();
        System.out.println("The original string is: ");
        System.out.println(greenhouse.toString());

//        String encodedString = caesar.execute(encoder, greenhouse.toString(), shift);
        String encodedString = caesar.execute(CaesarEncoder::transform, greenhouse.toString(), shift);

        System.out.println();
        System.out.println("The encoded string is: ");
        System.out.println(encodedString);


//        String decodedString = caesar.execute(decoder, encodedString, shift);
        String decodedString = caesar.execute(CaesarDecoder::transform, encodedString, shift);

        System.out.println();
        System.out.println("The decoded string is: ");
        System.out.println(decodedString);

    }
}
