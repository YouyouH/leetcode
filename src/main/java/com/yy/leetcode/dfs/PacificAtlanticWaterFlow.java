package com.yy.leetcode.dfs;
/**
 * @author youyouhuang
 * @create 2020-04-25
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
 * “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：      输出坐标的顺序不重要     m 和 n 都小于150  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class PacificAtlanticWaterFlow {
    //从四周开始遍历
    //遍历多次
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int[][] matrix2 = new int[matrix.length][matrix[0].length];
        int[][] visited1 = new int[matrix.length][matrix[0].length];
        int[][] visited2 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //先从太平洋开始反向遍历
                if (i == 0 || j == 0) {
                    dfsPacific(matrix, i, j, matrix[i][j], matrix2, visited1);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //先从大西洋开始反向遍历
                if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                    dfsWest(matrix, i, j, matrix[i][j], matrix2, result, visited2);
                }
            }
        }
        return result;
    }

    private void dfsWest(int[][] matrix, int i, int j, int preValue, int[][] matrix2, List<List<Integer>> result, int[][] visited2) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] < preValue || visited2[i][j] != 0) {
            return;
        } else if (matrix2[i][j] == 1) {
            result.add(Arrays.asList(i, j));
        }

        visited2[i][j] = 1;
        dfsWest(matrix, i - 1, j, matrix[i][j], matrix2, result, visited2);
        dfsWest(matrix, i + 1, j, matrix[i][j], matrix2, result, visited2);
        dfsWest(matrix, i, j - 1, matrix[i][j], matrix2, result, visited2);
        dfsWest(matrix, i, j + 1, matrix[i][j], matrix2, result, visited2);
    }

    private void dfsPacific(int[][] matrix, int i, int j, int preValue, int[][] matrix2, int[][] visited1) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] < preValue || visited1[i][j] != 0) {
            return;
        } else {
            matrix2[i][j] = 1;
        }
        visited1[i][j] = 1;
        dfsPacific(matrix, i - 1, j, matrix[i][j], matrix2, visited1);
        dfsPacific(matrix, i + 1, j, matrix[i][j], matrix2, visited1);
        dfsPacific(matrix, i, j - 1, matrix[i][j], matrix2, visited1);
        dfsPacific(matrix, i, j + 1, matrix[i][j], matrix2, visited1);
    }
}
