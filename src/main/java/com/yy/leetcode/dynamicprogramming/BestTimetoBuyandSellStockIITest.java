package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimetoBuyandSellStockIITest {
    BestTimetoBuyandSellStockII buyandSellStockII = new BestTimetoBuyandSellStockII();

    @Test
    public void maxProfit() {
        Assert.assertEquals(7,buyandSellStockII.maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(0,buyandSellStockII.maxProfit(new int[]{7,6,4,3,1}));
        Assert.assertEquals(4,buyandSellStockII.maxProfit(new int[]{1,2,3,4,5}));
        Assert.assertEquals(0,buyandSellStockII.maxProfit(new int[]{7}));
        Assert.assertEquals(0,buyandSellStockII.maxProfit(null));
    }
}