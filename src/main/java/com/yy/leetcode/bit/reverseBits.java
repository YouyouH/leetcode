package com.yy.leetcode.bit;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * @author huangyou
 */
public class reverseBits {
    // you need treat n as an unsigned value

    /**
     * 方法一: 分治合并
     * 第一步：按16位反转
     * 第二步：按8位反转
     * 第三步：按4位反转
     * 第四步：按2位反转
     * 第五步：按1位反转
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        // | 用来合并两个数， >>>无符号右移，高位补0， >>有符号右移
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    /**
     * 方法二:
     *
     * @param n
     * @return
     */
    public int reverseBits2(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1 + n & 1;
            n = n >> 1;
        }
        return result;
    }
}
