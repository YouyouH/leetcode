
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-03 10:27:54 
//矩阵区域和

public class MatrixBlockSum{
    public static void main(String[] args) {
         Solution solution = new MatrixBlockSum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        /**
         * 二维前缀和
         */
        int row = mat.length;
        int col = mat[0].length;
        int[][] sum = new int[row + 1][col + 1];//长度加一方便处理
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //                                                减去重复计算的
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + mat[i][j];
                //sum[1][2] = sum[1][1] + sum[0][2] - sum[0][1] + mat[0][1]
             }
        }

        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                //这些坐标都+1了,因为sum +1了
                int m = Math.max(0, i - k) + 1;//左上角横坐标
                int n = Math.max(0, j - k) + 1;//左上角纵坐标

                int q = Math.min(row - 1, i + k) + 1;//右下角横坐标
                int r = Math.min(col - 1, j + k) + 1;//右下角纵坐标
//                System.out.println(m + n + q + r);

                ans[i][j] = sum[q][r] - sum[q][n - 1] - sum[m - 1][r] + sum[m - 1][n - 1];
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 
//mat[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 211 👎 0
