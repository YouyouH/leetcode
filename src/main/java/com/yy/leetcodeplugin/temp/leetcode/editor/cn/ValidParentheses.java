
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-08 21:41:21 
//有效的括号

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses{
    public static void main(String[] args) {
         Solution solution = new ValidParentheses().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == ')' || c == '}' || c == ']') {
                if (queue.isEmpty()) {
                    return false;
                }
                char pop = queue.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
            }else{
                queue.push(c);
            }
        }
        return queue.isEmpty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4690 👎 0
