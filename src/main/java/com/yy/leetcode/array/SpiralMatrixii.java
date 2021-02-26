package com.yy.leetcode.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixii {

    public int[][] generateMatrix(int n) {
        //使用方向向量
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][] result = new int[n][n];

        boolean[][] visited = new boolean[n][n];

        int row = 0;
        int col = 0;

        int directionsIndex = 0;

        for (int i = 1; i <= n*n; i++) {
            result[row][col] = i;

            visited[row][col] = true;

            int nextRow = row + directions[directionsIndex][0];
            int nextCol = col + directions[directionsIndex][1];

            //判断 下一个点 是否超出边界 或者遇到重复点 超出就转向
            if (nextRow >= n || nextRow < 0 || nextCol >= n || nextCol < 0 || visited[nextRow][nextCol]) {
                directionsIndex = (directionsIndex + 1) % 4;
            }
            row = row + directions[directionsIndex][0];
            col = col + directions[directionsIndex][1];
        }

        return result;
    }
}
