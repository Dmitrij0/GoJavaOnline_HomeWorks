package com.gojavaonline3.dlenchuk.module11;

public class TestLambda {

    public static void main(String[] args) {
        Computable computeTime = (hours, procCount) -> hours / procCount;
        computeTime.compute(10, 4);
    }

}
interface Computable {
    double compute(int firstArg, int secondArg);
}
