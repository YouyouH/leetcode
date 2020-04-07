package com.yy.quicksort.quicksort_algs4_cs_princeton.review2;
/**
 * @author youyouhuang
 * @create 2020-04-05
 **/

import com.yy.leetcode.String.CompareVersionNumbers;
import com.yy.quicksort.Sort;

/**
 * <p>
 *
 * </p>
 **/
public class QuickSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int l = lo;
        int h = hi;
        int i = lo + 1;
        Comparable pivot = array[lo];
        while (i <= h) {
            int compare = array[i].compareTo(pivot);
            if (compare > 0) {
                exch(array, i, h--);
            } else if (compare < 0) {
                exch(array,l++,i++);
            } else {
                i++;
            }
        }
        quickSort(array,lo,l-1);
        quickSort(array,h+1,hi);
    }

    private void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
