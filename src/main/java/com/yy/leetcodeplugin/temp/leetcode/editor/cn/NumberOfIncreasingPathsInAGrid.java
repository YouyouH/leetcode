
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-05 18:08:54 
//网格图中递增路径的数目

public class NumberOfIncreasingPathsInAGrid{
    public static void main(String[] args) {
         Solution solution = new NumberOfIncreasingPathsInAGrid().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int MOD = 1_000_000_000 + 7;
    public int countPaths(int[][] grid) {
        /**
         * 看得答案：
         *      方法一：DFS
         *      方法二：动态规划 + 备忘录
         */

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(grid, i, j,dp)) % MOD;
            }
        }
        return ans;

    }

        private int dfs(int[][] grid, int i, int j, int[][] dp) {
            //i j 超过边界了
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return 0;
            }

            if (dp[i][j] != 0) {
                return dp[i][j];
            }

            int res = 1;//当前格子是1，即哪里都不去也是1条路径
            if (i - 1 >= 0 && grid[i - 1][j] > grid[i][j]) {
                res = (res +  dfs(grid, i - 1, j, dp))% MOD;//向上
            }

            if (j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]) {
                res = (res +  dfs(grid, i, j + 1, dp))% MOD;//向右
            }
            if (i + 1 < grid.length && grid[i + 1][j] > grid[i][j]) {
                res= (res +  dfs(grid, i + 1, j, dp))% MOD;//向下
            }

            if (j-1 >=0 && grid[i][j - 1] > grid[i][j]) {
                res= (res +  dfs(grid, i, j - 1, dp))% MOD;//向左
            }
            return dp[i][j] = res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。 
//
// 请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。由于答案可能会很大，请将结果对 10⁹ + 7 取余 后返
//回。 
//
// 如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,1],[3,4]]
//输出：8
//解释：严格递增路径包括：
//- 长度为 1 的路径：[1]，[1]，[3]，[4] 。
//- 长度为 2 的路径：[1 -> 3]，[1 -> 4]，[3 -> 4] 。
//- 长度为 3 的路径：[1 -> 3 -> 4] 。
//路径数目为 4 + 3 + 1 = 8 。
// 
//
// 示例 2： 
//
// 输入：grid = [[1],[2]]
//输出：3
//解释：严格递增路径包括：
//- 长度为 1 的路径：[1]，[2] 。
//- 长度为 2 的路径：[1 -> 2] 。
//路径数目为 2 + 1 = 3 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 62 👎 0
