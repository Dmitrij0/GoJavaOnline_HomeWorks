package com.gojavaonline3.dlenchuk.module03.flowers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DLenchuk on 26.05.2016.
 *
 */
public class BouquetOfFlowers {

    private final List<Flower> flowers = new ArrayList<>();

    public boolean add(Flower flower) {
        return flowers.add(flower);
    }

    public Flower remove(int index) {
        return flowers.remove(index);
    }

    public Flower flower(int index) {
        return flowers.get(index);
    }

    public int size() {
        return flowers.size();
    }

    public boolean remove(Flower flower) {
        return flowers.remove(flower);
    }

    public void add(List<Flower> flowers) {
        this.flowers.addAll(flowers);
    }

    @Override
    public String toString() {
        return "BouquetOfFlowers{" +
                "cipher=" + flowers +
                '}';
    }
}
