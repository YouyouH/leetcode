package com.yy.leetcode.dfs;

/**
 * @author youyouhuang
 * @create 2020-03-24
 * @desc https://leetcode.com/problems/number-of-islands/
 **/

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j) > 0) {
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || '0' == grid[i][j]) {
            return 0;
        }
        //找到第一个岛上的点，接下来递归找出所有的点
        grid[i][j] = '0';
        return 1 +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1) +
                dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j);
    }
}
