
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-16 17:14:31 
//零钱兑换

import java.util.Arrays;

public class CoinChange{
    public static void main(String[] args) {
         Solution solution = new CoinChange().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        /**
         * 完全背包，跟01背包相比物品数量是无穷的
         */
        int[][] dp = new int[coins.length + 1][amount + 1];
        //初始化,凑不出来的用100000表示
        Arrays.fill(dp[0], 100000);
        dp[0][0] = 0;

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                //dp[i][j] 表示使用前i个硬币凑出j的最小金币数。两个状态：不选当前硬币， 选当前硬币  取最小值
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
//                System.out.println("i=" + i + " j=" + j + " value=" + dp[i][j]);

            }
        }
        return dp[coins.length][amount] == 100000 ? -1 : dp[coins.length][amount];

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2960 👎 0
