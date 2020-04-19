package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameIITest {
    JumpGameII jumpGameII = new JumpGameII();

    @Test
    public void jump() {
        Assert.assertEquals(2, jumpGameII.jump(new int[]{2, 3, 4, 1, 1}));
        Assert.assertEquals(2, jumpGameII.jump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(0, jumpGameII.jump(new int[]{}));
        Assert.assertEquals(0, jumpGameII.jump(new int[]{2}));
        Assert.assertEquals(1, jumpGameII.jump(new int[]{1, 1}));
        Assert.assertEquals(1, jumpGameII.jump(new int[]{1, 1}));
    }

    @Test
    public void jump1() {
        Assert.assertEquals(2, jumpGameII.jump(new int[]{2, 3, 0, 1, 4}));
        Assert.assertEquals(2, jumpGameII.jump(new int[]{1, 2, 3}));
        Assert.assertEquals(3, jumpGameII.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }

    @Test
    public void jump2() {
        Assert.assertEquals(3, jumpGameII.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }
}