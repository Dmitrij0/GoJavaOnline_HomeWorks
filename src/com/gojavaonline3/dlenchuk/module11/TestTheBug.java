package com.gojavaonline3.dlenchuk.module11;

public class TestTheBug {
    public static void main(String[] args) {
        new SomeClass().someMethod(null);
    }
}

class SomeClass{
    public void someMethod(String str) {
        System.out.println(str.replace("a", "b"));
    }
}