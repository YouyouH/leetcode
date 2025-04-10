
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-09 22:50:47 
//反转每对括号间的子串

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseSubstringsBetweenEachPairOfParentheses{
    public static void main(String[] args) {
         Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseParentheses(String s) {
        /**
         * FIXME 看的答案
         * 遇到左括号就把当前字符串入栈，遇到右括号就把当前字符串反转然后和栈顶的连起来
         */
        Deque<String> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            //两个左括号之间作为一层，每遇到一层就进栈
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
                //清空sb
            } else if (c == ')') {//遇到右括号就反转当前层字符串，再和栈顶的连起来作为新的一层
                sb.reverse();
                sb.insert(0, stack.pop());//把栈顶字符串加在前面
            }else{
                sb.append(c);//遇到字母就添加到sb
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 
//输入：s = "(u(love)i)"
//输出："iloveu"
//解释：先反转子字符串 "love" ，然后反转整个字符串。 
//
// 示例 3： 
//
// 
//输入：s = "(ed(et(oc))el)"
//输出："leetcode"
//解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 题目测试用例确保所有括号都是成对出现的 
// 
//
// Related Topics 栈 字符串 👍 302 👎 0
