package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-08
 **/

/**
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class BestTimetoBuyandSellStockII {

    //状态: 前i天, k次交易，当前持有或者不持有。由于可以无限次交易所以不需要考虑k的状态。
    //dp[i][j]
    public int maxProfit(int[] prices) {
        if(prices == null ||prices.length < 2){
            return 0;
        }
        int days = prices.length;
        int[][] dp = new int[days+1][2];

        dp[1][1] = -prices[0];

        for (int i = 2; i <=days ; i++) {
            //当前不持有 = max(前一天不持有，前一天持有，当前卖了)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);

            //当前持有 = max(前一天不持有，今天买入，前一天持有，今天不变)
            dp[i][1] = Math.max(dp[i-1][0]-prices[i-1],dp[i-1][1]);
        }
        return dp[days][0];
    }
}
