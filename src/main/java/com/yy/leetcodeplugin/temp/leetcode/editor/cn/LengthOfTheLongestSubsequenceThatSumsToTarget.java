
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-06 22:01:25 
//和为目标值的最长子序列的长度

import java.util.Arrays;
import java.util.List;

public class LengthOfTheLongestSubsequenceThatSumsToTarget{
    public static void main(String[] args) {
         Solution solution = new LengthOfTheLongestSubsequenceThatSumsToTarget().new Solution();
        solution.lengthOfLongestSubsequence(Arrays.asList(1, 2, 3, 4, 5), 9);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        /**
         * 01背包问题
         * dp[i][j] 表示前i个数字的子序列最大长度
         */

        int[][] dp = new int[nums.size()+1][target+1];

        //前0个数字只能构成0，其他都无法构成。
        //为什么要设为MIN，要确保不存在的情况为负数并且递推之后的值也一定为负数，如果设为-1可能经过递推（+1）之后变成有效值了
        Arrays.fill(dp[0], Integer.MIN_VALUE);

        //因为nums大于1，所以target为0的时候也为-1
        for (int i = 0; i < nums.size() + 1; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        dp[0][0] = 0;

        for (int i = 1; i < nums.size() + 1; i++) {
            for (int j = 0; j < target+1; j++) {
                Integer num = nums.get(i - 1);
                if (j - num >= 0) {
                    //两种选择，不使用第i个数，使用第i个数
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - num] + 1);
//                    System.out.println("i=" + i + " j=" + j + " value=" + dp[i][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
//                    System.out.println("i=" + i + " j=" + j + " value=" + dp[i][j]);
                }
            }
        }
        return dp[nums.size()][target] < 0 ? -1 : dp[nums.size()][target];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。 
//
// 返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。 
//
// 子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5], target = 9
//输出：3
//解释：总共有 3 个子序列的和为 9 ：[4,5] ，[1,3,5] 和 [2,3,4] 。最长的子序列是 [1,3,5] 和 [2,3,4] 。所以答案为
// 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,1,3,2,1,5], target = 7
//输出：4
//解释：总共有 5 个子序列的和为 7 ：[4,3] ，[4,1,2] ，[4,2,1] ，[1,1,5] 和 [1,3,2,1] 。最长子序列为 [1,3,
//2,1] 。所以答案为 4 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5,4,5], target = 3
//输出：-1
//解释：无法得到和为 3 的子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 1 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 47 👎 0
