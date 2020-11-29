package com.yy.leetcode.dynamicprogramming.dp_on_strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WordBreakTest {
    WordBreak wordBreak = new WordBreak();
    @Test
    public void wordBreak() {
        Assert.assertTrue(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assert.assertFalse(wordBreak.wordBreak("leetcod", Arrays.asList("leet", "code")));
    }

    @Test
    public void wordBreak2() {
        Assert.assertTrue(wordBreak.wordBreak2("leetcode", Arrays.asList("leet", "code")));
        Assert.assertFalse(wordBreak.wordBreak2("leetcod", Arrays.asList("leet", "code")));
        Assert.assertTrue(wordBreak.wordBreak2("cars", Arrays.asList("car", "ca","rs")));
    }
}