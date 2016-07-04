package com.gojavaonline3.dlenchuk.module11;

public class TestSideEffect {
    public static void main(String[] args) {
        new SideEffect().action();
    }
}

class SideEffect {
    private int counter;

    public void action() {
        counter++;
        System.out.println("This is the action");
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}