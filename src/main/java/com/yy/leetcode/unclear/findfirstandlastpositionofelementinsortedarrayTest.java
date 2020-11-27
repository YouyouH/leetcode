package com.yy.leetcode.unclear;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class findfirstandlastpositionofelementinsortedarrayTest {

    findfirstandlastpositionofelementinsortedarray findfirstandlastpositionofelementinsortedarray = new findfirstandlastpositionofelementinsortedarray();

    @Test
    public void searchRange() {
        Assert.assertArrayEquals(new int[]{3,4},findfirstandlastpositionofelementinsortedarray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertArrayEquals(new int[]{0,1},findfirstandlastpositionofelementinsortedarray.searchRange(new int[]{8, 8}, 8));
        Assert.assertArrayEquals(new int[]{-1,-1},findfirstandlastpositionofelementinsortedarray.searchRange(new int[]{5,7,7,8,8,10},6));
        Assert.assertArrayEquals(new int[]{0,0},findfirstandlastpositionofelementinsortedarray.searchRange(new int[]{1},1));
    }

}