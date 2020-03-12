package com.yy.leetcode.dynamicprogramming.dp_on_strings;

/**
 * @author youyouhuang
 * @create 2020-03-11
 * @desc
 **/

/**
 * 对于两个字符串的DP通用思路：
 * <p>
 * 1.两个指针 i,j 指向两个字符串的末尾。
 * 2.dp[i][j]表示 长度为 i 的子串和长度为 j 的子串的LCS长度。
 * 3.可以推出dp[i-1][j]和 dp[i][j-1] 和dp[i-1][j-1] 和 dp[i][j]的递推关系式。
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;

        int max = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    if (i == 1) {
                        dp[i - 1][j] = 0;
                    }
                    if (j == 1) {
                        dp[i][j - 1] = 0;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

}
