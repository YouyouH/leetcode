package com.yy.leetcode.array;

import java.util.Locale;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.trim().isEmpty()){
            return true;
        }
        char[] array = s.toLowerCase().toCharArray();
        int size = array.length;
        int p1 = 0;
        int p2 = size - 1;
        while (p1 < p2) {
            while (p1 < p2 && notAlphabet(array[p1])) p1++;
            while (p1 < p2 && notAlphabet(array[p2])) p2--;

            if (p1 < p2 && array[p1] != array[p2]) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    private boolean notAlphabet(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c);
    }
}
