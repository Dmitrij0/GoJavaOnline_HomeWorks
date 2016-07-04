package com.gojavaonline3.dlenchuk.module07;

/**
 * Created by Dmitrij Lenchuk on 07.06.2016.
 * Class Runner
 */
public class TestableRunner {
    public static void main(String[] args) {
        ParentOfTest test1 = new Test1();
        try {
            test1.test();
            System.out.println("Test1: Tested");
        } catch (TestNotSupportedException e) {
            System.out.println("Test1: TestNotSupportedException");
        }
        ParentOfTest test2 = new Test2();
        try {
            test2.test();
            System.out.println("Test2: Tested");
        } catch (TestNotSupportedException e) {
            System.out.println("Test2: TestNotSupportedException");
        }
    }
}
interface Testable {
}
class TestNotSupportedException extends Exception {
}
abstract class ParentOfTest {
    public void test() throws TestNotSupportedException {
        boolean testable = false;
        for (Class<?> clazz : this.getClass().getInterfaces()) {
            if (clazz.getSimpleName().equals("Testable"))
                testable = true;
        }
        if (!testable)
            throw new TestNotSupportedException();
//      ToDo Some Test Code Here
    }
}
class Test1 extends ParentOfTest implements Testable{
}
class Test2 extends ParentOfTest {
}
