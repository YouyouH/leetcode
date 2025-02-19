
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-27 11:15:29 
//打家劫舍

public class HouseRobber{
    public static void main(String[] args) {
         Solution solution = new HouseRobber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        /**
         * 前n个房子偷到的最高金额。注意定义是前n个房子，下标是n-1
         * dp[n] = max(dp[n-2] + nums[n-1], dp[n-1])
         *
         * dp[0] = 0   dp[1] = nums[0]
         *
         * FIXME： 相邻的房子都不能偷，为什么只考虑前面的不考虑后面的？
         *         已经考虑了， dp[n] = max(dp[n-2] + nums[n-1], dp[n-1])  dp[n-1]就表示了后面的不能偷
         *
         **/
        if (1 == nums.length) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);//FIXME: 优化一下 不需要记录整个dp数组
        }

        return dp[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 3144 👎 0
