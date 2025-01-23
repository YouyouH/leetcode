
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-22 17:28:58 
//不同的子序列

import java.util.Arrays;

public class DistinctSubsequences{
    public static void main(String[] args) {
         Solution solution = new DistinctSubsequences().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
    public int numDistinct(String s, String t) {
        /**
         * FIXME  dp[i][j]表示t前j个字符在s前i个字符的子序列中出现的数量
         *    当前字符不相等
         *        dp[i][j] = dp[i-1][j-1]
         *    当前字符相等
         *        dp[i][j] = dp[i-1][j-1] + dp[i-1][j] //虽然相等但是不使用  +  使用当前字符
         *        这种情况跟背包问题一样，用或者不用都可以
         *
         */

        int l1 = s.length();
        int l2 = t.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < l1 + 1; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j < l2 + 1; j++) {
                char c2 = t.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j])%MOD;
                } else {
                    dp[i][j] = dp[i - 1][j]%MOD;
                }
            }
        }
        return dp[l1][l2];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10⁹ + 7 取模。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1305 👎 0
