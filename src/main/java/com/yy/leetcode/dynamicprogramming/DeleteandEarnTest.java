package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteandEarnTest {
DeleteandEarn deleteandEarn = new DeleteandEarn();
    @Test
    public void deleteAndEarn() {
        Assert.assertEquals(6, deleteandEarn.deleteAndEarn(new int[]{3, 4, 2}));
    }

    @Test
    public void deleteAndEarn1() {
        Assert.assertEquals(9, deleteandEarn.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    @Test
    public void deleteAndEarn2() {
        Assert.assertEquals(61, deleteandEarn.deleteAndEarn(new int[]{8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4}));
    }

    @Test
    public void deleteAndEarn3() {
        Assert.assertEquals(138,
                deleteandEarn.deleteAndEarn(new int[]{1,8,5,9,6,9,4,1,7,3,3,6,3,3,8,2,6,3,2,2,1,2,9,8,7,1,1,10,6,7,3,9,6,10,5,4,10,1,6,7,4,7,4,1,9,5,1,5,7,5}));
    }
}