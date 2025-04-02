
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-29 20:37:16 
//最大子数组和

public class MaximumSubarray{
    public static void main(String[] args) {
         Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray2(int[] nums) {
        /**
         * 穷解：？
         *
         * 看得题解
         *      方案一：前缀和
         *      方案二：动态规划
         *          dp[n] 表示以nums[n]结尾的数组的最大和
         *          dp[n] = dp[n-1] + nums[n] || nums[n]  (dp[n-1]为负数)
         *
         */

        int[] dp = new int[nums.length]; //FIXME:  优化 不需要DP数组，只需要用一个临时变量记录前一个值
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
//            System.out.println("index:" + i + " value:" + dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

        public int maxSubArray(int[] nums) {
            /**
             * 方案二 前缀和
             * FIXME 前缀和最大值减去前缀和最小值
             */

            int len = nums.length;
            int[] sum = new int[len];

            sum[0] = nums[0];
            int min = Math.min(0, nums[0]);//FIXME:遍历是从1开始的所以这里要提前判断
            int res = nums[0];

            for (int i = 1; i < len; i++) {
                sum[i] = sum[i - 1] + nums[i];
                res = Math.max(res, sum[i] - min);//FIXME 前缀和最大值减去前面前缀和的最小值，然后下一行再更新当前的最小值
                min = Math.min(min, sum[i]);
            }
//            System.out.println("min=" + min);
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
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
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6876 👎 0
