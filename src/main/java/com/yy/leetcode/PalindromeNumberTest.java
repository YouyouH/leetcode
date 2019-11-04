package com.yy.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PalindromeNumberTest {

    @Test
    public void isPalindrome() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        Assert.assertFalse(palindromeNumber.isPalindrome(102010));
        Assert.assertTrue(palindromeNumber.isPalindrome(10201));
        Assert.assertFalse(palindromeNumber.isPalindrome(10002000));
        Assert.assertTrue(palindromeNumber.isPalindrome(100020001));
        Assert.assertFalse(palindromeNumber.isPalindrome(10));
        Assert.assertTrue(palindromeNumber.isPalindrome(0002000));
    }

    @Test
    public void convertToString() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        List<Integer> numbers = new ArrayList<>();
        palindromeNumber.convertToString(0002000,numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}