package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarraySumWithOneDeletionTest {
    MaximumSubarraySumWithOneDeletion maximumSubarraySumWithOneDeletion = new MaximumSubarraySumWithOneDeletion();
    @Test
    public void maximumSum() {
        Assert.assertEquals(4, maximumSubarraySumWithOneDeletion.maximumSum(new int[]{1, -2, 0, 3}));
        Assert.assertEquals(3, maximumSubarraySumWithOneDeletion.maximumSum(new int[]{1,-2,-2,3}));
        Assert.assertEquals(-1, maximumSubarraySumWithOneDeletion.maximumSum(new int[]{-1,-1,-1,-1}));
    }
}