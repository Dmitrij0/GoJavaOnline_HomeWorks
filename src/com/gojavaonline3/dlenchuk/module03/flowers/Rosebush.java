package com.gojavaonline3.dlenchuk.module03.flowers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by DLenchuk on 26.05.2016.
 *
 */
public class Rosebush {

    private class Rose extends Flower {
        private Rose(Color color, int height, boolean hasSmell, State state) {
            super(color, height, hasSmell, state);
        }
    }

    private List<Rose> roses = new ArrayList<>();

    private final Color color;
    private final boolean smelled;

    public Rosebush(Color color, boolean smelled) {
        this.color = color;
        this.smelled = smelled;
    }

    public void grow() {
        if (roses.size() == 0) {
            birth();
            return;
        }

        Iterator<Rose> iterator = roses.iterator();
        while (iterator.hasNext()) {
            Rose rose = iterator.next();
            rose.setHeight(rose.getHeight() + (int)(Math.random()*40));
            switch (rose.getState()) {
                case SPROUT:
                    rose.setState(State.BUD);
                    break;
                case BUD:
                    rose.setState(State.OPENED);
                    break;
                case OPENED:
                    rose.setState(State.WILT);
                    break;
                case WILT:
                    iterator.remove();
            }
        }

    }

    public void birth() {
        int newRosesCount = (int)(Math.random()*10);
        for (int i = 0; i < newRosesCount; i++) {
            roses.add(new Rose(color, (int)(Math.random()*60), smelled, State.SPROUT));
        }
    }

    public List<Flower> trim() {
        List<Flower> roses = new ArrayList<>(this.roses);
        this.roses.clear();
        return roses;
    }

    public List<Flower> trim(State state, int height) {
        List<Flower> roses = new ArrayList<>();
        Iterator<Rose> iterator = this.roses.iterator();
        while (iterator.hasNext()) {
            Rose rose = iterator.next();
            if (rose.getState() == state && rose.getHeight() >= height) {
                roses.add(rose);
                iterator.remove();
                rose.setHeight(height);
            }
        }
        return roses;
    }

    public Rosebush transplant() {
        return new Rosebush(this.color, this.smelled);
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-8s|%5d|", color, smelled, roses.size());
    }

}
