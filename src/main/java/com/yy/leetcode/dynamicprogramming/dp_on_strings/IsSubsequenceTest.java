package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsSubsequenceTest {

    IsSubsequence isSubsequence = new IsSubsequence();

    @Test
    public void isSubsequence() {
        Assert.assertTrue(isSubsequence.isSubsequence("a", "ab"));
        Assert.assertTrue(isSubsequence.isSubsequence("", ""));
        Assert.assertTrue(isSubsequence.isSubsequence("", " "));
        Assert.assertTrue(isSubsequence.isSubsequence(" ", " "));
        Assert.assertFalse(isSubsequence.isSubsequence(" ", ""));
        Assert.assertTrue(isSubsequence.isSubsequence("ab", "abc"));
        Assert.assertTrue(isSubsequence.isSubsequence("cab", "ccabc"));
        Assert.assertFalse(isSubsequence.isSubsequence("c", "ab"));
    }
}