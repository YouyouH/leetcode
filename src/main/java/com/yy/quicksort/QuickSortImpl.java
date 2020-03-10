package com.yy.quicksort;

/**
 * @author youyouhuang
 * @create 2020-02-29
 * @desc
 **/

/**
 * https://blog.csdn.net/morewindows/article/details/6684558
 * 思路:挖坑填数+分治法
 * <p>
 * 递归函数input: array，start,end。因为是在原函数上排序所以需要起点和终点位置。
 */

public class QuickSortImpl implements QuickSort {

    @Override
    public void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(Comparable[] a, int low, int hi) {
        if (low > hi) {
            return;
        }
        int partion = partion(a, low, hi);
        quickSort(a, 0, partion - 1);
        quickSort(a, partion + 1, hi);

    }

    /**
     *<h>思路:挖坑填数</h>
     * <p>
     *   取第一个数作为基准值。
     *
     *  将基准值赋值给临时变量，此时相当于a[0] 挖了一个坑。然后从最右边开始移动，找到小于等于基准值的则放入坑中。
     *  此时右边就留下了一个坑，再从左边开始移动，找一个大于基准值的放到右边的坑里面。
     * 
     *  最后将基准值放入最后的坑中。
     * </p>
     *
     *
     *
     * @param a   array
     * @param low start
     * @param hi  end
     * @return
     */
    private int partion(Comparable[] a, int low, int hi) {

        Comparable middle = a[low];

        while (low < hi) {

            while (a[hi].compareTo(middle) > 0 && hi>low) {
                hi--;
            }

            //a[hi].compareTo(middle) <= 0
            if (hi > low) {
                a[low] = a[hi];
                low++;
            }

            while (a[low].compareTo(middle) < 0 && low < hi) {
                low++;
            }

            //a[low].compareTo(middle) >= 0
            if (low<hi) {
                a[hi] = a[low];
                hi--;
            }
        }
        a[low] = middle;
        return low;
    }

}
