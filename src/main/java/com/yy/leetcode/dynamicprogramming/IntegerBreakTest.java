package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerBreakTest {
    IntegerBreak integerBreak = new IntegerBreak();
    @Test
    public void integerBreak() {
        Assert.assertTrue(4 == integerBreak.integerBreak(4));
    }
}