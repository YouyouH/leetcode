package com.yy.leetcode.dfs;

/**
 * @author youyouhuang
 * @create 2020-03-24
 * @desc https://leetcode-cn.com/problems/max-area-of-island/
 * <p>
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 **/

public class MaxAreaofIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || 0 == grid[i][j]) {
            return 0;
        }
        grid[i][j] = 0;

        return 1 +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1) +
                dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j);
    }

}
