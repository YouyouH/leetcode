
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-30 17:24:24 
//环形子数组的最大和

public class MaximumSumCircularSubarray{
    public static void main(String[] args) {
         Solution solution = new MaximumSumCircularSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /**
         * 题解：https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/2351107/mei-you-si-lu-yi-zhang-tu-miao-dong-pyth-ilqh/
         *    对于子数组不跨过队尾的情况： 正常求子数组最大可能和
         *    对于子数组跨过队尾的情况：先求子数组最小可能和，用数组和减去最小可能和就是跨过边界的最大可能和
         *
         *    特殊情况：
         *    最小可能和的子数组就是整个数组。此时直接返回最大可能和。为什么？画图分析
         */

        //正常求最大子数组和
        int[] dpmax = new int[nums.length];
        dpmax[0] = nums[0];
        int max = dpmax[0];//FIXME: 非空子数组最大和,所以不能再用0作为默认值，因为必须有值
        for (int i = 1; i < nums.length; i++) {
            dpmax[i] = Math.max(dpmax[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dpmax[i]);
        }

        int[] dpmin = new int[nums.length];
        dpmin[0] = nums[0];
        int min = dpmin[0];
        for (int i = 1; i < nums.length; i++) {
            dpmin[i] = Math.min(dpmin[i - 1] + nums[i], nums[i]);
            min = Math.min(min, dpmin[i]);
        }


        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        System.out.println("max=" + max);
        System.out.println("min=" + min);
        System.out.println("sum=" + sum);

        //特殊情况：最小可能和的子数组就是整个数组
        if (min == sum) {
            return max;
        }

        //此时max 和 min 都求出来了
        return Math.max(max, sum - min);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
//
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 770 👎 0
