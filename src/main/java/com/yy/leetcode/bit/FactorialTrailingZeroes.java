package com.yy.leetcode.bit;

import java.math.BigInteger;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        BigInteger result = BigInteger.ONE;
        while (n>0){
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }

        int zero = 0;
        while (result.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            result = result.divide(BigInteger.TEN);
            zero++;
        }
        return zero;
    }

}
