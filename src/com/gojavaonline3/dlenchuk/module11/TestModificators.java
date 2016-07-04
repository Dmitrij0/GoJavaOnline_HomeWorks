package com.gojavaonline3.dlenchuk.module11;

public class TestModificators {
    public static void main(String[] args) {
        System.out.println(Test.toStringStatic());
        Test.println(10, 15, "A", "B", new Object(), new Object());
        Test test = new Test();
        System.out.println(test);
        test.println(new Object(), new Object(), "A", "B", 10, 15);
    }
}

class Test {

    int testInt = 4;
    static int testStaticInt = 4;

    final int testFinalInt = 4;
    final static int testFinalStaticInt = 4;

    Integer testInteger = 4;
    static Integer testStaticInteger = 4;

    final Integer testFinalInteger = 4;
    final static Integer testFinalStaticInteger = 4;

    Object testObject;
    static Object testStaticObject;

    final Object testFinalObject;
    final static Object testFinalStaticObject;

    static {
        testStaticObject = new Object();
        testFinalStaticObject = new Object();
    }

    {
        testObject = new Object();
        testFinalObject = new Object();
    }

    public static void println(final int finalIntA, int intB,
                               final String finalStringA, String StringB,
                               final Object finalObjectA, Object ObjectB) {
        System.out.println("finalIntA = " + finalIntA + "; intB = " + intB +
                "; finalStringA = " + finalStringA + "; StringB = " + StringB +
                "; finalObjectA = " + finalObjectA + "; ObjectB = " + ObjectB);
    }

    public static String toStringStatic() {
        return "Test{" +
                "testStaticInt=" + testStaticInt +
                ", testFinalStaticInt=" + testFinalStaticInt +
                ", testStaticInteger=" + testStaticInteger +
                ", testFinalStaticInteger=" + testFinalStaticInteger +
                '}';
    }

    public void println(final Object finalObjectA, Object ObjectB,
                        final String finalStringA, String StringB,
                        final int finalIntA, int intB) {
        System.out.println("finalIntA = " + finalIntA + "; intB = " + intB +
                "; finalStringA = " + finalStringA + "; StringB = " + StringB +
                "; finalObjectA = " + finalObjectA + "; ObjectB = " + ObjectB);
    }

    @Override
    public String toString() {
        return "Test{" +
                "testInt=" + testInt +
                ", testFinalInt=" + testFinalInt +
                ", testInteger=" + testInteger +
                ", testFinalInteger=" + testFinalInteger +
                '}';
    }
}
