
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-08 10:49:45 
//目标和

import java.util.Arrays;

public class TargetSum{
    public static void main(String[] args) {
         Solution solution = new TargetSum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /**
         * 先把所有数加起来得到总和，然后再将部分挑出来变成负数
         * A+B = sum
         * A-B = target
         * 2B = sum-target
         * B = (sum-target)/2
         * 所以问题变成从数字中挑选出一些数字集合B，使它们的和为 (sum-target)/2
         * 01背包问题
         */

        //要确保sum是正数
        int sum = 0;
        if (target >= 0) {
            sum = Arrays.stream(nums).sum();
            if ((sum - target) % 2 != 0) {
                return 0;
            }
            if(target > sum){
                return 0;
            }
            sum = (sum - target) / 2;
        } else {
            sum = Arrays.stream(nums).sum();
            if ((sum + target) % 2 != 0) {
                return 0;
            }
            if(target< (-sum)){
                return 0;
            }
            sum = (sum + target) / 2;
        }



        int[][] dp = new int[nums.length + 1][sum + 1];

        dp[0][0] = 1;//0个数凑出0的方案是 1
        dp[1][0] = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 2059 👎 0
