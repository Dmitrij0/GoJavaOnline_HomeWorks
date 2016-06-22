package com.gojavaonline3.dlenchuk.module09.cipher;

/**The Class of the Caesar Algorithm
 *
 * @author Dmitrij Lenchyk
 * @since 22.06.2016
 * */
class Caesar{

    private final int POWER_ALGORITHM_OF_LETTERS = 26;
    private final int POWER_ALGORITHM_OF_DIGITS = 10;

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

    String execute(Cipher cipher, String value, int shift) {
        StringBuilder result = new StringBuilder(value);
        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if (!Character.isUpperCase(ch) && !Character.isLowerCase(ch) && !Character.isDigit(ch)) {
                continue;
            }
            int norma = norma(ch);
            int power = power(ch);
            result.setCharAt(i, cipher.transform(ch, shift, norma, power));
        }
        return result.toString();
    }

}
