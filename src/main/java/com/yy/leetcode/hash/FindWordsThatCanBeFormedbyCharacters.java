package com.yy.leetcode.hash;
/**
 * @author youyouhuang
 * @create 2020-04-20
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * <p>
 *
 * </p>
 **/
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0) {
            return 0;
        }
        char[] charArray = chars.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.merge(c, 1, Integer::sum);
        }

        int count = 0;

        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                wordMap.merge(c, 1, Integer::sum);
            }
            boolean skip = false;
            for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
                Character key = entry.getKey();
                Integer showTime = entry.getValue();
                if (map.get(key) == null || map.get(key) < showTime) {
                    skip = true;
                    break;
                }
            }
            if(!skip) {
                count += word.length();
            }
        }
        return count;
    }
}
