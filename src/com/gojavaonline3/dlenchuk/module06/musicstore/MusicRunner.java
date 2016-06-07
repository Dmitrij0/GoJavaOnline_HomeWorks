package com.gojavaonline3.dlenchuk.module06.musicstore;

import java.util.*;

/**
 * Created by Dmitrij Lenchuk on 01.06.2016.
 * Runner Music Store
 */
public class MusicRunner {
    public static void main(String[] args) {
        int sequenceId = 0;
        MusicStore store = MusicStore.getInstance();

        store.report();

        System.out.println();
        store.add(new Trumpet(sequenceId++, "Mordor", new GregorianCalendar(1000, 11, 12), 1_000_000_000));
        store.add(new Guitar(sequenceId++, "Stradivary", new GregorianCalendar(1677, 11, 31), 500_000_000));
        store.add(new Piano(sequenceId++, "Kawai Musical Instruments", new GregorianCalendar(1800, 10, 30), 50_000_000));
        store.add(new Piano(sequenceId++, "Bösendorfer", new GregorianCalendar(1815, 9, 18), 40_000_000));
        store.add(new Trumpet(sequenceId++, "Buffet-Crampon", new GregorianCalendar(1845, 4, 15), 5_000_000));
        store.add(new Trumpet(sequenceId++, "Steinway Musical Instruments", new GregorianCalendar(1913, 11, 19), 1_000_000));
        store.add(new Piano(sequenceId++, "Lesopilka #3 Stoljarnij Ceh #4 Best Of The World", new GregorianCalendar(1934, 11, 5), 1_000));
        store.add(new Guitar(sequenceId++, "Vorkuta Ltd", new GregorianCalendar(1949, 10, 15), 30));
        store.add(new Guitar(sequenceId++, "Bukovina", new GregorianCalendar(1979, 5, 11), 25));
        store.add(new Guitar(sequenceId++, "USA Rock Club", new GregorianCalendar(1984, 3, 13), 500));
        store.add(new Piano(sequenceId++, "Yamaha", new GregorianCalendar(1999, 1, 16), 5_000));
        store.add(new Trumpet(sequenceId, "Vandoren", new GregorianCalendar(2001, 1, 3), 1_000));

        System.out.println();
        store.report();

        /*Preparing and shipping goods*/
        try {
            Map<String, Integer> goods = new HashMap<String, Integer>();
            goods.put("piano", 1);
            goods.put("trumpet", 2);
            goods.put("guitar", 4);
            System.out.println();
            System.out.println("The goods ordered: " + goods);
            List<MusicalInstrument> shippedGoods = store.prepareInstruments(goods);
            System.out.println("The goods shipped: " + shippedGoods);
        } catch (NotEnoughGoodsExceptionInTheStore e) {
            System.out.println("There aren't enough goods '" + e.getGood() + "' in the Music Store. It was ordered '" + e.getOrderedCount() + "' item, but '" + e.getExistedCount() + "' is present.");
        } catch (CountOfGoodsException e) {
            System.out.println("The count of goods must be a positive. Count of goods '" + e.getGood() + "' is '" + e.getCount() + "'.");
        } catch (GoodException e) {
            System.out.println("Such goods '" + e.getGood() + "' is not presented in the Music Store. Valid values are " + Arrays.toString(MusicStore.Goods.values()));
        }

        System.out.println();
        store.report();

//        System.out.println();
//        System.out.println("Instruments are configuring...");
//        store.item(10).play("Rahmaninov Simph.#1 for piano");
//        store.item(3).play("Romans");
//        store.item(5).play("Get up");
//
//        try {
//            System.out.print("Playing not existed item... ");
//            store.item(4000).play("Get up");
//        } catch (NullPointerException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        store.playAll("Rahmaninov Simph.#1 for piano with orchestra");
//
//        System.out.println();
//        store.remove(10);
//        try {
//            System.out.print("Removing not existed item... ");
//            store.remove(1258);
//        } catch (NullPointerException e) {
//            System.out.println(e);
//        }
//
//        System.out.println();
//        store.report();
//
//        System.out.println();
//        store.clear();
//
//        System.out.println();
//        store.report();
    }
}
