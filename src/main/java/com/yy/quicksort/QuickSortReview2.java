package com.yy.quicksort;

/**
 * @author youyouhuang
 * @create 2020-03-13
 * @desc
 **/

/**
 * 思路：将数组分成左右两半，左边<中间值<右边
 *
 * 问题:
 * 1.左右两边值交换以后没有移动左右指针
 * 2.指针移动没有注意边界调节
 */
public class QuickSortReview2 implements Sort {
    @Override
    public void sort(Comparable[] a) {
        //递归，输入是数组，数组起点，数组终点
        quickSort(a,0,a.length-1);

    }

    private void quickSort(Comparable[] a, int start, int end) {
        //递归终止条件
        if(start > end){
            return;
        }
        //partition方法会将数组分为左中右三部分
        int partition = partition(a,start,end);
        quickSort(a,start,partition-1);
        quickSort(a,partition+1,end);

    }

    private int partition(Comparable[] a, int left, int right) {
        //取第一个作为中间值
        Comparable middle = a[left];

        while(left<right){
            while(a[right].compareTo(middle)>0 && right > left){
                right--;
            }
            if(left < right) {
                a[left] = a[right];
                //指针需要移动
                left++;
            }


            while(a[left].compareTo(middle)<0 && right > left){
                left++;
            }

            if(left<right){
                a[right] = a[left];
                right--;
            }

        }
        a[left] = middle;
        return left;
    }
}
