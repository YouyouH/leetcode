package com.yy.leetcode.dfs;
/**
 * @author youyouhuang
 * @create 2020-05-01
 **/

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。
 * 如果不可能，返回 -1。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int oranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }
        int result = 0;
        for (int k = 0; k < oranges; k++) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == k + 3 - 1) {
                        dfs(grid, i, j, k + 3);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                   return -1;
                }
                result = Math.max(result,grid[i][j]);
            }
        }
        if(result == 0){
            return 0;
        }
        return result-2;

    }

    private void dfs(int[][] grid, int i, int j, int value) {
        if (i >= 0 && i < grid.length) {
            if (j - 1 >= 0) {
                if(grid[i][j - 1] == 1) {
                    grid[i][j - 1] = value;
                }
            }
            if (j + 1 < grid[0].length) {
                if(grid[i][j + 1] == 1) {
                    grid[i][j + 1] = value;
                }
            }
        }

        if (j < grid[0].length && j >= 0 ) {
            if (i - 1 >= 0) {
                if(grid[i - 1][j] == 1) {
                    grid[i - 1][j] = value;
                }
            }
            if (i + 1 < grid.length) {
                if(grid[i + 1][j] == 1) {
                    grid[i + 1][j] = value;
                }
            }
        }
    }
}
