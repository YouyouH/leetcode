package com.yy.leetcode.array;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];
        int[] array2 = new int[26];
        int length = s.length();
        char[] schars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            int pos = schars[i] - 'a';
            array[pos] += 1;
        }

        char[] achars = t.toCharArray();
        for (int i = 0; i < length+1; i++) {
            int pos = achars[i] - 'a';
            array2[pos] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if(array2[i] - array[i] == 1){
                return (char)('a' + i);
            }
        }
        return 0;
    }
}
