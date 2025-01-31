
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-31 20:29:08 
//分割数组的最大值

import java.util.Arrays;

public class SplitArrayLargestSum{
    public static void main(String[] args) {
         Solution solution = new SplitArrayLargestSum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //FIXME 抄的
            public int splitArray(int[] nums, int k) {
                /**
                 * dp[i][j] 表示前i个数分为j段的最小值
                 */
                int n = nums.length;
                int[][] dp = new int[n + 1][k + 1];

                for (int i = 0; i <= n; i++) {
                    Arrays.fill(dp[i], Integer.MAX_VALUE);//默认值给一个不可能的值，避免对后面比较最小值产生干扰
                }

                //初始化
                Arrays.fill(dp[0], 0);
//                dp[1][1] = nums[0];

                //求前缀和
                int[] sub = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    sub[i + 1] = sub[i] + nums[i];
                }

                for (int i = 1; i < n + 1; i++) {
                    for (int j = 1; j < k + 1 && j <= i; j++) {//分割的组不能比i还大，因为不能有空数组
                        for (int l = 0; l < i; l++) {
                            //前l个数凑成j-1段，剩余的数凑成最后一段
                            dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j - 1], sub[i]-sub[l]));
                        }

                    }
                }

                return dp[n][k];

            }

        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。 
//
// 返回分割后最小的和的最大值。 
//
// 子数组 是数组中连续的部份。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], k = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], k = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], k = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 1020 👎 0
