package com.yy.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {
    ValidPalindrome validPalindrome = new ValidPalindrome();

    @Test
    public void isPalindrome() {
        validPalindrome.isPalindrome(" a");
        Assert.assertTrue(validPalindrome.isPalindrome("."));
        Assert.assertFalse(validPalindrome.isPalindrome("0P"));
    }
}