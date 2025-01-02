
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-31 22:40:56 
//不同路径 II

public class UniquePathsIi{
    public static void main(String[] args) {
         Solution solution = new UniquePathsIi().new Solution();
        solution.uniquePathsWithObstacles(new int[][]{{1, 0}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 二维动态规划，遇到障碍置为0
         *
         *  FIXME: 学习滚动数组的概念，压缩数组从二维变一维
         */
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        boolean block = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            dp[i][0] = 1;
            if (obstacleGrid[i][0] == 1 || block) {
                dp[i][0] = 0;
                block = true;
            }
        }
        block = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            dp[0][i] = 1;
            if (obstacleGrid[0][i] == 1 || block) {
                dp[0][i] = 0;
                block = true;
            }
        }


        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            /**
             * 二维动态规划，遇到障碍置为0
             *
             *  FIXME: 学习滚动数组的概念，压缩数组从二维变一维
             *   滚动数组就是用一个数组表示每一行，从左往右开始每一列的值。在计算的时候就是一行一行的去更新这个数组。
             *   为什么可以这样表示？
             *      因为当前格子的值和上方格子的值以及左边格子的值有关。
             *          dp[j] = dp[j] + dp[j-1]
             *          例如第三行第三列的值 = 第二行第三列的值 + 第三行第二列的值。在滚动更新的时候，
             *          如何理解等式右边的dp[j]：
             *              滚动到第三行第二列dp[j-1]之后，dp[j] 的值还没有更新，此时还表示的是第二行第三列的值。
             *          此外当左边格子是障碍物时，左边格子就是0，当前格子的值就不用更新，仍然等于上一行的当前列，也就是dp[j]。更新也可以，就是 0+dp[j]
             *
             */
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            /**
             * 从上面的solution可以看出，当前格子的值只和上方格子以及左边格子有关。所以和一维数组类似（用变量保存前面的值），
             * 二维数组就用一维数组表示。
             */

            /**
             * n是列数，所以在这里压缩的是行的信息。
             */
            int[] dp = new int[n];

            //数组的默认值是0，dp[0]表示将第一列初始化
            dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //dp[j] 表示当前列上一行的值，即上方的格子
                    //dp[j-1] 表示上一列的值，即左边的格子
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                        continue;//当前格子是障碍置为0 然后继续判断下一列
                    }
                    //从第二列开始（第一列已经在外面初始化过了）并且左边格子不是障碍物
                    //obstacleGrid[i][j-1] ==0 意思是 左边如果是障碍物，那么当前格子就等于上面格子的值，不需要更新。有没有这个判断都对
                    if (j - 1 >= 0 && obstacleGrid[i][j-1] ==0 ) {
//                    if (j - 1 >= 0 ) {
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            }
            return dp[n - 1];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][
//n - 1]）。机器人每次只能向下或者向右移动一步。 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。 
//
// 返回机器人能够到达右下角的不同路径数量。 
//
// 测试用例保证答案小于等于 2 * 10⁹。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1328 👎 0
