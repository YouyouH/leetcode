
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-06 13:08:39 
//检查是否有合法括号字符串路径

import java.util.Arrays;

public class CheckIfThereIsAValidParenthesesStringPath{
    public static void main(String[] args) {
         Solution solution = new CheckIfThereIsAValidParenthesesStringPath().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution2 {

            public boolean hasValidPath(char[][] grid) {
                /**
                 * 深度遍历DFS，加备忘录
                 * 终止条件
                 *      序列是否合法。（用+1-1判断）
                 */
                boolean[][][] memo = new boolean[grid.length][grid[0].length][2];

                return dfs(grid, 0, 0, getValue(grid[0][0]), memo);

            }

            private boolean dfs(char[][] grid, int i, int j, int sum, boolean[][][] memo) {
                if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                    return false;
                }
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    memo[i][j][0] = true;
                    memo[i][j][1] = (0 == sum);
                    return 0 == sum;
                }

                if (memo[i][j][0]) {
//                    System.out.println("i=" + i + " j=" + j + " value=" + memo[i][j][1]);
                    return memo[i][j][1];
                }

                if (sum < 0) {
                    memo[i][j][0] = true;
                    memo[i][j][1] = false;
                    return false;
                }

                boolean right = false;
                boolean down = false;
                //向右
                if (j + 1 < grid[0].length) {
                    right = dfs(grid, i, j + 1, sum + getValue(grid[i][j + 1]), memo);
                }

                //向下
                if (i + 1 < grid.length) {
                    down = dfs(grid, i + 1, j, sum + getValue(grid[i+1][j]), memo);
                }
                boolean ans = right || down;
                memo[i][j][0] = true;
                memo[i][j][1] = ans;
//                System.out.println("i=" + i + " j=" + j + " value=" + memo[i][j][1]);
                return ans;
            }

            private int getValue(char ch) {
                if (ch == '(') {
                    return 1;
                }
                return -1;
            }
        }

    class Solution {

        public boolean hasValidPath(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false; // 剪枝

            /**
             * 深度遍历DFS，加备忘录
             * 终止条件
             *      序列是否合法。（用+1-1判断）
             *
             * FIXME: 上面备忘录的做法是错误的.备忘录需要状态完全相同时才能用,这一题除了坐标还有字符串的和三个维度.所以需要保证这三个一样才能用备忘录.
             */
            boolean[][][] memo = new boolean[grid.length][grid[0].length][grid.length+grid[0].length];

            return dfs(grid, 0, 0, getValue(grid[0][0]), memo);

        }

        private boolean dfs(char[][] grid, int i, int j, int sum, boolean[][][] memo) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return false;
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return 0 == sum;
            }



            if (sum < 0) {
                return false;
            }


            /**
             * FIXME 如何使用备忘录?
             *  1.访问过了就标记.
             *  2.这道题如果成功了就会立即返回,所以如果发现重复的说明前面走到这里的时候,最后没有成功.那么现在同样的状态再走到这里依然不会成功.
             */
            if (memo[i][j][sum]) {
                return false;
            }

            memo[i][j][sum] = true;

            boolean right = false;
            boolean down = false;
            //向右
            if (j + 1 < grid[0].length) {
                right = dfs(grid, i, j + 1, sum + getValue(grid[i][j + 1]), memo);
            }

            //向下
            if (i + 1 < grid.length) {
                down = dfs(grid, i + 1, j, sum + getValue(grid[i+1][j]), memo);
            }
            return right || down;
        }

        private int getValue(char ch) {
            if (ch == '(') {
                return 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

  //一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。 
//
// 
// 字符串是 () 。 
// 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。 
// 字符串可以表示为 (A) ，其中 A 是合法括号序列。 
// 
//
// 给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径： 
//
// 
// 路径开始于左上角格子 (0, 0) 。 
// 路径结束于右下角格子 (m - 1, n - 1) 。 
// 路径每次只会向 下 或者向 右 移动。 
// 路径经过的格子组成的括号字符串是 合法 的。 
// 
//
// 如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
//输出：true
//解释：上图展示了两条路径，它们都是合法括号字符串路径。
//第一条路径得到的合法字符串是 "()(())" 。
//第二条路径得到的合法字符串是 "((()))" 。
//注意可能有其他的合法括号字符串路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[")",")"],["(","("]]
//输出：false
//解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] 要么是 '(' ，要么是 ')' 。 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 49 👎 0
