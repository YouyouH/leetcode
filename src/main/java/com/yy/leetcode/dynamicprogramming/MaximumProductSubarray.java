package com.yy.leetcode.dynamicprogramming;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumProductSubarray {

    //标准答案（还可以压缩）
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            //考虑负数情况
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }



    //不需要记忆数组
    public int maxProduct4(int[] nums) {
        int length = nums.length;

        int max = nums[0];
        for (int  i = 0; i < length; i++) {
            int base = nums[i];
            if (base > max) {
                max = base;
            }
            for (int l = 1; l < length && l + i < length; l++) {
                base = base * nums[i + l];
                if (base > max) {
                    max = base;
                }
            }
        }
        return max;
    }


    //压缩dp数组
    public int maxProduct3(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            dp[i] = nums[i];
        }

        for (int l = 1; l < length; l++) {
            for (int i = 0; i < length && l + i < length; i++) {
                int j = l + i;
                dp[i] = dp[i] * nums[j];
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }



    //内存占用太大
    public int maxProduct2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
            if (dp[i][i] > max) {
                max = dp[i][i];
            }
        }

        for (int l = 1; l < length; l++) {
            for (int i = 0; i < length && l + i < length; i++) {
                int j = l + i;
                dp[i][j] = dp[i][j - 1] * nums[j];
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

}
