
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-24 22:03:29 
//括号生成

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
         Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        /**
         * 穷举
         *    n个左括号和n个右括号,得到所有组合,然后对每一个组合判断是不是有效的
         *           怎么得到所有组合？
         *          怎么判断是不是有效的:
         *              1. 第一个必须是左括号,最后一个必须是右括号
         *              2.遇到左括号就+1,遇到反括号就-1,如果为负数就说明无效.
         */
        List<String> result = new ArrayList<>();
        generate(n, n, new StringBuilder(),result);
        return result;

    }

        //深度遍历
        private void generate(int left, int right, StringBuilder sb, List<String> result) {
            if (left < 0 || right < 0) {
                return;
            }

            if (left == 0 && right == 0) {
                if (sb.charAt(0) != '(') {
                    return;
                }
                if (validate(sb)) {
                    result.add(sb.toString());
                }

                return;
            }

            if (left > 0) {
                sb.append('(');
                generate(left-1, right, sb, result);//这里不能用--left,否则会导致left的值变了,下面生成右括号的时候left数量就不对了
                sb.deleteCharAt(sb.length() - 1);
            }

            if (right > 0) {
                sb.append(')');
                generate(left, right-1, sb, result);//这里不能用--right,否则会导致right的值变了
                sb.deleteCharAt(sb.length() - 1);
            }

        }

        private boolean validate(StringBuilder stringBuilder) {
            int val = 0;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '(') {
                    val++;
                }
                if (stringBuilder.charAt(i) == ')') {
                    val--;
                    if (val < 0) {
                        return false;
                    }
                }
            }
            return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}

  //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3744 👎 0
