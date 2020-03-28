package com.yy.leetcode.twopointers;

/**
 * @author youyouhuang
 * @create 2020-03-28
 * @desc https://leetcode-cn.com/problems/implement-strstr/
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 **/

public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        int pos = -1;
        int length = haystack.length();
        for (int i = 0; i < length; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                pos = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (i == length || haystack.charAt(i) != needle.charAt(j)) {
                        i=pos;
                        pos = -1;
                        break;
                    }
                    i++;
                }
            }
            if (pos >= 0) {
                break;
            }
        }
        return pos;
    }
}
