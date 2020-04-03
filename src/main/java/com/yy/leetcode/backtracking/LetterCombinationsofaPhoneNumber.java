package com.yy.leetcode.backtracking;

import java.util.*;

/**
 * @author youyouhuang
 * @create 2020-04-01
 * @desc https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 *
 * 先构造多叉树
 */
public class LetterCombinationsofaPhoneNumber {
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null){
            return result;
        }
        Map<Character,List<Character>> phone = new HashMap<>();
        phone.put('2', Arrays.asList('a','b','c'));
        phone.put('3', Arrays.asList('d','e','f'));
        phone.put('4', Arrays.asList('g','h','i'));
        phone.put('5', Arrays.asList('j','k','l'));
        phone.put('6', Arrays.asList('m','n','o'));
        phone.put('7', Arrays.asList('p','q','r','s'));
        phone.put('8', Arrays.asList('t','u','v'));
        phone.put('9', Arrays.asList('w','x','y','z'));

        dfs(digits,0, new StringBuilder(),result,phone);
        return result;
    }

    private void dfs(String digits, int i, StringBuilder builder, List<String> result, Map<Character, List<Character>> phone) {
        if(i == digits.length()){
            if(builder.length() != 0) {
                result.add(builder.toString());
            }
            return;
        }
        char number = digits.charAt(i);
        for (int j = 0; j < phone.get(number).size(); j++) {
            builder.append(phone.get(number).get(j));
            dfs(digits,i+1,builder,result,phone);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
