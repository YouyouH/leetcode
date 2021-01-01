package com.yy.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanPlaceFlowersTest {
    CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
    @Test
    public void canPlaceFlowers() {
        Assert.assertTrue(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1},1));
        Assert.assertFalse(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1},2));
        Assert.assertTrue(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1,1,0,0,0,1,1,1,1},2));
        Assert.assertTrue(canPlaceFlowers.canPlaceFlowers(new int[]{0},1));
        Assert.assertFalse(canPlaceFlowers.canPlaceFlowers(new int[]{1},1));
        Assert.assertTrue(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,1},1));
        Assert.assertTrue(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,0},1));
        Assert.assertTrue(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,0},2));
    }
}