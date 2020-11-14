package com.yy.leetcode.dynamicprogramming.Decision_Making;

public class gupiaodezuidalirunlcof {

    public int maxProfit(int[] prices) {
        //dp[i][j] i表示当前值，j表示选择。0/1:持有/不持有
        if(null == prices || prices.length < 2){
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }

        return dp[prices.length-1][0];
    }
}
