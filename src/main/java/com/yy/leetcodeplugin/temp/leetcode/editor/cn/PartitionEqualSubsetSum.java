
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-08 10:35:41 
//分割等和子集

import java.util.Arrays;

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
         Solution solution = new PartitionEqualSubsetSum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        /**
         * 将问题转化成从数组中选出一些元素，使他们的和等于 总和的一半
         * 然后转换为01背包问题.
         * dp[i][j] 表示前i个数组能否凑出j(注意前i个不是说第i个一定要到用，而是说可以用也可以不用)
         * dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]] //不选择当前元素凑出j 或者 使用当前元素凑出j
         */
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;//总和必须是偶数
        }

        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        Arrays.fill(dp[0], false);//前0个数肯定凑不出，除了0以外
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = false;//正整数凑不出0
        }
        dp[0][0] = true; //0可以凑出0

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
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

  //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2218 👎 0
