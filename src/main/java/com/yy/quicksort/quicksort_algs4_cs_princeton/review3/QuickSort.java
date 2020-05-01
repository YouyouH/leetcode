package com.yy.quicksort.quicksort_algs4_cs_princeton.review3;
/**
 * @author youyouhuang
 * @create 2020-05-01
 **/

/**
 * <p>
 *
 * </p>
 **/
public class QuickSort {

    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] array, int lo, int hi) {
        if(hi<= lo){
            return;
        }
        int start = lo;
        int end = hi;
        int i = lo + 1;
        Comparable pivot = array[lo];

        while (i <= end) {
            int comare = pivot.compareTo(array[i]);
            if (comare > 0) {
                swap(array, i++, start++);
            } else if (comare < 0) {
                swap(array, i, hi--);
            } else {
                i++;
            }
        }
        quickSort(array, lo, start - 1);
        quickSort(array, end + 1, hi);
    }

    private void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
