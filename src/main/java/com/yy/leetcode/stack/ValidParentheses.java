package com.yy.leetcode.stack;

import java.util.*;

/**
 * @author youyouhuang
 * @create 2020-04-01
 * @desc https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 **/

public class ValidParentheses {

    public boolean isValid(String s) {
        if(null == s){
            return false;
        }
        if(s.trim().isEmpty()){
            return true;
        }
        Map<Character, Character> characterMap = new HashMap();
        characterMap.put(')','(');
        characterMap.put('}','{');
        characterMap.put(']','[');

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(characterMap.containsValue(ch)) {
                stack.push(ch);
            }else if(characterMap.get(ch).equals(stack.peek())){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

}
