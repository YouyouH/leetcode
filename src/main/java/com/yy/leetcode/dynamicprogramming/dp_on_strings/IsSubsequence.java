package com.yy.leetcode.dynamicprogramming.dp_on_strings;

/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        //i,j 表示前i，j个字符

        if(s == null || t == null){
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        for (int i = 0; i < t.length()+1; i++) {
            dp[0][i] = true;
        }


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
