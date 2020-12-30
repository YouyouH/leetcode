package com.yy.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddBinaryTest {

    AddBinary addBinary = new AddBinary();

    @Test
    public void addBinary() {
        Assert.assertEquals("10101", addBinary.addBinary("1010", "1011"));
        Assert.assertEquals("100", addBinary.addBinary("11", "1"));
        Assert.assertEquals("100", addBinary.addBinary("1", "11"));
        Assert.assertEquals("0", addBinary.addBinary("0", "0"));
        Assert.assertEquals("1", addBinary.addBinary("1", "0"));
        Assert.assertEquals("111", addBinary.addBinary("111", "0"));
        Assert.assertEquals("11110", addBinary.addBinary("1111", "1111"));
    }
}