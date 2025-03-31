
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-28 17:22:06 
//有序矩阵中第 K 小的元素

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
         Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}},9);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /**
         * 直接最小堆？不行。
         * FIXME 看的答案
         * 方法一：利用每一行都是递增的排序，将每一行的第一个数放入最小堆中，每取一个数就将他后面的数入堆
         * 方法二：二分法。 相对于方法一，二分法还利用到了按列递增的特点，复杂度更优。具体实现看答案
         */
        //保存int数组，第一个数是值，第二个数是第几行,第三个数是第几列（找下一个数的时候需要知道是第几行 第几列）。
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));//小根堆，堆顶是最小元素
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int res = 0;

        //先把每一行的第一个放入小根堆
        for (int i = 0; i < row; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }
        while (count < k) {
            int[] min = queue.poll();
//            System.out.println("min=" + min[0]);
            res = min[0];
            count++;
            int rowNum = min[1];
            int colNum = min[2];
            if (colNum + 1 < col) {
                queue.offer(new int[]{matrix[rowNum][colNum + 1], rowNum, colNum + 1});
//                System.out.println("offer=" + matrix[rowNum][colNum + 1]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 请注意，它是 排序后 的第 k 小元素，而不是第 
//k 个 不同 的元素。 
//
// 你必须找到一个内存复杂度优于 O(n²) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n² 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题? 
// 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。 
// 
//
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 👍 1111 👎 0
