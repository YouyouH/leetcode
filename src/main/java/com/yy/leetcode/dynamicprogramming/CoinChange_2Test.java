package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class CoinChange_2Test {

    CoinChange_2_backtracking coinChange = new CoinChange_2_backtracking();
    @Test
    public void coinChange() {
        Assert.assertEquals(2,coinChange.coinChange(new int[]{1,2},3));
        Assert.assertEquals(3,coinChange.coinChange(new int[]{1, 2, 5},11));
        Assert.assertEquals(-1,coinChange.coinChange(new int[]{2},3));
    }

    @Test
    public void coinChange1() {
        Assert.assertEquals(3,coinChange.coinChange(new int[]{1,2,3,4,5,6,7,8,9},20));
    }
    @Test
    public void coinChange2() {
        Assert.assertEquals(12,coinChange.coinChange(new int[]{1,2,3,4,5,6,7,8,9},100));
    }
    //[1,2147483647]
    //2
    @Test
    public void coinChange22() {
        Assert.assertEquals(2,coinChange.coinChange(new int[]{1,2147483647},2));
    }

    @Test
    public void coinChange3() {
        Assert.assertEquals(4,coinChange.coinChange(new int[]{6,7,8,9,10},40));
    }

    @Test
    public void coinChange00() {
        Assert.assertEquals(-1, coinChange.coinChange(new int[]{}, 3));
        Assert.assertEquals(0, coinChange.coinChange(new int[]{1}, 0));
        Assert.assertEquals(-1, coinChange.coinChange(null, 3));
    }
}