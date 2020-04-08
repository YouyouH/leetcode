package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-06
 **/

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 *
 * </p>
 **/
public class MinimumPathSum {
    /**
     * dp[i][j] i*j 的网络的最小路径
     */
    public int minPathSum(int[][] grid) {
        if(grid == null ||grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int col = grid.length;
        int row = grid[0].length;
        int[][] dp = new int[col][row];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[col-1][row-1];
    }
}
