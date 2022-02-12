//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 22 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-10 21:59:27
//数组中的第 k 大的数字

public class Xx4gT2{
    public static void main(String[] args) {
         Solution solution = new Xx4gT2().new Solution();
         solution.findKthLargest(new int[]{3,2,1,5,6,4},2);
         solution.findKthLargest(new int[]{2,1},1);
         solution.findKthLargest(new int[]{3,3,3,3},1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findKthLargest(int[] nums, int k) {
            //1,2,3,4,5,6   5
            //1,2,2,3,3,4,5,5,6  4
            //这题就是考排序
            // 方法一：快速排序，
            // 方法二：堆排序，

            //先用方法一做一遍，从小到大排序
            quickSort(nums, 0, nums.length - 1);
            return nums[nums.length-k];

        }

        private void quickSort(int[] nums, int lo, int hi) {
            if (hi <= lo) {
                return;
            }
            int j = partion(nums, lo, hi);
            quickSort(nums, lo, j - 1);
            quickSort(nums, j+1, hi);
        }

        private int partion(int[] nums, int lo, int hi) {
            int i = lo + 1;
            int j = hi;
            int pivot = nums[lo];

            while (true) {
                while (nums[i] <= pivot) {
                    i++;
                    if (i >= hi) break;
                }

                while (nums[j] > pivot) {
                    j--;
                    if (j <= lo) break;
                }

                if (i >= j) break;

                exch(nums, i, j);
            }

            exch(nums, lo, j);

            return j;
        }

        // exchange a[i] and a[j]
        private void exch(int[] a, int i, int j) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}