package com.yy.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangyou
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        //先置为magic，遇到0或者magic跳过
        Integer magic = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (0 == matrix[i][j]) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (magic != matrix[i][k] && 0 != matrix[i][k]) {
                            matrix[i][k] = magic;
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if (0 != matrix[k][j] && magic != matrix[k][j]) {
                            matrix[k][j] = magic;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(magic == matrix[i][j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
