
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-12 17:26:35 
//乘积小于 K 的子数组

public class SubarrayProductLessThanK{
    public static void main(String[] args) {
         Solution solution = new SubarrayProductLessThanK().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
         * 滑动窗口。先扩张，然后统计，再收缩，再次扩张，继续统计
         *  FIXME: 收缩之后也要再统计。收缩之后是新的子串
         */
        int l = 0;
        int sum = 1;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {
            sum *= nums[r];
            //开始收缩
            while (l <= r && sum >= k) {
                sum /= nums[l];
                l++;
            }
            count += r - l + 1;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 844 👎 0
