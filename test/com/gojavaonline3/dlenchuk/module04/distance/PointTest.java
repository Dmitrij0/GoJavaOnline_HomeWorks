package com.gojavaonline3.dlenchuk.module04.distance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private final int valueX = 512;
    private final int valueY = 64;

    private Point point;

    @Before
    public void setUp() throws Exception {
        point = new Point(valueX, valueY);
    }

    @Test
    public void getX() throws Exception {
        assertEquals(valueX, point.getX());
    }

    @Test
    public void getY() throws Exception {
        assertEquals(valueY, point.getY());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("(" + valueX + ", " + valueY + ')', point.toString());
    }

}