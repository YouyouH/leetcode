package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumProductSubarrayTest {
    MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

    @Test
    public void maxProduct() {
        Assert.assertEquals(6, maximumProductSubarray.maxProduct(new int[]{2, 3, -2, 4}));
        Assert.assertEquals(0, maximumProductSubarray.maxProduct(new int[]{-2, 0, -1}));
        Assert.assertEquals(0, maximumProductSubarray.maxProduct(new int[]{0}));
        Assert.assertEquals(2, maximumProductSubarray.maxProduct(new int[]{0,2}));

    }
}