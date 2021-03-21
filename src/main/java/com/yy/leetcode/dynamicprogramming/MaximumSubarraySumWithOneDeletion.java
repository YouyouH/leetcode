package com.yy.leetcode.dynamicprogramming;

/**
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 *
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 *
 * 注意，删除一个元素后，子数组 不能为空。
 *
 * 请看示例：
 *
 * 示例 1：
 *
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarraySumWithOneDeletion {

    /**
     * dp1[i] 表示以i结尾的子数组的最大和(不删除元素)
     * dp2[i] 表示以i结尾的子数组的最大和（删除元素）
     * dp1[i] = dp1[i-1] + a[i]
     * dp2[i] = dp1[i-1],dp2[i] + a[i]
     */
    public int maximumSum(int[] arr) {
        int length = arr.length;
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];
        dp1[0] = arr[0];
        dp2[0] = -200001;
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
            dp2[i] = Math.max(dp1[i - 1], dp2[i-1] + arr[i]);
            max = Math.max(max, Math.max(dp1[i], dp2[i]));
        }
        return max;
    }

}
