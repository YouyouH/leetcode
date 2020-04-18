package com.yy.leetcode.session2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    @Test
    public void maxArea() {
        Assert.assertEquals(49,containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(0,containerWithMostWater.maxArea(new int[]{}));
    }
}