package com.gojavaonline3.dlenchuk.module09.cipher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarTest {

    private Caesar caesar;

    private final int SHIFT = 5;
    private final String ORIGINAL_STRING = "This is original string. 1234567890 is numbers.";
    private final String ENCODED_STRING = "Ymnx nx twnlnsfq xywnsl. 6789012345 nx szrgjwx.";

    @Before
    public void setUp() throws Exception {
        caesar = new Caesar(SHIFT);
    }

    @Test
    public void getShift() throws Exception {
        assertEquals(SHIFT, caesar.getShift());
    }

    @Test
    public void executeEncode() throws Exception {
        assertEquals(ENCODED_STRING, caesar.execute(CaesarEncoder::transform, ORIGINAL_STRING));
    }

    @Test
    public void executeDecode() throws Exception {
        assertEquals(ORIGINAL_STRING, caesar.execute(CaesarDecoder::transform, ENCODED_STRING));
    }

}