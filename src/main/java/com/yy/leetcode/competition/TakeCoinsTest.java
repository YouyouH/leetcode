package com.yy.leetcode.competition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TakeCoinsTest {
    TakeCoins takeCoins = new TakeCoins();
    @Test
    public void minCount() {
        Assert.assertEquals(8,takeCoins.minCount(new int[]{2,3,10}));
        Assert.assertEquals(8,takeCoins.minCount(new int[]{0,2,3,0,10}));
    }
}