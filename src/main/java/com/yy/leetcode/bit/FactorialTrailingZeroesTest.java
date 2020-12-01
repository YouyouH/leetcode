package com.yy.leetcode.bit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTrailingZeroesTest {
    FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();

    @Test
    public void trailingZeroes() {
        Assert.assertEquals(4, factorialTrailingZeroes.trailingZeroes(20));
    }
}