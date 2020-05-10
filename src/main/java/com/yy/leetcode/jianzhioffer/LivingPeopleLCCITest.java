package com.yy.leetcode.jianzhioffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LivingPeopleLCCITest {
    LivingPeopleLCCI livingPeopleLCCI = new LivingPeopleLCCI();
    @Test
    public void maxAliveYear() {
        Assert.assertEquals(1901,livingPeopleLCCI.maxAliveYear(
                new int[]{1900, 1901, 1950},
                new int[]{1948, 1951, 2000}));
    }
}