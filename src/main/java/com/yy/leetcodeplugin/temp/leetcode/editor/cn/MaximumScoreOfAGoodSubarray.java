
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-18 10:06:30 
//好子数组的最大分数

public class MaximumScoreOfAGoodSubarray{
    public static void main(String[] args) {
         Solution solution = new MaximumScoreOfAGoodSubarray().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumScore(int[] nums, int k) {
        /**
         * 类似接雨水，从中心往两边扩张。每次判断起点两边的值，例如l-1 和 r+1,然后往更大的一边扩张
         * FIXME: 代码看的答案
         */
        int l = k;
        int r = k;
        int res =  nums[k];
        int minH = nums[k];
        int length = nums.length;
        while (l >= 0 || r < length) {
            if (r == length-1 || (l > 0 && nums[l-1] >= nums[r+1])) {
                l--;
                if (l < 0) {
                    break;
                }
                minH = Math.min(minH, (nums[l]));
            } else {
                r++;
                if (r > length) {
                    break;
                }
                minH = Math.min(minH, (nums[r]));
            }
            res = Math.max(res, minH * (r - l + 1));

//            System.out.println("l=" + l + " r=" + r + " res=" + res + " minH=" + minH);
//            if (l == -1 && r == length) {
//                break;
//            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。 
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。 
//
// 请你返回 好 子数组的最大可能 分数 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 0 <= k < nums.length 
// 
//
// Related Topics 栈 数组 双指针 二分查找 单调栈 👍 164 👎 0
