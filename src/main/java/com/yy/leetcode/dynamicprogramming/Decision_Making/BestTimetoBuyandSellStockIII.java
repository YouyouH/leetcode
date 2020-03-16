package com.yy.leetcode.dynamicprogramming.Decision_Making;

/**
 * @author youyouhuang
 * @create 2020-03-15
 * @desc 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/


public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int length = prices.length;

        //dp[i][k][j]
        int[][][] dp = new int[length][2][2];

        //010  011 021 020
        dp[0][0][0] = -prices[0];




        //可以交易最多两次。交易次数现在也要考虑进去，设k = 1,2。1表示最大一次，也可以为0次。 j=1表示不持有，j=0表示持有。
        //
        for (int i = 1; i < length; i++) {
            //不持有,交易0次，则前一个状态为不持有
            //持有,交易0次，则前一个状态为不持有,或者前一个状态为持有，现在不动
           //这两种情况都是 0.

            //不持有，最多交易一次，则前一个状态可以为 （之前持有现在卖出）(之前卖出，现在不动)
            dp[i][1][1] = Math.max(dp[i - 1][1][0] + prices[i],dp[i-1][1][1]);

            //持有，最多交易一次，则前一个状态可以为 (之前没交易过，现在买入)(之前卖出了不持有，现在买入)(之前持有,现在不动)
            //(之前卖出了不持有，现在买入) 这个不成立，因为最多交一次就不该再买了。
            dp[i][1][0] = Math.max(-prices[i],dp[i-1][1][0]);

            //持有，交易两次，则前一个状态为 (不持有现在买入) (持有现在不动)
            dp[i][2][0] = Math.max(dp[i - 1][2][1] -prices[i], dp[i - 1][2][0]);

            //不持有，交易两次，则前一个状态为 (不持有) （持有，现在卖出）
            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][2][0] + prices[i]);
        }

        return dp[length - 1][2][1];
    }
}
