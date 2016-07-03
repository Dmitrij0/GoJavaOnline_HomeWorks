package com.gojavaonline3.dlenchuk.module04.area;

import com.gojavaonline3.dlenchuk.module04.distance.Line;
import com.gojavaonline3.dlenchuk.module04.distance.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    private Triangle triangle;

    private final int VALUE_A_X = 0;
    private final int VALUE_A_Y = 0;
    private final int VALUE_B_X = 0;
    private final int VALUE_B_Y = 3;
    private final int VALUE_C_X = 4;
    private final int VALUE_C_Y = 0;

    private final int VALUE_AREA = 6;

    @Before
    public void setUp() throws Exception {
        triangle = new Triangle(new Point(VALUE_A_X, VALUE_A_Y),
                new Point(VALUE_B_X, VALUE_B_Y), new Point(VALUE_C_X, VALUE_C_Y));
    }

    @Test
    public void getPointA() throws Exception {
        assertEquals(new Point(VALUE_A_X, VALUE_A_Y), triangle.getPointA());
    }

    @Test
    public void getPointB() throws Exception {
        assertEquals(new Point(VALUE_B_X, VALUE_B_Y), triangle.getPointB());
    }

    @Test
    public void getPointC() throws Exception {
        assertEquals(new Point(VALUE_C_X, VALUE_C_Y), triangle.getPointC());
    }

    @Test
    public void getSideA() throws Exception {
        assertEquals(new Line(new Point(VALUE_B_X, VALUE_B_Y), new Point(VALUE_C_X, VALUE_C_Y)), triangle.getSideA());
    }

    @Test
    public void getSideB() throws Exception {
        assertEquals(new Line(new Point(VALUE_A_X, VALUE_A_Y), new Point(VALUE_C_X, VALUE_C_Y)), triangle.getSideB());
    }

    @Test
    public void getSideC() throws Exception {
        assertEquals(new Line(new Point(VALUE_A_X, VALUE_A_Y), new Point(VALUE_B_X, VALUE_B_Y)), triangle.getSideC());
    }

    @Test
    public void getArea() throws Exception {
        assertEquals(VALUE_AREA, triangle.getArea(), 0.001);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Triangle{" +
                "A" + new Point(VALUE_A_X, VALUE_A_Y) +
                "; B" + new Point(VALUE_B_X, VALUE_B_Y) +
                "; C" + new Point(VALUE_C_X, VALUE_C_Y) +
                '}', triangle.toString());
    }

}