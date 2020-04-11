package com.yy.leetcode.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

public class CountingBitsTest {
    CountingBits countingBits = new CountingBits();
    @Test
    public void countBits() {
        Assert.assertArrayEquals(new int[]{0,1,1},countingBits.countBits(2));
        Assert.assertArrayEquals(new int[]{0,1,1,2,1,2},countingBits.countBits(5));
    }
}