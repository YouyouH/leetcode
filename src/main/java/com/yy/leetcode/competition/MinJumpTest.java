package com.yy.leetcode.competition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinJumpTest {
    MinJump minJump = new MinJump();

    @Test
    public void minJump() {
        Assert.assertEquals(3, minJump.minJump(new int[]{2, 5, 1, 1, 1, 1}));
    }

}