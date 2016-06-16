package com.gojavaonline3.dlenchuk.module08.flowers;

import com.gojavaonline3.dlenchuk.module03.flowers.Color;
import com.gojavaonline3.dlenchuk.module03.flowers.Rosebush;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of Greenhouse
 *
 * @author Dmitrij Lenchuk
 * @since 15.06.2016.
 */
public class Greenhouse {

    private final List<Rosebush> rosebushes = new ArrayList<>();

    Greenhouse(int countOfRosebushes) {
        this(countOfRosebushes, (int) (Math.random() * 100));
    }

    /** Constructor
     *  @param countOfRosebushes Count of rosebushes in the greenhouse
     *  @param countOfDays Count of days
    * */
    Greenhouse(int countOfRosebushes, int countOfDays) {
        for (int i = 0; i < countOfRosebushes; i++) {
            final Rosebush rosebush = new Rosebush(Color.values()[(int) (Math.random() * 8)], (int) (Math.random() * 2) == 1);
            rosebushes.add(rosebush);
        }
        grow(countOfDays);
    }

    /** Constructor
     *  @param rosebush Rosebush kind will grow in the greenhouse
     *  @param countOfRosebushes Count of rosebushes in the greenhouse
     *  @param countOfDays Count of days
     * */
    Greenhouse(Rosebush rosebush, int countOfRosebushes, int countOfDays) throws CloneNotSupportedException {
        add(rosebush, countOfRosebushes);
        grow(countOfDays);
    }

    /**Growing of rosebush
     * @param rosebush rosebush
     * @param countOfDays Count of days
     * */
    public void grow(Rosebush rosebush, int countOfDays) {
        for (int j = 0; j < countOfDays; j++) {
            rosebush.grow();
        }
    }

    /**Growing of the all rosebushes in the greenhouse
     * @param countOfDays Count of days
     * */
    public void grow(int countOfDays) {
        rosebushes.forEach(rosebush -> grow(rosebush, countOfDays));
    }

    /**Adding rosebush
     * @param rosebush rosebush
     *
     * @return boolean
     * */
    public boolean add(Rosebush rosebush) {
        return rosebushes.add(rosebush);
    }

    /**Cloning rosebushes
     * @param rosebush The rosebush
     * @param countOfRosebushes Count of rosebushes will be cloned from <tt>rosebush</tt>
     * */
    public void add(Rosebush rosebush, int countOfRosebushes) throws CloneNotSupportedException {
        for (int i = 0; i < countOfRosebushes; i++) {
            rosebushes.add(rosebush.transplant());
        }
    }

    /**Adding the list of rosebushes
     * @param rosebushes The List of rosebushes
     * */
    public void add(List<Rosebush> rosebushes) {
        this.rosebushes.addAll(rosebushes);
    }

    /**The greenhouse reporting
     * */
    public void report() {
        System.out.println("The rosebushes of the greenhouse");
        System.out.println("---------------------------");
        System.out.println(String.format("|%-10s|%-8s|%-5s|", "color", "smelled", "roses"));
        System.out.println("---------------------------");
        rosebushes.forEach(System.out::println);
    }

}
