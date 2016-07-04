package com.gojavaonline3.dlenchuk.offline.collision;

public class TestCollision implements FirstInterface, SecondInterface {
    public static void main(String[] args) {
        new TestCollision().execute();
    }
    @Override
    public void execute() {
        System.out.println("TestCollision");
    }
}
interface FirstInterface {
    default void execute() {
        System.out.println("FirstInterface");
    }
}
interface SecondInterface {
    default void execute() {
        System.out.println("SecondInterface");
    }
}