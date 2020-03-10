package com.yy.quicksort;


/**
 * @author youyouhuang
 * @create 2020-03-10
 * @desc
 **/

public class QuickSortReview implements QuickSort{

    @Override
    public void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] array, int left, int right) {
        if(left > right){
            return;
        }
        int partition = partition(array, left, right);
        quickSort(array, 0, partition - 1);
        quickSort(array, partition + 1, right);

    }

    private int partition(Comparable[] array, int left, int right) {
        Comparable base = array[left];

        while (left < right) {

            while (array[right].compareTo(base) > 0 && right > left) {
                right--;
            }
//            array[right].compareTo(base)<=0
            if(right > left) {
                array[left] = array[right];
                left++;
            }

            while (array[left].compareTo(base) < 0 && left < right) {
                left++;
            }
            if(right > left) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = base;

        return left;
    }



}
