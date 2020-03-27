package com.yy.leetcode.twopointers;

/**
 * @author youyouhuang
 * @create 2020-03-27
 * @desc https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 **/

public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int result = 1;
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[j - 1]) {
                j++;
                continue;
            }
            nums[i] = nums[j];
            i++;
            j++;
            result++;
        }
        return result;
    }
}
