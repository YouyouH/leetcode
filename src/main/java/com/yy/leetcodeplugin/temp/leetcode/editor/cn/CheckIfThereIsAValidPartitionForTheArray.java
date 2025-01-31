
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-31 11:03:59 
//检查数组是否存在有效划分

public class CheckIfThereIsAValidPartitionForTheArray{
    public static void main(String[] args) {
         Solution solution = new CheckIfThereIsAValidPartitionForTheArray().new Solution();
        solution.validPartition(new int[]{4, 4, 4, 5, 6});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public boolean validPartition(int[] nums) {
                /**
                 * 划分型DP
                 *  dp[i] 表示以nums[i]结尾的数组能否划分
                 *
                 *  FIXME:超时了
                 */
                int length = nums.length;
                boolean[] dp = new boolean[length];

                //初始化
//                dp[0] = false;
                for (int i = 0; i < length; i++) {
                    /**
                     * FIXME 下面这一段逻辑正确但是超时了
                     *  因为题目限定了只有可能是是两个数或者三个数才组成有效划分，所有j不用循环这么多，
                     *  直接便利两个数或者三个数的情况即可
                     */
//                    dp[i] = isValid(nums, 0, i);
//                    if (dp[i]) {
//                        continue;
//                    }
//
//                    for (int j = 0; j < i; j++) {
//                        dp[i] =  isValid(nums, j + 1, i) && dp[j];
//                        if (dp[i]) {
//                            break; //FIXME: 遇到true了就可以退出了
//                        }
//                    }

                    dp[i] = isValid(nums, 0, i);
                    if (dp[i]) {
                        continue;
                    }

                    if (i - 3 >= 0) {
                        dp[i] = dp[i - 3] && isValid(nums, i - 2, i);
                        if (dp[i]) {
                            continue;
                        }
                    }
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] && isValid(nums, i - 1, i);
                        if (dp[i]) {
                            continue;
                        }
                    }


                }
                return dp[length - 1];
            }

            private boolean isValid(int[] nums, int start, int end) {
                if (end - start == 1) {
                    return nums[start] == nums[end];
                }
                if (end - start == 2) {
                    if (nums[start] == nums[start + 1] && nums[start] == nums[end]) {
                        return true;
                    }

                    if (nums[start] + 1 == nums[start + 1] && nums[start] + 2 == nums[end]) {
                        return true;
                    }

                }
                return false;
            }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。 
//
// 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分： 
//
// 
// 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。 
// 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。 
// 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。 
// 
//
// 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,4,5,6]
//输出：true
//解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
//这是一种有效划分，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2]
//输出：false
//解释：该数组不存在有效划分。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 动态规划 👍 104 👎 0
