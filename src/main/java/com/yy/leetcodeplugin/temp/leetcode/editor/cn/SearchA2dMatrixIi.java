
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-31 22:24:01 
//搜索二维矩阵 II

public class SearchA2dMatrixIi{
    public static void main(String[] args) {
         Solution solution = new SearchA2dMatrixIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 二分法。对于每一个target,可以把矩阵分为左上部分和右下部分。
         * 方法二是利用最小堆排序，但是这样没有利用到每一列的递增关系
         */
        int row = matrix.length;
        int col = matrix[0].length;

        //左下角开始
        int x = row - 1;//最后一行
        int y = 0;//第一列

        while (x >= 0 && y < col) {
//            System.out.println("x=" + x + " y=" + y);
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 1632 👎 0
