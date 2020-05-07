package com.yy.leetcode.dynamicprogramming.dp_on_strings;
/**
 * @author youyouhuang
 * @create 2020-04-11
 **/

/**
 * <p>给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p> 示例:
 * <p> 输入: [10,9,2,5,3,7,101,18]
 * <p> 输出: 4
 * <p> 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p> 说明:
 * <p> 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * <p> 你算法的时间复杂度应该为 O(n2) 。
 * <p> 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p> 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class LongestIncreasingSubsequence {

    /**
     * dp[i] 表示以nums[i]结尾的子序列的最大长达度
     * dp[j] = max(dp[i]) + 1 (i<=0<length-1)
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = max(i, dp, nums);
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(i,result);
        }
        return result;

    }

    private int max(int boundry, int[] dp, int[] nums) {
        int max = 1;
        for (int i = 0; i < boundry; i++) {
            if(nums[boundry] > nums[i]) {
                max = Math.max(max, dp[i]+1);
            }
        }
        return max;
    }
}
