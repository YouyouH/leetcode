package com.yy.leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

public class jumpGameTest {

    JumpGame_timeout jumpGame = new JumpGame_timeout();

    @Test
    public void canJump() {
        Assert.assertEquals(jumpGame.canJump(new int[]{2,3,1,1,4}),true);
        Assert.assertEquals(jumpGame.canJump(new int[]{0}),true);
        Assert.assertEquals(jumpGame.canJump(new int[]{0,0,0}),false);
        Assert.assertEquals(jumpGame.canJump(new int[]{1,1,0}),true);
        Assert.assertEquals(jumpGame.canJump(new int[]{3,2,1,0,4}),false);
    }

    @Test
    public void canJump1() {
        Assert.assertEquals(jumpGame.canJump(new int[]{1,1,0}),true);
        Assert.assertEquals(jumpGame.canJump(new int[]{3,2,1,0,4}),false);
        Assert.assertEquals(jumpGame.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}),true);
    }

    @Test
    public void canJump2() {
        Assert.assertEquals(jumpGame.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}),true);
    }
}