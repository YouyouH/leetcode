package com.yy.quicksort;

/**
 * @author youyouhuang
 * @create 2020-03-28
 * @desc
 **/

public class ThreeWayQuickSort {

    public void sort(int[] nums) {
        //快速排序是原地排序。但是大量重复元素会导致复杂度退化到n^2
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int[] p = partion(nums, start, end);
        quickSort(nums, start, p[0]-1);
        quickSort(nums, p[1]+1, end);
    }

    private int[] partion(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int p = low;
        int q = high;
        int pivotValue = arr[low];
        while (p < q) {
            while (p < q && arr[q] >= pivotValue) {
                if (arr[q] == pivotValue) {
                    swap(arr, j, q);
                    j--;
                }
                q--;
            }
            while (p < q && arr[p] <= pivotValue) {
                if (arr[p] == pivotValue) {
                    swap(arr, i, p);
                    i++;
                }
                p++;
            }
            swap(arr, p, q);
        }
        if (arr[p] == pivotValue) {
            p--;
            q++;
        }
        while (i > low) {
            swap(arr, i - 1, p);
            p--;
            i--;
        }
        while (j < high) {
            swap(arr, j + 1, q);
            q++;
            j++;
        }
        return new int[]{p + 1, q - 1};
    }

    private void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
