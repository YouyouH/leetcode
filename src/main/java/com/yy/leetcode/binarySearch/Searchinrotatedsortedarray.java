package com.yy.leetcode.binarySearch;

/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 * <p>
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Searchinrotatedsortedarray {

    public int search(int[] nums, int target) {
        if (null == nums) return -1;

        int size = nums.length;

        int l = 0;
        int r = size - 1;

        while (l <= r) {
            int middle = (l + r) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if(nums[middle] >= nums[0]){
                //用nums[0]比较而不是用nums[l]比较是因为我们需要判断的是各个区间的单调性
                if(nums[middle] > target && nums[0] <= target){
                    r = middle -1;
                }else {
                    l = middle +1;
                }
            }else{
                if(nums[middle] < target && target <= nums[size-1]) {
                    l = middle + 1;
                }else {
                    r = middle -1;
                }
            }
        }
        return -1;
    }
}
