package com.yy.leetcode.doublepointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    ContainerWithMostWater container = new ContainerWithMostWater();

    @Test
    public void maxArea2() {
        Assert.assertTrue(container.maxArea(null) == 0);
        Assert.assertTrue(container.maxArea(new int[]{}) == 0);
    }

    @Test
    public void maxArea1() {
        Assert.assertTrue(container.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
    }

    @Test
    public void maxArea3() {
        Assert.assertTrue(container.maxArea(new int[]{0,0,0}) == 0);
    }

    @Test
    public void maxArea4() {
        Assert.assertTrue(container.maxArea(new int[]{1,1,1}) == 2);
    }

    @Test
    public void maxArea5() {
        Assert.assertTrue(container.maxArea(new int[]{1}) == 0);
    }

}