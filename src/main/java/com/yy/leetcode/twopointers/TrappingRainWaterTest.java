package com.yy.leetcode.twopointers;


import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {

    TrappingRainWater trappingRainWater = new TrappingRainWater();

    @Test
    public void trap() {
        Assert.assertEquals(6,trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    @Test
    public void trap2() {
        Assert.assertEquals(0,trappingRainWater.trap(null));
    }

    @Test
    public void trap3() {
         Assert.assertEquals(0,trappingRainWater.trap(new int[]{0,1,0}));
    }

    @Test
    public void trap4() {
        Assert.assertEquals(1,trappingRainWater.trap(new int[]{5,4,1,2}));
    }
}