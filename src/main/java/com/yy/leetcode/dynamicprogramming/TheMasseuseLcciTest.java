package com.yy.leetcode.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheMasseuseLcciTest {

    TheMasseuseLcci theMasseuseLcci = new TheMasseuseLcci();

    @Test
    public void massage() {
        Assert.assertEquals(1, theMasseuseLcci.massage(new int[]{1}));
        Assert.assertEquals(2, theMasseuseLcci.massage(new int[]{1,2}));
        Assert.assertEquals(2, theMasseuseLcci.massage(new int[]{1,2,1}));

        Assert.assertEquals(4, theMasseuseLcci.massage(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(12, theMasseuseLcci.massage(new int[]{2, 7, 9, 3, 1}));
        Assert.assertEquals(12, theMasseuseLcci.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }
}