package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-08
 **/

/**
 * <p>给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>示例 1:
 * <p>输入: [2,4,1], k = 2
 * <p>输出: 2 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * <p>来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有.商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class BestTimetoBuyandSellStockIV {

    //dynamic programming
    public int maxProfit(int k, int[] prices) {
        if(null == prices || prices.length == 0 || k < 0){
            return 0;
        }

        //状态：前i天，k笔交易，持有或不持有
        //dp[i][j][k] 最大利润
        //选择：买入，卖出，什么也不做
        int days = prices.length;

        //due to put of memory error when dp table is too large
        if(k>days/2){
            return new BestTimetoBuyandSellStockII().maxProfit(prices);
        }

        int[][][] dp = new int[days + 1][2][k + 1];
        for (int i = 0; i <= days; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l <= k; l++) {
                    if (i == 1) {
                        dp[1][1][l] = -prices[0];
                    }
                }
            }
        }

        for (int i = 2; i <= days; i++) {
            for (int l = 1; l <= k; l++) {
                //为什么是dp[i - 1][1][l] 而不是dp[i - 1][1][l-1]???????
                dp[i][0][l] = Math.max(dp[i - 1][0][l], dp[i - 1][1][l] + prices[i - 1]);
                dp[i][1][l] = Math.max(dp[i - 1][1][l], dp[i - 1][0][l - 1] - prices[i - 1]);
            }
        }
        return dp[days][0][k];
    }

    //backtracking +dp table
    public int maxProfit1(int k, int[] prices) {
        int days = prices.length;

        return profit(prices, 0, days,1,k);
    }

    private int profit(int[] prices, int sum, int days, int day, int k) {
        int max = 0;
        if(k<1){
            if(day == 1){
                return -prices[0];
            }else{
                return 0;
            }
        }
        if(day == 1) {
            return -prices[0];
        }
        //t天数

        //买或者卖或者不动
        max = Math.max(Math.max(
                sum + profit(prices, sum, days,day+1, k),//不动
                sum + prices[day-1] + profit(prices, sum + prices[day-1], days,day+1, k - 1)),//卖
                sum - prices[day-1] + profit(prices, sum - prices[day-1], days,day+1,k - 1));//买

        return max;
    }
}
