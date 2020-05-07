package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
    LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();

    @Test
    public void lengthOfLIS() {
        Assert.assertEquals(0, longestIncreasingSubsequence.lengthOfLIS(new int[]{}));
        Assert.assertEquals(0, longestIncreasingSubsequence.lengthOfLIS(null));
        Assert.assertEquals(1, longestIncreasingSubsequence.lengthOfLIS(new int[]{1}));
        Assert.assertEquals(0, longestIncreasingSubsequence.lengthOfLIS(new int[]{3,2,1}));
        Assert.assertEquals(3, longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
        Assert.assertEquals(6, longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4,11,12,12,13}));
        Assert.assertEquals(4, longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 23, 5, 88, 49,11,12,12,13}));
    }
}