package com.gojavaonline3.dlenchuk.module09;

public class Test {

    public static void main(String[] args) {
        String str1 = "The source code provided with samples and demos for the JDK is meant\n" +
                "to illustrate the usage of a given feature or technique and has been\n" +
                "deliberately simplified. Additional steps required for a\n" +
                "production-quality application, such as security checks, input\n" +
                "validation, and proper error handling, might not be present in the\n" +
                "sample code.";
        String str2 = "The source code provided with samples and demos for the JDK is meant\n" +
                "to illustrate the usage of a given feature or technique and has been\n" +
                "deliberately simplified. Additional steps required for a\n" +
                "production-quality application, such as security checks, input\n" +
                "validation, and proper error handling, might not be present in the\n" +
                "sample code.";

        String str3 = new String("The source code provided with samples and demos for the JDK is meant\n" +
                "to illustrate the usage of a given feature or technique and has been\n" +
                "deliberately simplified. Additional steps required for a\n" +
                "production-quality application, such as security checks, input\n" +
                "validation, and proper error handling, might not be present in the\n" +
                "sample code.");
        String str4 = new String("The source code provided with samples and demos for the JDK is meant\n" +
                "to illustrate the usage of a given feature or technique and has been\n" +
                "deliberately simplified. Additional steps required for a\n" +
                "production-quality application, such as security checks, input\n" +
                "validation, and proper error handling, might not be present in the\n" +
                "sample code.");
        System.out.println("str1 == str2 //" + (str1 == str2) + "; str1.equals(str2) //" + str1.equals(str2));
        System.out.println("str3 == str4 //" + (str3 == str4) + "; str3.equals(str4) //" + str3.equals(str4));

        String str5 = "Dima";
        String str6 = "Dima";
        String str7 = new String("Dima");
        String str8 = new String("Dima");

        System.out.println("str5 == str6 //" + (str5 == str6) + "; str5.equals(str6) //" + str5.equals(str6));
        System.out.println("str7 == str8 //" + (str7 == str8) + "; str7.equals(str8) //" + str7.equals(str8));

        System.out.println("str6 == str7 //" + (str6 == str7) + "; str6.equals(str7) //" + str6.equals(str7));

        System.out.println("str5.hashCode() = " + str5.hashCode());
        System.out.println("str6.hashCode() = " + str6.hashCode());
        System.out.println("str7.hashCode() = " + str7.hashCode());
        System.out.println("str8.hashCode() = " + str8.hashCode());

    }
}
