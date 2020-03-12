package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

    @Test
    public void longestCommonSubsequence() {
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("","bc") == 0);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("","") == 0);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence(" ","") == 0);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence(" "," ") == 1);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("  "," ") == 1);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence(null,null) == 0);
    }

    @Test
    public void longestCommonSubsequence1() {
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("abc","bc") == 2);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("abc","abc") == 3);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("abc","cde") == 1);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("a","a") == 1);
        Assert.assertTrue(longestCommonSubsequence.longestCommonSubsequence("a","b") == 0);
    }
}