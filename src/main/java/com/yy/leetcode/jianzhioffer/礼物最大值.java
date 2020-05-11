package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-05-11
 **/

import java.util.ArrayList;
import java.util.List;

/**
 *在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class 礼物最大值 {
    /**
     * 动态规划
     * dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     *
     */
    public int maxValue(int[][] grid) {
        int result = 0;
        if(grid.length == 1){
            for (int i : grid[0]) {
                result += i;
            }
            return result;
        }else if(grid[0].length == 1){
            for (int i = 0; i < grid.length; i++) {
                result += grid[i][0];
            }
            return result;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        dp[0][0] = grid[0][0];
        dp[1][0] = grid[0][0] + grid[1][0];
        dp[0][1] = grid[0][0] + grid[0][1];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];

    }
}
