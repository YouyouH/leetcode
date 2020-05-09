package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-06
 **/

import java.util.Arrays;

/**
 * <p>给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>注意:
 * <p>每个数组中的元素不会超过 100
 * <p>数组的大小不会超过 200
 * <p>
 * <p>示例 1:
 * <p>输入: [1, 5, 11, 5]
 * <p>输出: true
 * <p>解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * <p>来源：力扣（LeetCode）
 * <p>链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * <p>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 **/
public class PartitionEqualSubsetSum {

    /**
     * <p>1.找出有哪些状态。
     * <p>数组元素个数
     * <p>总和(要等于sum/2)
     * <p></p>
     * <p>2.定义dp[i][j]。
     * <p>i表示前i个元素，j表示总和。dp[i][j]表示能不能分割
     * <p>能做出的选择：把i放入/不把i放入
     * <p>最终答案为dp[i][sum/2]
     * <p>
     * <p>3.定义状态转移方程
     * <p>如果不选择i,则dp[i][j] = dp[i-1][j]
     * <p>如果选择i,则dp[i][j] = dp[i-1][j-nums[i-1]]  (第i个元素的大小为nums[i-1])
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (0 != sum % 2) {
            return false;
        }
        int numbers = nums.length;
        int total = sum / 2;
        boolean[][] dp = new boolean[numbers + 1][total + 1];
        //dp[0][] = 0
        //dp[][0] = 0
        for (int i = 0; i < total + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < numbers + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < numbers + 1; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[numbers][total];
    }
}
