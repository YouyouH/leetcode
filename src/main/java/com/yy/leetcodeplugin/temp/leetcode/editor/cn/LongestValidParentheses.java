
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-08 21:55:56 
//最长有效括号

public class LongestValidParentheses{
    public static void main(String[] args) {
         Solution solution = new LongestValidParentheses().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        /**
         * FIXME 看的答案
         */
        int max = 0;
        int res = 0;

        int left = 0;
        int right = 0;
        char[] array = s.toCharArray();

        //从左往右遍历
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '(') {
                left++;
            }else{
                right++;
            }
            if (right > left) {//遇到不符合条件的，重新开始计数
                left = 0;
                right = 0;
                max = 0;
            } else if (right == left) {
                max = right * 2;
//                System.out.println("max1=" + max);
                res = Math.max(res, max);
            }
        }

        max = 0;
        left = 0;
        right = 0;
        //从右往左遍历
        for (int i = array.length-1; i >=0; i--) {
            char c = array[i];
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (right < left) {//遇到不符合条件的，重新开始计数
                left = 0;
                right = 0;
                max = 0;
            } else if (right == left) {
                max = Math.max(max, right * 2);
//                System.out.println("max2=" + max);
                res = Math.max(res, max);
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2677 👎 0
