package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-12
 **/

/**
 *<p>在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *<p> 示例:
 *<p> 输入:
 *<p> 1 0 1 0 0
 *<p> 1 0 1 1 1
 *<p> 1 1 1 1 1
 *<p> 1 0 0 1 0
 *<p> 输出: 4
 *<p> 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximal-square
 *<p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class MaximalSquare {
    //动态规划
    //状态转移方程为:
    //dp[i][j] = min(dp[i][j-1],dp[i-1][j-1],dp[i-1][j])+1
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int maxLength = 0;


        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
