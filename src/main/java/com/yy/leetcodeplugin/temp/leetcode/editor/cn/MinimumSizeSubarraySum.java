
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-09 21:32:33 
//长度最小的子数组

public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
         Solution solution = new MinimumSizeSubarraySum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /**
         * 滑动窗口
         *      扩张到大于等于target然后再开始缩小直到小于target
         */
        int l = 0; int r = 0;
        int length = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        //FIXME: 下面这段逻辑是看答案的，比自己写的简洁。
        // 先扩张，如果满足条件了就收缩，直到不满足条件
        while (r < length) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                if (res == 1) {//最小值肯定是1，否则就不存在
                    return 1;
                }
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2391 👎 0
