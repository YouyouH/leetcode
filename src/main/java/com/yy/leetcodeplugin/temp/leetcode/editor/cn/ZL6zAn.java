//给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1
//,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0
//,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出: 6
//解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// 
//输入: grid = [[0,0,0,0,0,0,0,0]]
//输出: 0 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1 
// 
//
// 
//
// 注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 20 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-12 23:44:24
//岛屿的最大面积

public class ZL6zAn{
    public static void main(String[] args) {
         Solution solution = new ZL6zAn().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            //遍历这个grid，，遇到一个1就以这个1为起点开始深度搜索，并把搜索到的地方全部改为0，确保不会重复搜索
            for (int k = 0; k < grid.length; k++) {
                for (int l = 0; l < grid[0].length; l++) {
                    if (grid[k][l] == 1) {
                        max = Math.max(max, traverseGrid(grid, k, l));
                    }
                }
            }
            return max;
        }

        private int traverseGrid(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 0 == grid[i][j]) {
                return 0;
            }
            //把访问过的都置0，避免后面重复访问
            grid[i][j] = 0;
            return 1 + traverseGrid(grid, i - 1, j)
                    + traverseGrid(grid, i + 1, j)
                    + traverseGrid(grid, i, j - 1)
                    + traverseGrid(grid, i, j + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}