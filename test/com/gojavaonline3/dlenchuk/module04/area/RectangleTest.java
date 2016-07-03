package com.gojavaonline3.dlenchuk.module04.area;

import com.gojavaonline3.dlenchuk.module04.distance.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle rectangle;

    private final int VALID_A_X = 0;
    private final int VALID_A_Y = 0;
    private final int VALID_B_X = 0;
    private final int VALID_B_Y = 5;
    private final int VALID_C_X = 10;
    private final int VALID_C_Y = 5;
    private final int VALID_D_X = 10;
    private final int VALID_D_Y = 0;

    private final int AREA = 50;

    private final int INVALID1_A_X = -1;
    private final int INVALID1_A_Y = 0;
    private final int INVALID1_B_X = 3;
    private final int INVALID1_B_Y = 0;
    private final int INVALID1_C_X = 3;
    private final int INVALID1_C_Y = 4;
    private final int INVALID1_D_X = 0;
    private final int INVALID1_D_Y = 4;

    private final int INVALID2_A_X = -1;
    private final int INVALID2_A_Y = 0;
    private final int INVALID2_B_X = 3;
    private final int INVALID2_B_Y = 0;
    private final int INVALID2_C_X = 3;
    private final int INVALID2_C_Y = 4;
    private final int INVALID2_D_X = 0;
    private final int INVALID2_D_Y = 4;

    @Before
    public void setUp() throws Exception {
        rectangle = new Rectangle(new Point(VALID_A_X, VALID_A_Y), new Point(VALID_B_X, VALID_B_Y),
                new Point(VALID_C_X, VALID_C_Y), new Point(VALID_D_X, VALID_D_Y));
    }

    @Test(expected = FigureExistenceIsImpossibleException.class)
    public void testCreateRectangle1() throws Exception {
        new Rectangle(new Point(INVALID1_A_X, INVALID1_A_Y), new Point(INVALID1_B_X, INVALID1_B_Y),
                new Point(INVALID1_C_X, INVALID1_C_Y), new Point(INVALID1_D_X, INVALID1_D_Y)).draw();
    }

    @Test(expected = FigureExistenceIsImpossibleException.class)
    public void testCreateRectangle2() throws Exception {
        new Rectangle(new Point(INVALID2_A_X, INVALID2_A_Y), new Point(INVALID2_B_X, INVALID2_B_Y),
                new Point(INVALID2_C_X, INVALID2_C_Y), new Point(INVALID2_D_X, INVALID2_D_Y)).draw();
    }

    @Test
    public void getPointA() throws Exception {
        assertEquals(new Point(VALID_A_X, VALID_A_Y), rectangle.getPointA());
    }

    @Test
    public void getPointB() throws Exception {
        assertEquals(new Point(VALID_B_X, VALID_B_Y), rectangle.getPointB());
    }

    @Test
    public void getPointC() throws Exception {
        assertEquals(new Point(VALID_C_X, VALID_C_Y), rectangle.getPointC());
    }

    @Test
    public void getPointD() throws Exception {
        assertEquals(new Point(VALID_D_X, VALID_D_Y), rectangle.getPointD());
    }

    @Test
    public void getArea() throws Exception {
        assertEquals(AREA, rectangle.getArea(), 0.1);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Rectangle{" +
                "A" + new Point(VALID_A_X, VALID_A_Y) +
                "; B" + new Point(VALID_B_X, VALID_B_Y) +
                "; C" + new Point(VALID_C_X, VALID_C_Y) +
                "; D" + new Point(VALID_D_X, VALID_D_Y) +
                '}', rectangle.toString());
    }

}