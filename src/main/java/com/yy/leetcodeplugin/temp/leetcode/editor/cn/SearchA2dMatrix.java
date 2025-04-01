
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-31 22:21:26 
//搜索二维矩阵

public class SearchA2dMatrix{
    public static void main(String[] args) {
         Solution solution = new SearchA2dMatrix().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 二分法，先找行，再找列
         */
        int row = matrix.length;
        int col = matrix[0].length;

        int up = 0;
        int down = row-1;
        int rowNum = -1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
//            System.out.println("up=" + up + " down=" + down + " mid=" + mid);
            if (target <= matrix[mid][col - 1] && target >= matrix[mid][0]) {
                rowNum = mid;
                break;
            } else if (matrix[mid][col - 1] < target) {//检查每一行的最后一个数判断目标在数组的上半部分还是下半部分
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }
        if (rowNum == -1) {
            return false;
        }
        System.out.println(rowNum);
        //此时找到在第几行了，接下来找列
        int l = 0;
        int r = col - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(matrix[rowNum][mid] == target){
                return true;
            }else if (matrix[rowNum][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
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
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 1038 👎 0
