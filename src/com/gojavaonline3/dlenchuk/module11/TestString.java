package com.gojavaonline3.dlenchuk.module11;

public class TestString {
    public static void main(String[] args) {
        ExecString execString = new ExecString();
        execString.exec("The big big big string", new String("not a big string"),
                99, new Integer(99999),
                1_000_000_000_000L, new Long(1_000_000_000_000L),
                123123123.23, new Double(123123123.23)
        );
    }
}

class ExecString {

    public void exec(String str1, String str2,
                     Integer int1, Integer int2,
                     Long long1, Long long2,
                     Double double1, Double double2) {
        str1 = str1.replace("big", "very big");
        System.out.println(str1 + str2 +
                int1 + int2 +
                long1 + long2 +
                double1 + double2);
    }

}
