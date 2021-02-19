package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutiveOnesIIITest {
    MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
    @Test
    public void longestOnes() {
        Assert.assertEquals(6, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}