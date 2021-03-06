package com.gojavaonline3.dlenchuk.module11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class ParametrizedSimpleMathTest {

    private static final SimpleMath simpleMath = new SimpleMath();
    private int numberA;
    private int numberB;
    private int expected;

    public ParametrizedSimpleMathTest(int numberA, int numberB, int expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: multiply({0}*{1})={2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1},
                {2, 2, 4},
                {8, 2, 16},
                {4, 5, 20}
        });
    }

    @Test
    public void testMult() {
        assertEquals(expected, simpleMath.mult(numberA, numberB));
    }
}
