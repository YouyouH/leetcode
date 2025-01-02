
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-31 13:23:20 
//乘积最大子数组

public class MaximumProductSubarray{
    public static void main(String[] args) {
         Solution solution = new MaximumProductSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        /**
         * 动态规划：
         *   跟求子集和类似
         *   dp[n] = max(dp[n-1]*nums[i], nums[i]) // 如果 dp[n-1] * nums[i] 是不是正数
         *
         *   FIXME 上面思路是错误的
         *      乘积最大考虑两种情况：
         *          1. 最大值 乘以 当前值 （正数乘以正数）
         *          2，最小值 乘以 当前值 （负数乘以负数）
         */
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0]; //非空子数组
        dpmin[0] = nums[0]; //非空子数组

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //注意下面方程式比较绕
            dpmax[i] = Math.max(Math.max(dpmax[i - 1] * nums[i],dpmin[i - 1] * nums[i]), nums[i]);
            dpmin[i] = Math.min(Math.min(dpmax[i - 1] * nums[i],dpmin[i - 1] * nums[i]), nums[i]);
            System.out.println("max=" + dpmax[i] + " min=" + dpmin[i] + " ans=" + ans);
            ans = Math.max(ans, Math.max(dpmax[i], dpmin[i]));
        }

        return ans;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2359 👎 0
