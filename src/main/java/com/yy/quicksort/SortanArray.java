package com.yy.quicksort;

/**
 * @author youyouhuang
 * @create 2020-03-31
 * @desc https://leetcode-cn.com/problems/sort-an-array/
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 **/

/**
 * quick three way sort
 */
public class SortanArray {

    public int[] sortArray(int[] nums) {
        if (nums == null) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int lo = start;
        int hi = end;
        int i = start + 1;
        int pivot = nums[start];
        //直到i和hi相遇
        while(i<=hi){
            //lo右边需要大于pivot,所以把右边的一个个换到i处进行比较，确保lo右边都是大于pivot的
            if(nums[i] > pivot){
                exch(nums,i,hi--);
            }else if(nums[i] < pivot){
                exch(nums,i++,lo++);
            }else{
                i++;
            }
        }
        quickSort(nums,start,lo-1);
        quickSort(nums,hi+1,end);

    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
