package com.yy.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-04-01
 * @desc https://leetcode-cn.com/problems/generate-parentheses/
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 **/

/**
 * 画树形结构图
 * Generate Parentheses {@link GenerateParentheses.png}
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        int left = n-1;
        int right = n;

        StringBuilder builder = new StringBuilder();
        builder.append('(');
        dfs(builder,result,left,right);
        return result;
    }

    private void dfs(StringBuilder builder, List<String> result, int left, int right) {
        //剩余的左括号如果大于右括号则肯定无效
        if(left > right){
            return;
        }else if(right == 0 && left == 0){
            result.add(builder.toString());
            return;
        }

        if(left > 0){
            builder.append('(');
            dfs(builder,result,left-1,right);
            builder.deleteCharAt(builder.length()-1);
        }
        if(right > 0){
            builder.append(')');
            dfs(builder,result,left,right-1);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
