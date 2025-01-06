
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-05 17:43:53 
//矩阵中的最长递增路径

public class LongestIncreasingPathInAMatrix{
    public static void main(String[] args) {
         Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        /**
         * DFS + 备忘录
         */
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("出发 i=" + i + " j=" + j);
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }


    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        //不能超出边界
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int max = 1;//当前格子长度就是1，所以不初始化为0

        /**
         * 注意这里求的是最大值，不是所有可能情况，所以只比较四个方向上的最大值
         */
        //向上
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(1 + dfs(matrix, i - 1, j, memo), max);
        }

        //向右
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(1 + dfs(matrix, i, j + 1, memo), max);
        }
        //向左
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(1 + dfs(matrix, i, j - 1, memo), max);
        }
        //向下
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(1 + dfs(matrix, i + 1, j, memo), max);
        }
        return memo[i][j] = max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
// 
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 879 👎 0
