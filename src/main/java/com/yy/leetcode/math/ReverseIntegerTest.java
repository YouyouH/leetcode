package com.yy.leetcode.math;

import org.junit.Test;


public class ReverseIntegerTest {

    @Test
    public void reverse() {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println("Test: 1234");
        reverseInteger.reverse(1234);

        System.out.println("***************************");

        System.out.println("Test: -1234");
        reverseInteger.reverse(-1234);

        System.out.println("***************************");

        System.out.println("Test: 901000");
        reverseInteger.reverse(901000);

        System.out.println("***************************");

        System.out.println("Test: -2147483648");
        reverseInteger.reverse(-2147483648);
    }
}