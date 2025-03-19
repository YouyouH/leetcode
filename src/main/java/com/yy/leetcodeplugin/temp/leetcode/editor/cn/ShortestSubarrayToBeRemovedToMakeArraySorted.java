
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-17 22:17:15 
//删除最短的子数组使剩余数组有序

public class ShortestSubarrayToBeRemovedToMakeArraySorted{
    public static void main(String[] args) {
         Solution solution = new ShortestSubarrayToBeRemovedToMakeArraySorted().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        /**
         * FIXME：看的答案
         * 1.先从最后面开始找出最长的递增数组
         *      例如 [1,2,3,10,4,2,3,5]， 从后面开始找就是 2,3,5。
         * 2.再从头开始检查，首先是递增的数组，再看递增的数组是否比尾部递增数组的最小值大。如果小于最小值，那么可以拼起来。如果大于最小值，
         * 那么右边的指针就要右移
         *      例如开始找到1，小于2，符合条件。接着找到2，小于等于2符合条件，再找到3，大于2，此时就需要移动2，再次判断，此时3等于3符合条件。
         *      再找到10，此时右指针需要一直移动到末尾。
         *
         *      每次移动都记录两个指针中间有几个数，最小值就是答案
         *
         * 也可以反过来，先确定前面的最长递增数组，再慢慢左移。
         */
        int length = arr.length;
        if (length == 1) {
            return 0;
        }

        int r = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                r = i;
            }else{
                break;
            }
        }
        //此时r指向尾部最长的递增子序列
//        System.out.println("r=" + r);
        if (r == 0) {
            return 0;
        }

        int res = r;//FIXME: 把r前面的全删了是最大的情况,不能直接初始化为MAX
//        int res = Integer.MAX_VALUE;
        //再从头开始判断能不能跟尾部的接上，接不上就往后移动r.同时往后移动r直到能接上

        for (int i = 0; i < length;i++ ) {
//            System.out.println("l=" + i + " r=" + r + " res=" + res);
            while (r < length && arr[i] > arr[r]) {
                r++;
            }
            res = Math.min(res, r - i - 1);
            if (i + 1 < length && arr[i] > arr[i + 1]) {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。 
//
// 一个子数组指的是原数组中连续的一个子序列。 
//
// 请你返回满足题目要求的最短子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,10,4,2,3,5]
//输出：3
//解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
//另一个正确的解为删除子数组 [3,10,4] 。 
//
// 示例 2： 
//
// 
//输入：arr = [5,4,3,2,1]
//输出：4
//解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,2,3]
//输出：0
//解释：数组已经是非递减的了，我们不需要删除任何元素。
// 
//
// 示例 4： 
//
// 
//输入：arr = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 0 <= arr[i] <= 10^9 
// 
//
// Related Topics 栈 数组 双指针 二分查找 单调栈 👍 269 👎 0
