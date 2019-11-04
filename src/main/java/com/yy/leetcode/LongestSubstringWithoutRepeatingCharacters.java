package com.yy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youyouhuang
 * @create 2019-11-02
 * @desc https://leetcode.com/problems/longest-substring-without-repeating-characters/
 **/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < length;i++) {
            for (int j = i; j < length; j++) {
                char c = s.charAt(j);
                if(null != map.putIfAbsent(c,j)){
                    int tmp = j-i;
                    if(tmp>=max){
                        max = tmp;
                    }
                    map.clear();
                    break;
                }
                if(j == length-1){
                    int l = length-i;
                    if(l>max){
                        max = l;
                    }
                }
            }
        }
        if(0 == max){
            return length;
        }
        return max;
    }
}
