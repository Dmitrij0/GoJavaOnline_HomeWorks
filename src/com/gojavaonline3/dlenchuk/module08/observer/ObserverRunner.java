package com.gojavaonline3.dlenchuk.module08.observer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**The Runner of the Observer Pattern
 * @author Dmitrij Lenchuk
 * @since  16.06.2016.
 */
public class ObserverRunner {

    public static void main(String[] args) throws IOException {
        Integer[] list = new Integer[(int) (Math.random() * 100)];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 1000);
        }
        Set<Observer<Integer>> observers = new HashSet<>();
        observers.add(new ConsoleObserver<Integer>());
        observers.add(new FileObserver<Integer>("tmp.log"));

        System.out.println("Creating the Observerable Array List...");
        ObservableArrayList<Integer, Observer<Integer>> frame = new ObservableArrayList<Integer, Observer<Integer>>(list, observers);

        System.out.println();
        System.out.println("Sorting by Merge the Observerable Array List ...");
        long time = System.nanoTime();
        frame.mergeSort();
        System.out.println(String.format("%.2f", (System.nanoTime() - time)/1e6) + "msec");

        System.out.println();
        System.out.println("Creating the Observerable Array List...");
        frame = new ObservableArrayList<Integer, Observer<Integer>>(list, observers);

        System.out.println("Sorting by Bubble the Observerable Array List...");
        time = System.nanoTime();
        frame.bubbleSort();
        System.out.println(String.format("%.2f", (System.nanoTime() - time)/1e6) + "msec");

        System.out.println();
        System.out.println("Adding element '333' to the position '2'...");
        frame.add(2, 333);

        System.out.println();
        System.out.println("Adding element '3333' to the end...");
        frame.add(3333);

        System.out.println();
        System.out.println("Removing element from the position '2'...");
        frame.remove(2);

        System.out.println();
        System.out.println("Removing element '3333'...");
        frame.remove((Integer) 3333);

    }

}
