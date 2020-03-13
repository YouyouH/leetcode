package com.yy.mergesort;

import com.yy.quicksort.Sort;

/**
 * @author youyouhuang
 * @create 2020-03-13
 * @desc
 **/

/**
 * 归并排序：
 * 分治法(divide and conquer):
 * 先分成最小单元并且排序，然后再将这些单元merge
 */
public class MergeSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        //创建临时数组用来merge
        Comparable[] temp = new Comparable[a.length];

        mergeSort(a, 0, a.length - 1, temp);

    }

    private void mergeSort(Comparable[] a, int start, int end, Comparable[] temp) {

        if (start >= end) {
            return;
        }
        //divide the array into  base unit。直接采用二分法。
        int mid = (start + end) / 2;
        mergeSort(a, start, mid, temp);
        mergeSort(a, mid + 1, end, temp);
        //merge the minimal unit into temp
        merge(a, start, mid, end, temp);
    }

    /**
     * 1.the array has been splited to [start->mid] and  [mid+1->end]
     * 2.merge the two part into temp with order
     */
    private void merge(Comparable[] a, int start, int mid, int end, Comparable[] temp) {
        //pointer for left array
        int i = start;
        //pointer for right array
        int j = mid+1;
        //pointer for temp
        int t = 0;
        while(i < mid+1 && j < end+1){
            if(a[i].compareTo(a[j])<0){
                temp[t++] = a[i++];
            }else{
                temp[t++] = a[j++];
            }
        }

        //把剩余的也放到temp里面.肯定只有一个会剩下
        while(i < mid+1){
            temp[t++] = a[i++];
        }
        while(j < end+1){
            temp[t++] = a[j++];
        }

        //更新array
        t = 0;
        while(start<=end){
            a[start++] = temp[t++];
        }
    }
}
