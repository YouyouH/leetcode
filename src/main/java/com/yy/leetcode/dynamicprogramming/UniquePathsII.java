package com.yy.leetcode.dynamicprogramming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsII {
    /**
     * dp[i][j] 表示到达（i，j）的途径有几种
     * 如果是障碍物则dp[i][j] 为0
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //第一行和第一列在遇到障碍之前是1，遇到之后都是0
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        int r =0;
        while ( r < row) {
            if (obstacleGrid[r][0] == 1) {
                break;
            }
            dp[r][0] = 1;
            r++;
        }

        int c = 0;
        while ( c < col) {
            if (obstacleGrid[0][c] == 1) {
                break;
            }
            dp[0][c] = 1;
            c++;
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
