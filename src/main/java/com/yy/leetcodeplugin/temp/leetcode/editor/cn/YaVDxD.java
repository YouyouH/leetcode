  //给定一个正整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 494 题相同： https://leetcode-cn.com/problems/target-sum/ 
//
// Related Topics 数组 动态规划 回溯 👍 27 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-08-26 14:44:20 
//加减的目标值

public class YaVDxD{
    public static void main(String[] args) {
        Solution solution = new YaVDxD().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
             //怎么转化为背包问题？物品价值加起来可能为负数，怎么表示？
            // sumk1 表示 选择为正数的和， sumk2 表示 选择为负数的数的和
            // sumk1 - sumk2 = target
            // sumk1 + sumk2 = nums.sum
            //从上面两个不等式可得：
            // sumk1 = (target + nums.sum)/2

            //此时就可以转化为背包问题
            //状态：背包容量，当前容量
            //选择：选哪个物品。每一个数都必须选， 加或者减
            //定义dp[i][j]表示前i个 正数 凑出和为j的方案的数量
            //答案为 dp[nums.length][sumk1]


            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if ((sum - target) % 2 != 0 || (sum - target) < 0) return 0;
            int minus = (sum + target) / 2;
            //if (minus == 0) return 1;
            int[][] dp = new int[nums.length + 1][minus + 1];

            for (int i = 0; i <= nums.length; ++i) {
                dp[i][0] = 1;
            }
            // dp[i][j] 前i个数 和为j的组合数
            for (int i = 1; i <= nums.length; ++i) {
                for (int j = 0; j <= minus;++j) {
                    if (j - nums[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[nums.length][minus];
        }
    }



    class Solution2 {
        int count = 0;

        //回溯遍历所有情况
        public int findTargetSumWays(int[] nums, int target) {
            //遍历所有情况
            traverse(nums, 0, 0, target);
            return count;
        }

        private void traverse(int[] nums, int index, int sum, int target) {
            if (index == nums.length) {
                if (sum == target) {
                    count++;
                }
                return;
            }
            traverse(nums, index + 1, sum + nums[index], target);
            traverse(nums, index + 1, sum - nums[index], target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}