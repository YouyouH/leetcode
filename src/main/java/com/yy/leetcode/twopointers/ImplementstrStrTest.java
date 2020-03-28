package com.yy.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementstrStrTest {

    ImplementstrStr implementstrStr = new ImplementstrStr();

    @Test
    public void strStr() {
        Assert.assertEquals(9,implementstrStr.strStr("mississippi", "pi"));
        Assert.assertEquals(4,implementstrStr.strStr("mississippi", "issip"));
        Assert.assertEquals(-1,implementstrStr.strStr("aaa", "aaaa"));
        Assert.assertEquals(0,implementstrStr.strStr("aaa", "a"));
        Assert.assertEquals(2,implementstrStr.strStr("hello", "ll"));
        Assert.assertEquals(2,implementstrStr.strStr("helloll", "ll"));
        Assert.assertEquals(-1,implementstrStr.strStr("hello", "0"));
        Assert.assertEquals(-1,implementstrStr.strStr("", "0"));
        Assert.assertEquals(0,implementstrStr.strStr("", ""));
        Assert.assertEquals(0,implementstrStr.strStr(" ", ""));
        Assert.assertEquals(0,implementstrStr.strStr(" ", " "));
    }
}