package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-05-23
 **/

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class jiqirendeyundongfanwei {

    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        dfs(0, 0, map, k);
        int result = 0;
        for (int[] ints : map) {
            for (int i : ints) {
                if (i == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, int[][] map, int k) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return;
        }

        if (map[row][col] == 0 ) {
            if(qualify(row, col, k)) {
                map[row][col] = 1;
            }else{
                return;
            }
        }else{
            return;
        }
        dfs(row + 1, col, map, k);
        dfs(row - 1, col, map, k);
        dfs(row, col + 1, map, k);
        dfs(row, col - 1, map, k);
    }

    private boolean qualify(int row, int col, int k) {
        return (sum(row) + sum(col)) <= k;
    }

    private int sum(int row) {
        int result = 0;
        while (row != 0) {
            result += row % 10;
            row = row / 10;
        }
        return result;
    }

}
