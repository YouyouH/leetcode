
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-30 15:02:58 
//K 次串联后最大子数组之和

public class KConcatenationMaximumSum{
    public static void main(String[] args) {
         Solution solution = new KConcatenationMaximumSum().new Solution();
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{-1}, 0));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{1}, 1));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{1}, 2));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{1}, 5));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{1, 2}, 1));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{1, 2}, 3));
        System.out.println("999999937 ans=" + solution.kConcatenationMaxSum(new int[]{10000,10000,10000,10000,10000,10000,10000,10000,10000,10000}, 100000));
        System.out.println("ans=" + solution.kConcatenationMaxSum(new int[]{-1,1,2,3,-8,4}, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int MOD = 1_000_000_000 + 7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        /**
         * 动态规划
         *     跟最大子数组和差不多，区别是要找规律解决重复k次怎么解。举几个例子可以发现，跟arr 数组的和有关。
         *          如果arr的和 大于0，那么答案就是  dp最大值+(k-2)*sum(arr)
         *          如果arr小于等于0,那么答案就是两个数组连起来的最大序列和。
         *
         *  求子序列和的状态递推公式：
         *      dp[n] = max(dp[n-1] + nums[i], nums[i]) //即dp[n-1]为负数就不要了
         *
         *   FIXME:
         *     规律找错了，题解：
         *     k==1 正常求子数组最大和
         *     如果数组和大于0并且k>2, 那么答案就是 求两个数组串起来的最大值加上 (k-2) * sum。相当于在两个数组中间加上k-2个正数。
         *     如果数组和大于0并且k<=2,那么答案就是两个数组串起来的最大值。
         *     如果数组和小于0 或者 k<=2，答案等于两个子数组的最大子数组和。
         *
         *     先求单个数组最大子数组和，再判断是否要接着再求一个数组的子数组最大值。再判断是否要加上(k-2)*sum
         */

        //求单个子数组和，同时求数组和
        long sum = arr[0];

        int[] dp = new int[arr.length];
        dp[0] = Math.max(0, arr[0]);
        long max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i])%MOD;
            max = Math.max(max, dp[i])%MOD;
        }

        System.out.println("sum=" + sum);
        System.out.println("max1=" + max);
//        if (sum < 0 || k == 1) {
//            return max;
//        }
        if ( k == 1) {
            return (int) max;
        }

        //再加上一个数组求最大子数组和
        int[] dp2 = new int[arr.length];
        dp2[0] = Math.max(dp[arr.length - 1] + arr[0], Math.max(0, arr[0]));
        long max2 = dp2[0];
        for (int i = 1; i < arr.length; i++) {
            dp2[i] = Math.max(dp2[i - 1] + arr[i], arr[i])%MOD;
            max2 = Math.max(max2, dp2[i])%MOD;
        }
        System.out.println("max2=" + max2);

        if (sum <=0 || k <= 2) {
            return (int) max2;
        }

        return (int) (max2 + (k - 2) * sum%MOD);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。 
//
// 例如，如果 arr = [1, 2] ，
// k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。 
//
// 返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。 
//
// 由于 结果可能会很大，需要返回的
// 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2], k = 3
//输出：9
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,-2,1], k = 5
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：arr = [-1,-2], k = 7
//输出：0
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= k <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 141 👎 0
