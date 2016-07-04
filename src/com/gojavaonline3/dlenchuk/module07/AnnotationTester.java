package com.gojavaonline3.dlenchuk.module07;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrij Lenchuk on 10.06.2016.
 *
 */
public class AnnotationTester {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(Math.ceil(Math.log(13)/Math.log(2)));
    }

    public static<T extends Number & Comparable<T>> List<T> MergeSort(List<T> inList) {
        List<T> list = new ArrayList<>(inList);
        return list;
    }
}

