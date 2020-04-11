package com.yy.leetcode.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Numberof1BitsTest {
    Numberof1Bits numberof1Bits = new Numberof1Bits();
    @Test
    public void hammingWeight() {
       Assert.assertEquals(3,numberof1Bits.hammingWeight(00000000000000000000000000001011));
//       Assert.assertEquals(31,numberof1Bits.hammingWeight(11111111111111111111111111111101));
    }
}