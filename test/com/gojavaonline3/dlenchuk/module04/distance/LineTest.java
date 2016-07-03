package com.gojavaonline3.dlenchuk.module04.distance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    private final int valueX1 = 0;
    private final int valueY1 = 0;
    private final int valueX2 = 30;
    private final int valueY2 = 40;
    private final double length = 50;

    private Line line;

    @Before
    public void setUp() throws Exception {
        line = new Line(valueX1, valueY1, valueX2, valueY2);
    }

    @Test
    public void getPoint1() throws Exception {
        assertEquals(new Point(valueX1, valueY1), line.getPoint1());
    }

    @Test
    public void getPoint2() throws Exception {
        assertEquals(new Point(valueX2, valueY2), line.getPoint2());
    }

    @Test
    public void length() throws Exception {
        assertEquals(length, line.length(), 0);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Line{" +
                "A" + new Point(valueX1, valueY1) +
                "; B" + new Point(valueX2, valueY2) +
                "; AB = " + String.format("%.2f", length)  +
                '}', line.toString());
    }

}