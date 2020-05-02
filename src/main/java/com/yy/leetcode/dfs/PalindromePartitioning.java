package com.yy.leetcode.dfs;
/**
 * @author youyouhuang
 * @create 2020-05-02
 **/

import java.util.*;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。  返回 s 所有可能的分割方案。
 * <p>
 *
 * </p>
 **/
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        //暴力法 + 剪枝
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        s = s.trim();
        if (s.length() == 0) {
            return result;
        }
        HashMap<String, Boolean> sub = new HashMap<>();
        dfs(s, 0, new ArrayList<String>(), result, sub);
        return result;
    }

    private void dfs(String s, int start, List<String> temp, List<List<String>> result, HashMap<String, Boolean> sub) {

        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 1; i <= s.length() - start; i++) {
            String substring = s.substring(start, start + i);
            if (sub.get(substring) == null) {
                sub.put(substring, isPalindrome(substring));
            }
            if (sub.get(substring)) {
                temp.add(substring);
            } else {
                continue;
            }
            dfs(s, start + i, temp, result, sub);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isPalindrome(String substring) {
        int left = 0;
        int right = substring.length() - 1;
        while (left <= right) {
            if (substring.charAt(left) != substring.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
