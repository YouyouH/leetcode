
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-10 10:17:26 
//括号的分数

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses{
    public static void main(String[] args) {
         Solution solution = new ScoreOfParentheses().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        /**
         * FIXME 看的答案
         */
        int score = 0;

        char[] array = s.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);//最开始塞了一个0

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '(') {
                stack.push(0);
            }else{
                Integer pop = stack.pop();
                int pre = stack.pop();//pre 是前面的得分.最开始放了一个0所以这里pop不会出现空的情况
                if (pop == 0) {//pop等于0表示前面是一个左括号，所以得一分
                    stack.push(pre+1);//当前得分是1，pre 是前面的得分。两者要加起来。
                }else{
                    stack.push(pre + pop * 2);
                }
            }
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 536 👎 0
