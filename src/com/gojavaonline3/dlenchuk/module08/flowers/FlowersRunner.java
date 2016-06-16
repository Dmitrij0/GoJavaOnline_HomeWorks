package com.gojavaonline3.dlenchuk.module08.flowers;

import com.gojavaonline3.dlenchuk.module03.flowers.Color;
import com.gojavaonline3.dlenchuk.module03.flowers.Rosebush;

import java.util.Comparator;

/**
 * Created by Dmitrij Lenchuk on 14.06.2016.
 * Flowers Runner
 */
public class FlowersRunner {

    public static void main(String[] args) {
        try {
            Greenhouse greenhouse = new Greenhouse(new Rosebush(Color.RED, true), 100, 100);
            greenhouse.report();
        } catch (CloneNotSupportedException e) {
            System.out.println("Can't clone rosebushes");
        }
    }

}
