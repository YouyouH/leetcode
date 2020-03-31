package com.yy.quicksort.quicksort_algs4_cs_princeton.review1;

import com.yy.quicksort.Sort;

/**
 * @author youyouhuang
 * @create 2020-03-30
 * @desc 三路快排复习
 **/

public class Quick3wayReview implements Sort {

    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] array, int start, int end) {
        if(start>=end){
            return;
        }
        //lo 和 hi 是边界
        int lo = start;
        int hi = end;
        int i = start + 1;
        Comparable piviot = array[start];

        //i需要和hi相遇
        while (i <= hi) {
            int compare = array[i].compareTo(piviot);
            if (compare >0) {
                exch(array,i,hi--);
            } else if (compare <0) {
                exch(array,lo++,i++);
            } else {
                //equal
                i++;
            }
        }
        quickSort(array,0,lo-1);
        quickSort(array,hi+1,end);
    }

    private void exch(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
