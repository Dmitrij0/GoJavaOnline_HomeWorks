package com.gojavaonline3.dlenchuk.module10.streams.cipher;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class CaesarReaderTest {

    private CaesarWriter caesarWriter;
    private StringWriter stringWriter;

    private final int SHIFT = 5;

    @Before
    public void setUp() throws Exception {
        stringWriter = new StringWriter();
        caesarWriter = new CaesarWriter(new BufferedWriter(new StringWriter()), SHIFT);
    }

    @Test
    public void read() throws Exception {

    }

}