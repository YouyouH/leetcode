
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-30 10:02:10 
//买卖股票的最佳时机 IV

public class BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
         Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        /**
         * FIXME
         *  dp[i][k][2] //表示前i天 最多 交易k次，在持有或者不持有的情况下的最大利润
         */
        int length = prices.length;
        int[][][] dp = new int[length][k + 1][2];

        //初始化
        for (int i = 0; i < k + 1; i++) {
            //第一天持有
            dp[0][i][0] = -prices[0];
            //第一天不持有
            dp[0][i][1] = 0;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < k + 1; j++) {
                //当前持有      前一天也持有,没有交易   前一天不持有，今天买入，新增交易
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                //当前不持有    前一天也不持有，没有交易   前一天持有，今天卖出，没有新的交易（买入卖出才是新的交易）
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }
        return dp[length-1][k][1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1241 👎 0
