
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-08 10:56:28 
//将一个数字表示成幂的和的方案数

import java.util.Arrays;

public class WaysToExpressAnIntegerAsSumOfPowers{
    public static void main(String[] args) {
         Solution solution = new WaysToExpressAnIntegerAsSumOfPowers().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = 1_000_000_000 + 7;
    public int numberOfWays(int n, int x) {
        /**
         * 01背包问题
         * 有n个石头，每个石头价值n的x次方，选一些石头使他们的价值和为n. （选择不可能超出n）
         */

        long[][] dp = new long[n + 1][n + 1];

        Arrays.fill(dp[0], 0);//0个数凑不出任何方案

        dp[0][0] = 1; //?

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                double value = Math.pow(i, x); //注意这里用i， 不是 i-1, 例如使用前一个数，那么第一个是1，使用前两个数，那么第二个数是2.
                if (j - value >= 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][(int) (j - value)]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j] % MOD;
                }
            }
        }
        return (int) dp[n][n];//前n个数凑出n
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个 正 整数 n 和 x 。 
//
// 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满
//足 n = n1ˣ + n2ˣ + ... + nkˣ 。 
//
// 由于答案可能非常大，请你将它对 10⁹ + 7 取余后返回。 
//
// 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2³ + 3³ + 5³ 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10, x = 2
//输出：1
//解释：我们可以将 n 表示为：n = 3² + 1² = 10 。
//这是唯一将 10 表达成不同整数 2 次方之和的方案。
// 
//
// 示例 2： 
//
// 输入：n = 4, x = 1
//输出：2
//解释：我们可以将 n 按以下方案表示：
//- n = 4¹ = 4 。
//- n = 3¹ + 1¹ = 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 300 
// 1 <= x <= 5 
// 
//
// Related Topics 动态规划 👍 23 👎 0
