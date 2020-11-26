package com.yy.leetcode.twopointers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {
    ThreeSum threeSum = new ThreeSum();

    @Test
    public void threeSum() {
        //-4,-1,-1,0,1,2
        threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        threeSum.threeSum(new int[]{-2, 0, 0, 2, 2});
    }
}