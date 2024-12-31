
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-30 17:47:16 
//拼接数组的最大分数

public class MaximumScoreOfSplicedArray{
    public static void main(String[] args) {
        Solution solution = new MaximumScoreOfSplicedArray().new Solution();
        System.out.println(solution.maximumsSplicedArray(new int[]{60, 60, 60}, new int[]{10, 90, 10}));
        System.out.println(solution.maximumsSplicedArray(new int[]{10, 90, 10}, new int[]{60, 60, 60}));
        System.out.println(solution.maximumsSplicedArray(new int[]{7,11,13}, new int[]{1,1,1}));
        System.out.println(solution.maximumsSplicedArray(new int[]{1}, new int[]{2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        /**
         * 题解：
         * https://leetcode.cn/problems/maximum-score-of-spliced-array/solutions/1626030/by-endlesscheng-fm8l/
         *  把两个数组的对应位置的差值重新组成一个新的数组，就这个新的数组的最大子数组和。最大子数组和即表示在这一个区间段内
         *  两个数组的差值最大，此时就可以替换这个区间。
         *
         *  FIXME: 上面分析不完全对，
         *  对于nums1数组，交换后的最大值是 sum1 + (nums2i-nums1i)
         *  推导：
         *      交换后的值是 sum1 - nums1i + nums2i， 把数组1拿走，把数组2拿进来
         *
         *  对于nums2数组，交换后最大值是 sum2 + (nums1i -nums2i)
         *
         *  两种情况都要求一遍
         *
         *
         */
//        System.out.println("------------nums1----------------------");
        //把两个数组每个下标对应的差值组成新的数组，对这个新的数组求最大子数组和
        int[] diff1 = new int[nums1.length];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff1[i] = nums2[i] - nums1[i];
        }
        //对diff数组求最大子数组和，求出来的最大子数组就是可以替换的部分
        int[] dp1 = new int[nums1.length];

        dp1[0] = Math.max(0, diff1[0]);

        int max1 = 0;
        for (int i = 1; i < nums1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1] + diff1[i], diff1[i]);
            max1 = Math.max(max1, dp1[i]);
//            System.out.println("i=" + i + " value=" + dp1[i] + " max1=" + max1);
        }

        int[] diff2 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            diff2[i] = nums1[i] - nums2[i];
        }

//System.out.println("------------nums2----------------------");
        //对diff数组求最大子数组和，求出来的最大子数组就是可以替换的部分
        int[] dp2 = new int[nums1.length];

        dp2[0] = Math.max(0, diff2[0]);

        int max2 = 0;
        for (int i = 1; i < nums1.length; i++) {
            dp2[i] = Math.max(dp2[i - 1] + diff2[i], diff2[i]);
            max2 = Math.max(max2, dp2[i]);
//            System.out.println("i=" + i + " value=" + dp2[i] + " max2=" + max2);
        }

        //max有可能正数有可能负数
        return Math.max(sum1 + max1, sum2 + max2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度都是 n 。 
//
// 你可以选择两个整数 left 和 right ，其中 0 <= left <= right < n ，接着 交换 两个子数组 nums1[left...
//right] 和 nums2[left...right] 。 
//
// 
// 例如，设 nums1 = [1,2,3,4,5] 和 nums2 = [11,12,13,14,15] ，整数选择 left = 1 和 right = 
//2，那么 nums1 会变为 [1,12,13,4,5] 而 nums2 会变为 [11,2,3,14,15] 。 
// 
//
// 你可以选择执行上述操作 一次 或不执行任何操作。 
//
// 数组的 分数 取 sum(nums1) 和 sum(nums2) 中的最大值，其中 sum(arr) 是数组 arr 中所有元素之和。 
//
// 返回 可能的最大分数 。 
//
// 子数组 是数组中连续的一个元素序列。arr[left...right] 表示子数组包含 nums 中下标 left 和 right 之间的元素（含 下标 
//left 和 right 对应元素）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [60,60,60], nums2 = [10,90,10]
//输出：210
//解释：选择 left = 1 和 right = 1 ，得到 nums1 = [60,90,60] 和 nums2 = [10,60,10] 。
//分数为 max(sum(nums1), sum(nums2)) = max(210, 80) = 210 。 
//
// 示例 2： 
//
// 
//输入：nums1 = [20,40,20,70,30], nums2 = [50,20,50,40,20]
//输出：220
//解释：选择 left = 3 和 right = 4 ，得到 nums1 = [20,40,20,40,20] 和 nums2 = [50,20,50,70
//,30] 。
//分数为 max(sum(nums1), sum(nums2)) = max(140, 220) = 220 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [7,11,13], nums2 = [1,1,1]
//输出：31
//解释：选择不交换任何子数组。
//分数为 max(sum(nums1), sum(nums2)) = max(31, 3) = 31 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 66 👎 0
