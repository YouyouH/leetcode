package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionEqualSubsetSumTest {
    PartitionEqualSubsetSum sum = new PartitionEqualSubsetSum();

    @Test
    public void canPartition() {
        Assert.assertFalse(sum.canPartition(new int[]{1}));
        Assert.assertTrue(sum.canPartition(new int[]{1,1}));
        Assert.assertFalse(sum.canPartition(new int[]{}));
        Assert.assertFalse(sum.canPartition(null));
        Assert.assertTrue(sum.canPartition(new int[]{1, 5, 11, 5}));
        Assert.assertFalse(sum.canPartition(new int[]{1, 2, 3, 5}));
        Assert.assertTrue(sum.canPartition(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void canPartition1() {
        Assert.assertTrue(sum.canPartition(new int[]{1, 5, 5, 11,12,15,19}));
    }

    @Test
    public void canPartition2() {
        Assert.assertTrue(sum.canPartition(new int[]{1,2,3,4,5,6,7}));
    }
}