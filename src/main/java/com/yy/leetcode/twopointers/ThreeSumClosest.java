package com.yy.leetcode.twopointers;


import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    //和3sum思路相同
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

//            if (((nums[i] + nums[l] + nums[r]) - target) == 0) return nums[i] + nums[l] + nums[r];

            while (l < r) {
                if (((nums[i] + nums[l] + nums[r]) - target) > 0) {
                    if (Math.abs((nums[i] + nums[l] + nums[r]) - target) < diff) {
                        result = nums[i] + nums[l] + nums[r];
                        diff = Math.abs(result - target);
                        while (l < r && nums[r] == nums[r - 1]) r--;
                    }
                    r--;
                } else {
                    if (Math.abs((nums[i] + nums[l] + nums[r]) - target) < diff) {
                        result = nums[i] + nums[l] + nums[r];
                        diff = Math.abs(result - target);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                    }
                    l++;
                }
            }
        }
        return result;
    }
}
