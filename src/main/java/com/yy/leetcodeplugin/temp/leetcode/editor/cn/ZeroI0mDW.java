  //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：一个机器人每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// 
//
// 注意：本题与主站 64 题相同： https://leetcode-cn.com/problems/minimum-path-sum/ 
// Related Topics 数组 动态规划 矩阵 👍 23 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-07-17 20:55:30 
//最小路径之和

public class ZeroI0mDW{
    public static void main(String[] args) {
         Solution solution = new ZeroI0mDW().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];

        int value = 0;
        for (int i = 0; i < m; i++) {
            path[i][0] = grid[i][0] + value;
            value = path[i][0];
        }

        value = 0;
        for (int i = 0; i < n; i++) {
            path[0][i] = grid[0][i] + value;
            value = path[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
            }
        }

        return path[m - 1][n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}