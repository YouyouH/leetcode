
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-08 22:39:20 
//使括号有效的最少添加

public class MinimumAddToMakeParenthesesValid{
    public static void main(String[] args) {
         Solution solution = new MinimumAddToMakeParenthesesValid().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAddToMakeValid(String s) {
        /**
         * 不能只计算左右括号数量差，数量一致但是摆放方式不对也不是有效字符串
         */
        int count = 0;
        int left = 0;
        int right = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '(') {
                left++;
            }else {
                right++;
            }
            if (right > left) {
                count += 1;
                right--;
            }
        }
        count += left - right;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //只有满足下面几点之一，括号字符串才是有效的： 
//
// 
// 它是一个空字符串，或者 
// 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者 
// 它可以被写作 (A)，其中 A 是有效字符串。 
// 
//
// 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号 
//
// 
// 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。 
// 
//
// 返回 为使结果字符串 s 有效而必须添加的最少括号数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "())"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s = "((("
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含 '(' 和 ')' 字符。 
// 
//
// Related Topics 栈 贪心 字符串 👍 270 👎 0
