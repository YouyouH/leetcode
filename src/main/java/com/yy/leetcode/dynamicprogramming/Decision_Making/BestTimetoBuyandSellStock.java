package com.yy.leetcode.dynamicprogramming.Decision_Making;

/**
 * @author youyouhuang
 * @create 2020-03-15
 * @desc 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }

        int length = prices.length;

        int[][] dp = new int[length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        //只能交易一次
        for (int i = 1; i < length; i++) {
            //1表示不持有,则前一个状态可以为持有，或者不持有
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i],dp[i-1][1]);
            //0表示持有，则前一个状态可以为持有,或者前一个状态不持有，当前买入
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
        }

        return dp[length-1][1];
    }
}
