package com.yy.leetcode.unclear;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * https://leetcode-cn.com/problems/rotate-array/
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * @author huangyou
 */
public class rotatearray {

    //解法一: 三次反转

    /**
     * 先整体反转成[7,6,5,4,3,2,1]
     * 部分反转[5,6,7,4,3,2,1]
     * 部分反转[5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        int leftend = k%nums.length-1;
        int rightStart = leftend +1;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,leftend);
        reverse(nums,rightStart,nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
