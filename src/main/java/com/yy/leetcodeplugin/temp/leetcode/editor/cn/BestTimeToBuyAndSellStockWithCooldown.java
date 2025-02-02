
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-02 11:28:48 
//买卖股票的最佳时机含冷冻期

public class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
         Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 状态机DP
         * dp[i][2] 第i天持有/不持有的情况下的最大利润
         *
         * FIXME:下面的解法可以通过，但是状态定义不清晰。因为加入了冷冻期，所以最好定义三种状态：
         *      1.当前持有
         *      2.当前不持有且处于冷冻起，第二天不可以买入
         *      3.当前不持有且第二天可以买入
         */
        int length = prices.length;
        int[][] dp = new int[length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];//

        for (int i = 1; i < length + 1; i++) {
            //当前不持有 前一天也不持有   前一天持有，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            //当前持有             前一天也持有  前两天卖出（不持有）然后冷却一天，今天买入
            //                               FIXME 不持有不一定表示当天卖出了
            if (i - 2 >= 0) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
            } else {
                dp[i][1] = dp[i - 1][1];
            }
        }
        return dp[length][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1813 👎 0
