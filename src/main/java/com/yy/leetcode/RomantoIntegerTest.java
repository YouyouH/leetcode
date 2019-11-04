package com.yy.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomantoIntegerTest {

    @Test
    public void romanToInt() {
        RomantoInteger romantoInteger = new RomantoInteger();
        Assert.assertEquals(1994,romantoInteger.romanToInt("MCMXCIV"));
        Assert.assertEquals(58,romantoInteger.romanToInt("LVIII"));
        Assert.assertEquals(9,romantoInteger.romanToInt("IX"));
    }
}