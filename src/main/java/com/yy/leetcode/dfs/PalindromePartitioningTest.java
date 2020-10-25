package com.yy.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromePartitioningTest {
    PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
    @Test
    public void partition() {
        Assert.assertEquals(2,palindromePartitioning.partition("aab").size());
        Assert.assertEquals(0,palindromePartitioning.partition(" ").size());
        Assert.assertEquals(0,palindromePartitioning.partition(null).size());
        Assert.assertEquals(0,palindromePartitioning.partition("").size());
    }
}