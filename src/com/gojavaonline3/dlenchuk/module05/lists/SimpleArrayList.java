package com.gojavaonline3.dlenchuk.module05.lists;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Dmitrij Lenchuk on 04.06.2016.
 * Class Simple Array List
 */
public class SimpleArrayList<T extends Number & Comparable<T>> implements SimpleList<T> {

    private T[] list;
    private boolean sorted = false;

    public SimpleArrayList(T[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("List must be not null and have one item at least");
        }

        this.list = list;
    }

    public boolean isSorted() {
        return sorted;
    }

    @Override
    public int indexOf(T item) {
        if (isSorted()) {
            return Arrays.binarySearch(list, item);
        } else {
            for (int i = 0; i < length(); i++) {
                if (list[i].equals(item)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean add(T item) {
        T[] list = Arrays.copyOf(this.list, length() + 1);
        list[list.length - 1] = item;
        this.list = list;

        return true;
    }

    @Override
    public void add(int index, T item) {
        int countForShifting = length() - index;
        T[] list = Arrays.copyOf(this.list, length() + 1);
        System.arraycopy(this.list, index, list, index + 1, countForShifting);
        list[index] = item;
        this.list = list;
    }

    @Override
    public boolean remove(T item) {
        remove(indexOf(item));
        return false;
    }

    @Override
    public T remove(int index) {
        T result = list[index];
        int countForShifting = length() - index - 1;
        T[] list = Arrays.copyOf(this.list, length() - 1);
        System.arraycopy(this.list, index + 1, list, index, countForShifting);
        this.list = list;

        return result;
    }

    @Override
    public int length() {
        return list.length;
    }


    @Override
    public SimpleList<T> bubbleSort() {
        T[] list = Arrays.copyOf(this.list, this.list.length);
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j].compareTo(list[j - 1]) < 0) {
                    T buffer = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = buffer;
                }
            }
        }

        return new SimpleArrayList<>(list);
    }

    @Override
    public SimpleList<T> mergeSort() {
        T[] mergedList = Arrays.copyOf(list, list.length);
        int base = 2;
        final int lastIndex = (mergedList.length % 2 == 0) ? mergedList.length : mergedList.length - 1;

        do {
            int shift = base / 2;
            for (int i = 0; i < lastIndex; i += base) {
                final int lastItem = i + 2 * shift - 1 < mergedList.length ? i + 2 * shift - 1 : mergedList.length - 1;
                final T[] merge = merge(mergedList, i, i + shift - 1, i + shift, lastItem);
                System.arraycopy(merge, 0, mergedList, i, merge.length);
            }
        } while ((base *= 2) / 2 <= mergedList.length);

        return new SimpleArrayList<>(mergedList);
    }

    public T[] merge(final T[] list, final int minorMin, final int minorMax, final int majorMin, final int majorMax) {
        int minorCurrent = minorMin;
        int majorCurrent = majorMin;
        int counter = 0;
        T[] result = Arrays.copyOfRange(list, minorMin, majorMax + 1);

        while (minorCurrent <= minorMax && majorCurrent <= majorMax) {
            T item;
            if (list[minorCurrent].compareTo(list[majorCurrent]) < 0) {
                item = list[minorCurrent++];
            } else {
                item = list[majorCurrent++];
            }
            result[counter++] = item;
        }

        int current = (minorCurrent > minorMax) ? majorCurrent : minorCurrent;
        System.arraycopy(list, current, result, counter, result.length - counter);

        return result;
    }

    @Override
    public T min() {
        if (sorted) {
            return list[0];
        } else {
            T min = list[0];
            for (int i = 1; i < list.length; i++) {
                if (min.compareTo(list[i]) > 0) {
                    min = list[i];
                }
            }

            return min;
        }
    }

    @Override
    public T max() {
        if (sorted) {
            return list[list.length - 1];
        } else {
            T max = list[0];
            for (int i = 1; i < list.length; i++) {
                if (max.compareTo(list[i]) < 0) {
                    max = list[i];
                }
            }

            return max;
        }
    }

    @Override
    public String toString() {
        return "IntSimpleArrayList(min=" + min() + ";max=" + max() + "){" +
                "list=" + Arrays.toString(list) +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator<T> {

        int counter;

        @Override
        public boolean hasNext() {
            return counter != list.length;
        }

        @Override
        public T next() {
            return list[counter++];
        }
    }

}
