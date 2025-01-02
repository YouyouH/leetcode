
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-02 16:30:01 
//矩阵的最大非负积

public class MaximumNonNegativeProductInAMatrix{
    public static void main(String[] args) {
         Solution solution = new MaximumNonNegativeProductInAMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int MOD = 1_000_000_000 + 7;
    public int maxProductPath(int[][] grid) {
        /**
         * 动态规划：
         *  对于每个格子求最大值和最小值。
         *  为什么求最小值？
         *      两个负数相乘结果为正，负的越小相乘之后结果越大
         */

        int m = grid.length;
        int n = grid[0].length;

        long[][] dpmax = new long[m][n];
        long[][] dpmin = new long[m][n];

        dpmax[0][0] = grid[0][0];
        dpmin[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dpmax[i][0] = dpmax[i - 1][0] * grid[i][0];
            dpmin[i][0] = dpmax[i][0];
        }

        for (int i = 1; i < n; i++) {
            dpmax[0][i] = dpmax[0][i - 1] * grid[0][i];
            dpmin[0][i] = dpmax[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpmax[i][j] = Math.max(
                        grid[i][j] * Math.max(dpmax[i][j - 1], dpmax[i - 1][j]),
                        grid[i][j] * Math.min(dpmin[i][j - 1], dpmin[i - 1][j]));
                dpmin[i][j] = Math.min(
                        grid[i][j] * Math.max(dpmax[i][j - 1], dpmax[i - 1][j]),
                        grid[i][j] * Math.min(dpmin[i][j - 1], dpmin[i - 1][j]));
                System.out.println(dpmax[i][j]);
            }
        }

        return dpmax[m - 1][n - 1]% MOD >= 0 ? (int) (dpmax[m - 1][n - 1] % MOD) : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。 
//
// 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整
//数的乘积。 
//
// 返回 最大非负积 对 10⁹ + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。 
//
// 注意，取余是在得到最大积之后执行的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
//输出：-1
//解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1 。 
//
// 示例 2： 
// 
// 
//输入：grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
//输出：8
//解释：最大非负积对应的路径如图所示 (1 * 1 * -2 * -4 * 1 = 8)
// 
//
// 示例 3： 
// 
// 
//输入：grid = [[1,3],[0,-4]]
//输出：0
//解释：最大非负积对应的路径如图所示 (1 * 0 * -4 = 0)
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 15 
// -4 <= grid[i][j] <= 4 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 70 👎 0
