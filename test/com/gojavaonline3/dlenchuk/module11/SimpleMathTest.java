package com.gojavaonline3.dlenchuk.module11;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMathTest {

    private static SimpleMath simpleMath;

    @BeforeClass
    public static void setUpClass() throws Exception {
        simpleMath = new SimpleMath();
        System.out.println("setUpClass() called");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp() called");
    }

    @Test(timeout = 3000)
    public void add() throws Exception {
        System.out.println("Test add() called");
        int a = 5;
        int b = 8;

        final int result = simpleMath.add(a, b);

        assertEquals(13, result);
    }

    @Test(timeout = 3000)
    public void sub() throws Exception {
        System.out.println("Test sub() called");
        final int a = 29;
        final int b = 20;

        final int result = simpleMath.sub(a, b);

        assertEquals(a - b, result);
    }

    @Ignore("mult() not ready yet\n")
    @Test
    public void mult() throws Exception {

    }

    @Test(timeout = 3000)
    public void modulo() throws Exception {
        System.out.println("Test modulo() called");
        final int a = 17;
        final int b = 3;

        final int result = simpleMath.modulo(a, b);

        assertEquals(a % b, result);
    }

    @Test(timeout = 3000, expected = UnsupportedOperationException.class)
    public void div() throws Exception {
        System.out.println("Test div() called");
        final int a = 17;
        final int b = 3;

        final int result = simpleMath.div(a, b);

        assertEquals(a / b, result);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown called");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("tearDownClass called");
    }

}