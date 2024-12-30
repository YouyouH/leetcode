
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-30 14:16:29 
//任意子数组和的绝对值的最大值

public class MaximumAbsoluteSumOfAnySubarray{
    public static void main(String[] args) {
         Solution solution = new MaximumAbsoluteSumOfAnySubarray().new Solution();
        solution.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        /**
         * 动态规划：
         *     dp[n] 表示 nums[n] 结尾的子数组的绝对值最大
         *     dp[n] = abs(dp[n-1]+nums[n]) 或者 nums[n] , 如果dp[n-1]和nums[n] 同正或者同负则肯定绝对值最大，否则 nums[n] 更大
         * FIXME:
         *  上面分析错误。
         *  一个变量绝对值的最大值，可能是这个变量的最大值的绝对值，也可能是这个变量的最小值的绝对值（负数的情况下）。
         *  所以这题分别求子数组的最大值和子数组的最小值，然后求绝对值的最大值就是答案。求最小值跟最大值差不多的转移公式。
         *
         *  继续优化：
         *      可以用临时变量取代两个dp数组
         */

        int[] dpmax = new int[nums.length];//子数组的和的最大值
        int[] dpmin = new int[nums.length];//子数组的和的最小值

        dpmax[0] = Math.max(nums[0], 0);
        dpmin[0] = Math.min(nums[0], 0);

        int ans = Math.max(dpmax[0], -dpmin[0]);

        for (int i = 1; i < nums.length; i++) {
            dpmax[i] = Math.max(dpmax[i - 1] + nums[i], nums[i]);
            dpmin[i] = Math.min(dpmin[i - 1] + nums[i], nums[i]);

            System.out.println("i=" + i + " max value=" + dpmax[i]);
            System.out.println("i=" + i + " min value=" + dpmin[i]);
            ans = Math.max(ans, Math.max(dpmax[i], -dpmin[i]));//一个变量的绝对值的最大值要么是变量的最大值，要么是变量的最小值
            System.out.println("ans=" + ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
//numsl + numsl+1 + ... + numsr-1 + numsr) 。 
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。 
//
// abs(x) 定义如下： 
//
// 
// 如果 x 是负整数，那么 abs(x) = -x 。 
// 如果 x 是非负整数，那么 abs(x) = x 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 171 👎 0
