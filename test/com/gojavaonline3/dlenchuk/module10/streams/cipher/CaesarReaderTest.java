package com.gojavaonline3.dlenchuk.module10.streams.cipher;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class CaesarReaderTest {

    private CaesarReader caesarReader;
    private StringReader stringReader;

    private final int SHIFT = 5;
    private final String ORIGINAL_STRING = "Ymnx nx twnlnsfq xywnsl. 6789012345 nx szrgjwx.";
    private final String DECODED_STRING = "This is original string. 1234567890 is numbers.";

    @Before
    public void setUp() throws Exception {
        stringReader = new StringReader(ORIGINAL_STRING);
        caesarReader = new CaesarReader(stringReader, SHIFT);
    }

    @Test
    public void read() throws Exception {
        char[] string = new char[ORIGINAL_STRING.length()];
        int stringLength = caesarReader.read(string);
        assertEquals(DECODED_STRING.length(), stringLength);
        assertEquals(DECODED_STRING, String.valueOf(string));
    }

}