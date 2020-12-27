package com.yy.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class spiralOrder {

    /**
     * 方法二：
     * 用四个方向向量决定怎么遍历数组
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        //从左往右，从上往下，从右往左，从下往上
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = matrix.length * matrix[0].length;
        int row = 0;
        int column = 0;
        List<Integer> res = new ArrayList<>();
        int directionIndex = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        while (count-- > 0) {
            int cur = matrix[row][column];
            visited[row][column] = 1;
            res.add(cur);
            //判断往哪走
            int nextRow = row + directions[directionIndex][0];
            int nextCol = column + directions[directionIndex][1];
            //如果超出边界了就转向 || 回到了原点
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length || visited[nextRow][nextCol] == 1) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];

        }
        return res;

    }


    /**
     * 方法一：直接遍历
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }
}

