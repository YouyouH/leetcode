package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @Test
    public void longestPalindrome() {
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome(null) ==null);
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("").equals(""));
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome(" ").equals(" "));
    }

    @Test
    public void longestPalindrome1() {
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("aaa").equals("aaa"));
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("cabbad").equals("abba"));
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("abba").equals("abba"));
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("msdnjkopo").equals("opo"));
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("abc") ==null);
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("aa").equals("aa"));

    }

    @Test
    public void longestPalindrome2() {
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("ac").equals("a"));
        Assert.assertTrue(longestPalindromicSubstring.longestPalindrome("abcd").equals("a"));
    }
}