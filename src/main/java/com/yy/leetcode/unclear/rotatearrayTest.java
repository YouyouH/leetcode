package com.yy.leetcode.unclear;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class rotatearrayTest {
    rotatearray rotatearray = new rotatearray();
    @Test
    public void rotate() {
        int[] input = new int[]{1,2,3,4,5,6,7};
        rotatearray.rotate(input,3);
        Assert.assertArrayEquals(new int[]{5,6,7,1,2,3,4},input);
    }

    @Test
    public void rotate2() {
        int[] input = new int[]{1,2,3,4,5,6,7};
        rotatearray.rotate(input,4);
        Assert.assertArrayEquals(new int[]{4,5,6,7,1,2,3},input);
    }
}