package com.yy.leetcode.bitmanipulation;
/**
 * @author youyouhuang
 * @create 2020-04-11
 **/

/**
 * <p>编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p> 示例 1：
 * <p> 输入：00000000000000000000000000001011
 * <p> 输出：3
 * <p> 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p> 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            //从最低位开始，（0&1） == 0   （1&1）==1
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
