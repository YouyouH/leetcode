package com.yy.leetcode.dynamicprogramming.Decision_Making;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimetoBuyandSellStockIITest {

    BestTimetoBuyandSellStockII buyandSellStock = new BestTimetoBuyandSellStockII();

    @Test
    public void maxProfit() {
        Assert.assertEquals(0,buyandSellStock.maxProfit(null));
        Assert.assertEquals(0,buyandSellStock.maxProfit(new int[]{}));
        Assert.assertEquals(0,buyandSellStock.maxProfit(new int[]{1}));
        Assert.assertEquals(1,buyandSellStock.maxProfit(new int[]{1,2}));
        //最多一次操作，可以不操作
        Assert.assertEquals(0,buyandSellStock.maxProfit(new int[]{3,2,1}));
        Assert.assertEquals(7,buyandSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(4,buyandSellStock.maxProfit(new int[]{1,2,3,4,5}));
    }
}