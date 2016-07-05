package com.gojavaonline3.dlenchuk.finalproject;

import com.gojavaonline3.dlenchuk.finalproject.factorial.Factorial;
import com.gojavaonline3.dlenchuk.finalproject.factorial.Fibonacci;

public class FinalRunner {

    public static void main(String[] args) {
        final Factorial factorial = new Factorial(100);

        long timePoint = System.nanoTime();
        System.out.println(factorial.calculate());
        System.out.println("Elapsed Time: " + (System.nanoTime() - timePoint) / 1_000_000 + "ms");
        System.out.println(factorial);


        Fibonacci fibonacci = new Fibonacci(0, true);
        timePoint = System.nanoTime();
        fibonacci.calculate();
        System.out.println("Elapsed Time: " + (System.nanoTime() - timePoint) / 1_000_000 + "ms");
        System.out.println(fibonacci);
    }

}
