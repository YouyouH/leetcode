package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordBreak {
    //方法一：动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    //方法二：DFS 超时
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, wordDict, 0);
    }

    private boolean wordBreak2(String s, List<String> wordDict, int startIndex) {
        if (startIndex >= s.length()) return true;

        for (int i = startIndex; i < s.length(); i++) {
            for (String word : wordDict) {
                if (s.substring(startIndex).startsWith(word)&&wordBreak2(s, wordDict, startIndex + word.length())) {
                    return true;
                }

            }
        }
        return false;
    }
}