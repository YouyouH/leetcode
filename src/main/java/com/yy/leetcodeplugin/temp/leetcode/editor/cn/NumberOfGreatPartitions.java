
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-16 16:07:01 
//好分区的数目

import java.util.Arrays;

public class NumberOfGreatPartitions{
    public static void main(String[] args) {
         Solution solution = new NumberOfGreatPartitions().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
    public int countPartitions(int[] nums, int k) {
        /**
         * FIXME:
         *  方案一
         *      转化为01背包问题，求一个组总和大于等于k，则另一个组的和就知道了（总数-第一个背包），但是
         *      总和太大，时间复杂度太高。
         *  方案二
         *      反过来想，若背包总和小于k则属于坏分区。然后用所有分区数减去坏分区数。
         */

        if (Arrays.stream(nums).asLongStream().sum() < 2 * k) {//特判，否则后面答案会出错。总和小于2k肯定分不出来，但是后面的逻辑判断不出来
//            System.out.println(Arrays.stream(nums).sum());
//            System.out.println(2 * k);
            return 0;
        }

        int n = nums.length;

        int[][] dp = new int[n + 1][k+1];

        //注意这里是求小于容量，不是等于容量，也不是小于等于，所以注意初始化的值
        Arrays.fill(dp[0], 1);//前0个数总和小于容量j的方案数是1，即空数组
        dp[0][0] = 0;//前0个数和小于0的方案是0

        for (int i = 1; i < n + 1; i++) {//fixme: 不能全选/全不选，否则出现空数组
            for (int j = 1; j < k + 1; j++) {
                //          不选当前数字
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    //选当前数字
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - nums[i - 1]]) % MOD;
                }
//                System.out.println("i=" + i + " j=" + j + " value=" + dp[i][j]);

            }
        }

        return (int) (Math.pow(2, n)% MOD - dp[n][k] *2 % MOD +MOD) % MOD;//坏分区乘2，因为可以在另一个组
        // +MOD是因为取模之后再相减可能为负数，所以再加上

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个正整数数组 nums 和一个整数 k 。 
//
// 分区 的定义是：将数组划分成两个有序的 组 ，并满足每个元素 恰好 存在于 某一个 组中。如果分区中每个组的元素和都大于等于 k ，则认为分区是一个好分区
//。 
//
// 返回 不同 的好分区的数目。由于答案可能很大，请返回对 10⁹ + 7 取余 后的结果。 
//
// 如果在两个分区中，存在某个元素 nums[i] 被分在不同的组中，则认为这两个分区不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], k = 4
//输出：6
//解释：好分区的情况是 ([1,2,3], [4]), ([1,3], [2,4]), ([1,4], [2,3]), ([2,3], [1,4]), ([2
//,4], [1,3]) 和 ([4], [1,2,3]) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,3,3], k = 4
//输出：0
//解释：数组中不存在好分区。
// 
//
// 示例 3： 
//
// 
//输入：nums = [6,6], k = 2
//输出：2
//解释：可以将 nums[0] 放入第一个分区或第二个分区中。
//好分区的情况是 ([6], [6]) 和 ([6], [6]) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 动态规划 👍 43 👎 0
