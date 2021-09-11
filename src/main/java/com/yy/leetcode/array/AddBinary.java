package com.yy.leetcode.array;

import java.util.Arrays;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        //先区分出大数组和小数组
        if (a.charAt(0) == '0' && b.charAt(0) == '0') {
            return "0";
        }
        char[] ac;
        char[] bc;
        if (a.length() > b.length()) {
            ac = a.toCharArray();
            bc = b.toCharArray();
        } else {
            ac = b.toCharArray();
            bc = a.toCharArray();
        }
        //把两个数组补齐.
        //改进： 不需要用新的数组，直接判断指针是不是超过了数组大小
        char[] tc = new char[ac.length];
        Arrays.fill(tc, '0');
        int j = 0;
        for (int i = ac.length - bc.length; i < ac.length; i++) {
            tc[i] = bc[j++];
        }

        int carry = 0;
        for (int i = ac.length-1; i >=0; i--) {
            int i1 = tc[i] - '0';
            int i2 = ac[i] - '0';
            if (carry + i1 + i2 >= 2) {
                tc[i] = carry + i1 + i2 -2 == 1 ? '1' : '0';
                carry = 1;
            }else{
                tc[i] = carry + i1 + i2 == 1 ? '1' : '0';
                carry=0;
            }
        }
        if(carry == 1){
            return "1" + String.valueOf(tc);
        }
        return String.valueOf(tc);
    }

}
