package com.gojavaonline3.dlenchuk.module06.musicstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitrij Lenchuk on 26.05.2016.
 * Class Music Store
 */
public class MusicStore {

    public enum Goods {
        GUITAR,
        PIANO,
        TRUMPET
    }

    private static final MusicStore instance = new MusicStore();
    private final List<MusicalInstrument> musicalInstruments = new ArrayList<>();

    private MusicStore() {
    }

    public static MusicStore getInstance() {
        return instance;
    }

    public boolean add(MusicalInstrument musicalInstrument) {
        return musicalInstruments.add(musicalInstrument);
    }

    public MusicalInstrument item(int id) {
        int index = indexOf(id);
        return index >= 0 ? musicalInstruments.get(index) : null;
    }

    private int indexOf(int id) {
        for (int i = 0; i < musicalInstruments.size(); i++) {
            if (musicalInstruments.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public boolean remove(int id) {
        return musicalInstruments.remove(item(indexOf(id)));
    }

    public void clear() {
        musicalInstruments.clear();
    }

    public void report() {
        System.out.println(musicalInstruments.size() == 0 ? "The Music Store is empty." : "Reporting...");

        musicalInstruments.forEach(System.out::println);

        System.out.println("=============================================================================");
        System.out.println("Total count: " + totalCount() + "; Total amount: $" + totalAmount());
    }

    private int totalCount() {
        return musicalInstruments.size();
    }

    public long totalAmount() {
        long result = 0;

        for (MusicalInstrument musicalInstrument : musicalInstruments) {
            result += musicalInstrument.getPrice();
        }

        return result;
    }

    public void playAll(String notes) {
        System.out.println("Concert is started...");

        for (MusicalInstrument musicalInstrument : musicalInstruments) {
            musicalInstrument.play(notes);
        }

        System.out.println("Concert is finished...");
    }

    List<MusicalInstrument> prepareInstruments(Map<String, Integer> order) throws GoodException {
        checkGoods(order);
        List<MusicalInstrument> resultList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            int counter = 0;
            Iterator<MusicalInstrument> iterator = musicalInstruments.iterator();
            while (iterator.hasNext()){
                MusicalInstrument musicalInstrument = iterator.next();
                if (musicalInstrument.getClass().getSimpleName().toLowerCase().equals(entry.getKey())) {
                    resultList.add(musicalInstrument);
                    iterator.remove();

                    if (++counter == entry.getValue()) {
                        break;
                    }
                }
            }

        }

        return resultList;
    }

    private void checkGoods(Map<String, Integer> order) throws GoodException {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            checkValidNameOfGoodInOrder(entry);
            checkValidCountOfGoodInOrder(entry);
            checkCountOfGoodInTheMusicStore(entry);
        }
    }

    private void checkValidNameOfGoodInOrder(Map.Entry<String, Integer> entry) throws GoodException {
        boolean goodExists = false;

        for (Goods good : Goods.values()) {
            if (good.name().toLowerCase().equals(entry.getKey())) {
                goodExists = true;
                break;
            }
        }

        if (!goodExists) {
            throw new GoodException(entry.getKey());
        }
    }

    private void checkValidCountOfGoodInOrder(Map.Entry<String, Integer> entry) throws CountOfGoodsException {
        if (entry.getValue() < 0) {
            throw new CountOfGoodsException(entry.getKey(), entry.getValue());
        }
    }

    private void checkCountOfGoodInTheMusicStore(Map.Entry<String, Integer> entry) throws NotEnoughGoodsExceptionInTheStore {
        int counter = 0;

        for (MusicalInstrument musicalInstrument : musicalInstruments) {
            if (musicalInstrument.getClass().getSimpleName().toLowerCase().equals(entry.getKey())) {
                if (++counter == entry.getValue()) {
                    break;
                }
            }
        }

        if (counter < entry.getValue()) {
            throw new NotEnoughGoodsExceptionInTheStore(entry.getKey(), entry.getValue(), counter);
        }
    }

}
