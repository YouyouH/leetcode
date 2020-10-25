package com.yy.quicksort.quicksort_algs4_cs_princeton.review4;

import com.yy.quicksort.Sort;

public class Quick3WaySort implements Sort {

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        sort(array, 0, length - 1);
    }

    private void sort(Comparable[] array, int start, int end) {
        if (start >= end) return;

        int lt = start;
        int gt = end;
        Comparable v = array[start];
        int i = lt + 1;
        while (i <= gt) {
            int compare = array[i].compareTo(v);
            if (compare > 0) {
                exch(array, i, gt--);
            } else if (compare < 0) {
                exch(array, lt++, i++);
            } else {
                i++;
            }
        }
        sort(array, start, lt - 1);
        sort(array, gt + 1, end);
    }

    private void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
