package com.yy.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * <p>ad
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 */
public class ReverseVowelsOfAString {

    //双指针以相向而行
    public String reverseVowels(String s) {
        if (null == s) {
            return s;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;
        while (p1 <= p2 && p1 < chars.length && p2 >= 0) {
            while (p1 <= p2 && !vowels.contains(chars[p1])) {
                p1++;
            }
            while (p1 <= p2 && !vowels.contains(chars[p2])) {
                p2--;
            }
            if (p1 >= p2) break;
            char temp = chars[p1];
            chars[p1] = chars[p2];
            chars[p2] = temp;
            p1++;
            p2--;
        }
        return new String(chars);
    }

}
