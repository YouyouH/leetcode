package com.yy.leetcode.dynamicprogramming.dp_on_strings;

/**
 * @author youyouhuang
 * @create 2020-03-11
 * @desc
 **/

/**
 * 思路：DP on Strings
 *  最小子问题: 判断相邻两个字符是不是回文子串。然后再向外扩展。判断四个字符的时候可以直接利用之前算出来的结果。
 *  因为如果s[i][j]是回文子串，则s[i+1][j-1]也是
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s ==null){
            return null;
        }
        if(s.length() < 2){
            return s;
        }
        int n = s.length();

        int[][] dp = new int[n][n];

        String max = null;

        //l代表子串长度
        for (int l = 1; l < n; ++l) {
            //i代表左指针(子串起点)
            for (int i = 0; i < n-l; ++i) {
                //j代表子串终点
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (l < 3 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    max = s.substring(i, j+1);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if(n > 1 && max ==null){
            return s.substring(0,1);
        }
        return max;
    }
}
