package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {
    JumpGame jumpGame = new JumpGame();
    @Test
    public void canJump() {
        Assert.assertTrue(jumpGame.canJump(new int[]{2,3,1,1,4}));
        Assert.assertFalse(jumpGame.canJump(new int[]{3,2,1,0,4}));
    }
}