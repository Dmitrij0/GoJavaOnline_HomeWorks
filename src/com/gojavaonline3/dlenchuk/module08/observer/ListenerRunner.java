package com.gojavaonline3.dlenchuk.module08.observer;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableArrayBase;
import javafx.event.Event;

import java.io.IOException;
import java.util.Random;

/**The Runner of the Observer Pattern
 * @author Dmitrij Lenchuk
 * @since  16.06.2016.
 */
public class ListenerRunner {

    public static void main(String[] args) throws IOException {

        final FileListener<Integer> fileListener = new FileListener<>("tmp.log");
        try {
            Integer[] list = new Integer[new Random().nextInt(50)];
            for (int i = 0; i < list.length; i++) {
                list[i] = new Random().nextInt(1000);
            }

            ObservableArrayList<Integer, Listener<Integer>> frame = new ObservableArrayList<>();

            frame.addListener(new ConsoleListener<>());
            frame.setList(list);

            System.out.println("Creating the Observable Array List...");

            System.out.println();
            System.out.println("Sorting by Merge the Observable Array List ...");
            long time = System.nanoTime();
            frame.mergeSort();
            System.out.println(String.format("%.2f", (System.nanoTime() - time) / 1e6) + "msec");

            System.out.println();
            System.out.println("Creating the Observable Array List...");
            frame = new ObservableArrayList<>();

            frame.addListener(new ConsoleListener<>());
            frame.setList(list);

            System.out.println("Sorting by Bubble the Observable Array List...");
            time = System.nanoTime();
            frame.bubbleSort();
            System.out.println(String.format("%.2f", (System.nanoTime() - time) / 1e6) + "msec");

            System.out.println();
            System.out.println("Adding element '333' to the position '2'...");
            frame.add(2, 333);

            System.out.println();
            System.out.println("Adding element '3333' to the end...");
            frame.add(3333);

            System.out.println();
            System.out.println("Removing element from the position '2'...");

            try {
                frame.remove(2);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.printf("Array Index '2' Out Of BoundsException");
            }

            System.out.println();
            System.out.println("Removing element '3333'...");
            frame.remove((Integer) 3333);
        } finally {
            fileListener.writeToFile();
        }

    }

}
