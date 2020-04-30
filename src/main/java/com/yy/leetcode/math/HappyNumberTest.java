package com.yy.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HappyNumberTest {

    @Test
    public void isHappy() {
        HappyNumber happyNumber = new HappyNumber();
        Assert.assertTrue(happyNumber.isHappy(19));
        Assert.assertFalse(happyNumber.isHappy(0));
        Assert.assertTrue(happyNumber.isHappy(1));
    }
}