package com.gojavaonline3.dlenchuk.module09.cipher;

public class CaesarEncoder {

    public static char transform(char ch, int shift, int norma, int power) {
        return (char) ((ch - norma + shift) % power + norma);
    }

}
