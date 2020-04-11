package com.yy.leetcode.String;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompareVersionNumbersTest {

    CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();

    @Test
    public void compareVersion() {

        Assert.assertEquals(-1,compareVersionNumbers.compareVersion("0.1", "1.1"));
        Assert.assertEquals(0,compareVersionNumbers.compareVersion("1.0", "1"));
    }
}