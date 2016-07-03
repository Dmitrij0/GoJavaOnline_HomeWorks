package com.gojavaonline3.dlenchuk.module10.streams.cipher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class CaesarWriterTest {

    private CaesarWriter caesarWriter;
    private StringWriter stringWriter;

    private final int SHIFT = 5;
    private final String ORIGINAL_STRING = "This is original string. 1234567890 is numbers.";
    private final String ENCODED_STRING = "Ymnx nx twnlnsfq xywnsl. 6789012345 nx szrgjwx.";

    @Before
    public void setUp() throws Exception {
        stringWriter = new StringWriter(ORIGINAL_STRING.length());
        caesarWriter = new CaesarWriter(new BufferedWriter(new ), SHIFT);
    }

    @After
    public void tearDown() throws Exception {
        caesarWriter.close();
    }

    @Test
    public void write() throws Exception {
        caesarWriter.write(ORIGINAL_STRING, 0, ORIGINAL_STRING.length());
        caesarWriter.flush();
        assertEquals(ENCODED_STRING, stringWriter.toString());
    }

    @Test
    public void flush() throws Exception {

    }

    @Test
    public void close() throws Exception {

    }

}