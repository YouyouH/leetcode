package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimetoBuyandSellStockIVTest {

    BestTimetoBuyandSellStockIV buyandSellStockIV = new BestTimetoBuyandSellStockIV();

    @Test
    public void maxProfit99() {
        Assert.assertEquals(0, buyandSellStockIV.maxProfit(2, new int[]{2}));
        Assert.assertEquals(0, buyandSellStockIV.maxProfit(0, new int[]{2}));
        Assert.assertEquals(0, buyandSellStockIV.maxProfit(-1, new int[]{}));
    }

    @Test
    public void maxProfit0() {
        Assert.assertEquals(1,buyandSellStockIV.maxProfit(2,new int[]{1,2}));
    }

    @Test
    public void maxProfit1() {
        Assert.assertEquals(1,buyandSellStockIV.maxProfit(1,new int[]{1,2}));
        Assert.assertEquals(2,buyandSellStockIV.maxProfit(2,new int[]{2,4,1}));
    }

    @Test
    public void maxProfit() {
        Assert.assertEquals(7,buyandSellStockIV.maxProfit(2,new int[]{3,2,6,5,0,3}));
    }

    @Test
    public void maxProfit2() {
        Assert.assertEquals(4,buyandSellStockIV.maxProfit(2,new int[]{3,2,6,5}));
    }
}