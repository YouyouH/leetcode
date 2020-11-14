package com.yy.leetcode.dynamicprogramming.Decision_Making;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class gupiaodezuidalirunlcofTest {

    gupiaodezuidalirunlcof gupiaodezuidalirunlcof = new gupiaodezuidalirunlcof();

    @Test
    public void maxProfit() {
        Assert.assertEquals(1, gupiaodezuidalirunlcof.maxProfit(new int[]{1, 2}));
        Assert.assertEquals(2, gupiaodezuidalirunlcof.maxProfit(new int[]{1, 2, 3}));
        Assert.assertEquals(5, gupiaodezuidalirunlcof.maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(0, gupiaodezuidalirunlcof.maxProfit(new int[]{7,6,4,3,1}));
    }
}