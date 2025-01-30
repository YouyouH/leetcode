
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-30 10:24:47 
//买卖股票的最佳时机含手续费

public class BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
         Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        /**
         * 状态机DP
         */
//        int length = prices.length;
//
//        int[][] dp = new int[length][2];
//        //初始化
//        dp[0][0] = -prices[0] - fee;
//        dp[0][1] = 0;
//
//        for (int i = 1; i < length; i++) {
//            //当前持有    前一天持有     前一天不持有，今天买入，规定在买入扣手续费
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
//            //当前不持有
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//
//        }
//        return dp[length-1][1];

        /**
         * 下面进行了状态压缩，把天这个维度压缩了。滚动数组的思想
         */
        int length = prices.length;

        int[] dp = new int[2];
        //初始化
        dp[0] = -prices[0] - fee;
        dp[1] = 0;

        for (int i = 1; i < length; i++) {
            //当前持有    前一天持有     前一天不持有，今天买入，规定在买入扣手续费
            dp[0] = Math.max(dp[0], dp[1] - prices[i] - fee);
            //当前不持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);

        }
        return dp[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出：8
//解释：能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8 
//
// 示例 2： 
//
// 
//输入：prices = [1,3,7,5,10,3], fee = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1110 👎 0
