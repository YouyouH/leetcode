package com.yy.leetcode.unclear;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {
    Pow pow = new Pow();
    @Test
    public void myPow() {
        double myPow = pow.myPow(2.00000, 3);
        System.out.println(myPow);
    }

    @Test
    public void myPow1() {
        double myPow = pow.myPow(2.10000, -3);
        System.out.println(myPow);
    }
}