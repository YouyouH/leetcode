
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-03 16:56:04 
//矩阵中和能被 K 整除的路径

public class PathsInMatrixWhoseSumIsDivisibleByK{
    public static void main(String[] args) {
         Solution solution = new PathsInMatrixWhoseSumIsDivisibleByK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = 1_000_000_000 + 7;
        public int numberOfPaths(int[][] grid, int k) {
            /**
             * 看的题解。动态规划，dp数组要再加一个维度（路径和对模k的结果）
             * dp[i][j][v] 表示从起点到ij位置的路径和对模k的结果为v的路径数目
             *      dp[i][j][(v+grid[i][j])mod k] = dp[i][j-1][v] + dp[i-1][j][v];
             *      怎么理解这个表达式:
             *          到达上方格子时，模k值为v的路径数量是dp[i][j-1][v]
             *          到达左边格子时，模k值为v的路径数量是dp[i-1][j][v]
             *          那么从这两种情况到达当前格子时：
             *              原来时模k结果时v,现在就是 (v+grid[i][j])mod k
             */

            int m = grid.length;
            int n = grid[0].length;

            //把矩阵扩充方便处理边界条件.此时dp小标不等于当前格子的下标。例如dp[1][1]可以理解为第一行第一列的格子，值是grid[0][0]
            int[][][] dp = new int[m + 1][n + 1][k];
            /**
             * 怎么初始化？
             *    从起点走到起点，路径和的模k等于grid[1][1]%k 的路径只有一条，即  dp[1][1][grid[1][1]%k] = 1。
             *    其他情况都是0，即数组的默认值，不用再设置。
             *
             *    要让 dp[1][1][grid[1][1]%k] = 1，可以设置 dp[1][0][0] =1 或者（dp[0][1][0] =1 ）
             *
             */

            dp[1][0][0] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < k; l++) {
                        dp[i + 1][j + 1][(l + grid[i][j]) % k] = (dp[i + 1][j][l] + dp[i][j + 1][l]) % MOD;
                    }

                }
            }
            return dp[m][n][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个下标从 0 开始的 m x n 整数矩阵 grid 和一个整数 k 。你从起点 (0, 0) 出发，每一步只能往 下 或者往 右 ，你想要到达终点 
//(m - 1, n - 1) 。 
//
// 请你返回路径和能被 k 整除的路径数目，由于答案可能很大，返回答案对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
//输出：2
//解释：有两条路径满足路径上元素的和能被 k 整除。
//第一条路径为上图中用红色标注的路径，和为 5 + 2 + 4 + 5 + 2 = 18 ，能被 3 整除。
//第二条路径为上图中用蓝色标注的路径，和为 5 + 3 + 0 + 5 + 2 = 15 ，能被 3 整除。
// 
//
// 示例 2： 
// 输入：grid = [[0,0]], k = 5
//输出：1
//解释：红色标注的路径和为 0 + 0 = 0 ，能被 5 整除。
// 
//
// 示例 3： 
// 输入：grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
//输出：10
//解释：每个数字都能被 1 整除，所以每一条路径的和都能被 k 整除。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 5 * 10⁴ 
// 1 <= m * n <= 5 * 10⁴ 
// 0 <= grid[i][j] <= 100 
// 1 <= k <= 50 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 57 👎 0
