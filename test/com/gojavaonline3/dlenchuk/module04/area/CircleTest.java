package com.gojavaonline3.dlenchuk.module04.area;

import com.gojavaonline3.dlenchuk.module04.distance.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    private final int CENTER_X = 74;
    private final int CENTER_Y = 38;
    private final int INVALID_RADIUS = -10;
    private final int VALID_RADIUS = 10;

    private Circle circle;

    @Before
    public void setUp() throws Exception {
        circle = new Circle(new Point(CENTER_X, CENTER_Y), VALID_RADIUS);
    }

    @Test(expected = FigureExistenceIsImpossibleException.class)
    public void testCreateCircleException() throws FigureExistenceIsImpossibleException {
        new Circle(new Point(CENTER_X, CENTER_Y), INVALID_RADIUS);
    }

    @Test
    public void testCreateCircle() throws FigureExistenceIsImpossibleException {
        new Circle(new Point(CENTER_X, CENTER_Y), VALID_RADIUS);
    }

    @Test
    public void getCenter() throws Exception {
        assertEquals(new Point(CENTER_X, CENTER_Y), circle.getCenter());
    }

    @Test
    public void getRadius() throws Exception {
        assertEquals(VALID_RADIUS, circle.getRadius());
    }

    @Test
    public void getArea() throws Exception {
        assertEquals(Math.PI*VALID_RADIUS*VALID_RADIUS, circle.getArea(), 0.1);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Circle{" +
                "O" + new Point(CENTER_X, CENTER_Y) +
                ", radius=" + VALID_RADIUS +
                '}', circle.toString());
    }

}