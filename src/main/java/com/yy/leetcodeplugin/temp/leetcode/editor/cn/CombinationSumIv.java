
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-25 17:35:29 
//组合总和 Ⅳ

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CombinationSumIv{
    public static void main(String[] args) {
         Solution solution = new CombinationSumIv().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Map<Integer, Integer> memo = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        /**
         * 穷举法：
         *    深度遍历，递归实现
         *
         *    超时了,加一个备忘录
         */
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += combinationSum4(nums, target - nums[i]); //深度遍历
        }
        memo.put(target, count);
        return count;

    }
}

    class Solution2 {
        //fixme: 还没做完------------------------------------
        public int combinationSum4(int[] nums, int target) {
            /**
             * 穷举法：
             *    深度遍历，递归实现
             *
             *    动态规划：
             *      前n个数凑出target的组合个数等于  前n个数凑出target-nums[n]的组合数(需要最后一个数) + 前n-1个数凑出target的组合数（不需要最后一个数）
             *    dp[n][target] = dp[n-1][target] + dp[n-1][target-nums[n]]
             *
             *    上面这个状态转移公式是错误的，这个题目 1,2,1 和 1，1，2 是两种不同的情况。
             *
             *    FIXME: 上面的公式适合完全背包问题（零钱兑换2），因为121和112只能算一种，即一个硬币考虑完之后就遍历下一个硬币，不会再回头考虑上一个。
             *    用穷举法做：
             *          完全背包问题,一个物品考虑完之后（两个选择 放与不放）就会考虑下一个物品，上一个物品就不不会再考虑了(考虑了就重复了)，即在进入下一个递归的时候物品列表会缩短。
             *          但是本题在一个数考虑完之后（取与不取），下一层递归又会重新考虑所有数
             *    用动态规划做：
             *          对于完全背包问题,凑满target有哪些情况？
             *              最后一个数取或者不取，前面的数不再考虑了，否则重复了.
             *              dp[n][target] = dp[n-1][target] + dp[n-1][target-nums[n-1]]
             *          本题凑满target有哪些情况？
             *              最后一个数可以是nums[0],nums[1],nums[2],nums[3]......nums[n-1]
             *              所以dp[n][target] = dp[0][target-nums[0]] + dp[1][target-nums[1]]+dp[2][target-nums[2]]+......dp[n-1][target-nums[n-1]]
             *
             *
             */



            int[][] dp = new int[nums.length][target+1];

            for (int i = 0; i < target+1; i++) {
                dp[0][i] = 0; //前0个数凑不出任何target
            }
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = 0; //target是0的时候没有任何组合
            }

            dp[0][0] = 1;

            //双层循环
            for (int i = 1; i < target+1; i++) {
                for (int j = 1; j < nums.length; j++) {
                    if (i - nums[j] > 0) {
                        dp[j][i] = dp[j - 1][i] + dp[j][i - nums[j]];
                    }
                }
            }

            return dp[nums.length-1][target];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics 数组 动态规划 👍 1078 👎 0
