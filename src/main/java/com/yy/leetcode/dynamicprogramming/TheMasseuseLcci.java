package com.yy.leetcode.dynamicprogramming;

public class TheMasseuseLcci {

    public int massage(int[] nums) {
        //dp[i] 表示前i个预约的最大时长
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
