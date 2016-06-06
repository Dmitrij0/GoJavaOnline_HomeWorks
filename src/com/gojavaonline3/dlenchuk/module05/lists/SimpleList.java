package com.gojavaonline3.dlenchuk.module05.lists;

/**
 * Created by Dmitrij Lenchuk on 05.06.2016.
 * Interface SimpleArrayList
 */
public interface SimpleList {

    public static enum SortKind {

        BUBBLE(new Sortable() {
            @Override
            public void sort(int[] list) {
                for (int i = 1; i < list.length; i++) {
                    for (int j = i; j > 0; j--) {
                        if (list[j] < list[j - 1]) {
                            int buffer = list[j];
                            list[j] = list[j - 1];
                            list[j - 1] = buffer;
                        }
                    }
                }
            }
        }),
        MERGE(new Sortable() {
            @Override
            public void sort(int[] list) {
                // ToDo;
            }
        }),
        DO_NOT_SORT(new Sortable() {
            @Override
            public void sort(int[] list) {
                // NOP;
            }
        });

        private final Sortable sort;

        SortKind(Sortable sort) {
            this.sort = sort;
        }

        public Sortable getSort() {
            return sort;
        }
    }

    public int min();

    public int max();

    public void sort();

    public Sortable getSort();

    public void setSort(Sortable sort);

    public int length();
}