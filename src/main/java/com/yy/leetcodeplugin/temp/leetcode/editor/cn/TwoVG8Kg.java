  //给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
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
// 1 <= nums[i] <= 10⁵ 
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
// 
//
// 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/ 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 30 👎 0

  package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-01-12 16:52:51 
//和大于等于 target 的最短子数组

public class TwoVG8Kg{
    public static void main(String[] args) {
         Solution solution = new TwoVG8Kg().new Solution();
        solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口，移动右指针，判断子数组大小，如果大于target测记录数组长度
        //比较数组长度的最小值，如果大于target,再移动左指针，直到遇到右指针或者子数组和小于target
        //继续移动右指针
        int res = Integer.MAX_VALUE;

        int max = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            max += nums[right];
            if (max >= target) {
                res = Math.min(res, right - left + 1);
            }
            while (max >= target && left <= max) {
                max -= nums[left];
                //left -1 之后可能仍然大于target，所以子数组长度变小了，也要计算一下
                res = Math.min(res, right - left + 1);
                left++;

            }
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}