package com.gojavaonline3.dlenchuk.module05.lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Dmitrij Lenchuk on 04.06.2016.
 * Class Simple Array List
 */
public class SimpleArrayList<T extends Number & Comparable<T>> implements SimpleList<T> {

    private Object[] list = new Object[]{};

    private boolean sorted = false;

    protected SimpleArrayList() {
    }

    protected SimpleArrayList(T[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("List must be not null and have one item at least");
        }

        this.list = list;
    }

    @SuppressWarnings("unchecked")
    public T[] getList() {
        return list.length == 0 ? null : (T[])list;
    }

    protected void setList(T[] list) {
        this.list = (list == null ? new Object[]{} : list);
    }

    private boolean isSorted() {
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
    @SuppressWarnings("unchecked")
    public boolean add(T item) {
        Object[] list = Arrays.copyOf(this.list, length() + 1);
        list[list.length - 1] = item;
        this.list = list;

        return true;
    }

    @Override
    public void add(int index, T item) {
        if (index >= list.length) {
            add(item);
            return;
        }
        int countForShifting = length() - index;
        Object[] list = Arrays.copyOf(this.list, length() + 1);
        System.arraycopy(this.list, index, list, index + 1, countForShifting);
        list[index] = item;
        this.list = list;
    }

    @Override
    public void add(T[] list) {
        if (length() == 0) {
            this.list = list;
        } else {
            Object[] extendedList = Arrays.copyOf(this.list, length() + list.length);
            System.arraycopy(list, 0, extendedList, length(), list.length);
            this.list = extendedList;
        }
    }

    @Override
    public boolean remove(T item) {
        remove(indexOf(item));
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Object result = list[index];
        int countForShifting = length() - index - 1;
        Object[] list = Arrays.copyOf(this.list, length() - 1);
        System.arraycopy(this.list, index + 1, list, index, countForShifting);
        this.list = list;

        return (T)result;
    }

    @Override
    public int length() {
        return list.length;
    }


    @Override
    @SuppressWarnings("unchecked")
    public SimpleList<T> bubbleSort() {
        if (list.length == 0)
            return this;
        T[] list = Arrays.copyOf((T[])this.list, this.list.length);
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
    @SuppressWarnings("unchecked")
    public SimpleList<T> mergeSort() {
        if (list.length == 0)
            return this;
        T[] mergedList = Arrays.copyOf((T[])list, list.length);
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

    private T[] merge(final T[] list, final int minorMin, final int minorMax, final int majorMin, final int majorMax) {
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
    @SuppressWarnings("unchecked")
    public T min() {
        if (sorted) {
            return (T)list[0];
        } else {
            T min = (T)list[0];
            for (int i = 1; i < list.length; i++) {
                if (min.compareTo((T)list[i]) > 0) {
                    min = (T)list[i];
                }
            }

            return min;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T max() {
        if (sorted) {
            return (T)list[list.length - 1];
        } else {
            T max = (T)list[0];
            for (int i = 1; i < list.length; i++) {
                if (max.compareTo((T)list[i]) < 0) {
                    max = (T)list[i];
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
        @SuppressWarnings("unchecked")
        public T next() {
            return (T)list[counter++];
        }

    }

}
