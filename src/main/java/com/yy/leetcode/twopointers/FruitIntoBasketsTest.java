package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FruitIntoBasketsTest {
    FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();

    @Test
    public void totalFruit() {
        Assert.assertEquals(4, fruitIntoBaskets.totalFruit(new int[]{1, 2, 3, 2, 2}));
        Assert.assertEquals(1, fruitIntoBaskets.totalFruit(new int[]{0}));
        Assert.assertEquals(3, fruitIntoBaskets.totalFruit(new int[]{0,0,1}));
        Assert.assertEquals(2, fruitIntoBaskets.totalFruit(new int[]{0,1}));
    }

    @Test
    public void totalFruit1() {
        Assert.assertEquals(5, fruitIntoBaskets.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}