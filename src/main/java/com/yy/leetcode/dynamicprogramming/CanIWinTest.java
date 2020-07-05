package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanIWinTest {
    CanIWin canIWin = new CanIWin();
    @Test
    public void canIWin() {
        Assert.assertTrue(canIWin.canIWin(1, 1));
        Assert.assertTrue(canIWin.canIWin(2, 1));
        Assert.assertFalse(canIWin.canIWin(1, 2));
        Assert.assertTrue(canIWin.canIWin(2, 2));
        Assert.assertFalse(canIWin.canIWin(10, 11));
    }

    @Test
    public void canIWin2() {
        Assert.assertTrue(canIWin.canIWin(15, 30));
    }

    @Test
    public void canIWin3() {
        Assert.assertFalse(canIWin.canIWin(20, 300));
    }
}