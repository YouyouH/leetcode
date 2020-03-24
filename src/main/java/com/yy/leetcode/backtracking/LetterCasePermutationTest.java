package com.yy.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LetterCasePermutationTest {

    @Test
    public void letterCasePermutation() {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        List<String> abcd = letterCasePermutation.letterCasePermutation("abcd");
        Assert.assertEquals(16,abcd.size());
    }
}