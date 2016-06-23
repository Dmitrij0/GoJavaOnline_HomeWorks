package com.gojavaonline3.dlenchuk.module09.cipher;

import java.util.Arrays;

/**The Class of the Caesar Algorithm
 *
 * @author Dmitrij Lenchyk
 * @since 22.06.2016
 * */
public class Caesar{

    private static final int DEFAULT_SHIFT = 5;

    private final int POWER_ALGORITHM_OF_LETTERS = 26;
    private final int POWER_ALGORITHM_OF_DIGITS = 10;

    private int shift;

    Caesar() {
        this(DEFAULT_SHIFT);
    }

    public Caesar(int shift) {
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    private int norma(char ch) {
        int result = ch;
        if (Character.isUpperCase(ch)) {
            result = 'A';
        } else if (Character.isLowerCase(ch)) {
            result = 'a';
        } else if (Character.isDigit(ch)) {
            result = '0';
        }
        return result;
    }

    private int power(char ch) {
        return Character.isLowerCase(ch) || Character.isUpperCase(ch) ? POWER_ALGORITHM_OF_LETTERS :
                Character.isDigit(ch) ? POWER_ALGORITHM_OF_DIGITS : /*NRS*/0;
    }

    String execute(Cipher cipher, String value) {
        return String.valueOf(execute(cipher, value.toCharArray()));
    }

    public char[] execute(Cipher cipher, char[] value) {
        char[] result = new char[value.length];
        for (int i = 0; i < result.length; i++) {
            char ch = value[i];
            if (!Character.isUpperCase(ch) && !Character.isLowerCase(ch) && !Character.isDigit(ch)) {
                continue;
            }
            int norma = norma(ch);
            int power = power(ch);
            result[i] = cipher.transform(ch, getShift(), norma, power);
        }
        return value;
    }

}
