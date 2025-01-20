
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-20 13:26:58 
//掷骰子等于目标和的方法数

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum{
    public static void main(String[] args) {
         Solution solution = new NumberOfDiceRollsWithTargetSum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        /**
         * 分组背包
         *      状态： 选/不选 第i个骰子。 求构成target的方案数。
         *
         *      FIXME：
         *          TODO 通过前缀和优化
         */
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                //不选当前骰子
//                int a = dp[i-1][j];//fixme 注意这里每个骰子都要选，所以不要管不选当前骰子的情况
                //选当前骰子
                int b = 0;
                for (int l = 1; l < k + 1; l++) {
                    if (j - l >= 0) {
                        b = (b + dp[i - 1][j - l] % MOD) % MOD;
                    }
                }
                dp[i][j] = (b) % MOD;
            }
        }
        return dp[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。 
//
// 给定三个整数 n、k 和 target，请返回投掷骰子的所有可能得到的结果（共有 kⁿ 种方式），使得骰子面朝上的数字总和等于 target。 
//
// 由于答案可能很大，你需要对 10⁹ + 7 取模。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1, k = 6, target = 3
//输出：1
//解释：你掷了一个有 6 个面的骰子。
//得到总和为 3 的结果的方式只有一种。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 6, target = 7
//输出：6
//解释：你掷了两个骰子，每个骰子有 6 个面。
//有 6 种方式得到总和为 7 的结果: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1。
// 
//
// 示例 3： 
//
// 
//输入：n = 30, k = 30, target = 500
//输出：222616187
//解释：返回的结果必须对 10⁹ + 7 取模。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 30 
// 1 <= target <= 1000 
// 
//
// Related Topics 动态规划 👍 296 👎 0
