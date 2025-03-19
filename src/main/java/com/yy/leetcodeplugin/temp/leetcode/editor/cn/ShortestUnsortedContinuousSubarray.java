
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-18 09:45:45 
//最短无序连续子数组

public class ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
         Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        /**
         * FIXME 看的答案
         * 1.从左往右遍历，当前数大于前面的最大值就不需要重排，否则就需要移动，最后停下就是需要重排序的右边界
         * 2.从右往左遍历，当前数小于后面的最小值就不需要重排，否则就需要移动，最后停下的时候就是需要重新排序的左边界
         */
        int l = 0;
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                l = i;
            }
        }
        //此时从l开始往前的数都需要重排

        int r = length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                r = i;
            }
        }
        //此时大于等于r的数字都需要重排
//        System.out.println("l=" + l + " r=" + r);
        //l和r之间的数字就是答案
        if (l <= r) {
            return 0;
        }
        return l - r + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1199 👎 0
