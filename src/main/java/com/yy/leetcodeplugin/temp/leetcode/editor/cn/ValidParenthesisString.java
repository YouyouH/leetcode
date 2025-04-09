
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-09 10:02:12 
//有效的括号字符串

public class ValidParenthesisString{
    public static void main(String[] args) {
         Solution solution = new ValidParenthesisString().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        boolean res1 = true;
        boolean res2 = true;
        int left = 0;
        int right = 0;
        int star = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            } else {
                star++;
            }

            if (right > left) {//需要使用star补充left
                if (star > 0) {
                    star--;
                    right--;//消耗一个start,抵消一个right
                }else{
                    res1 = false;
                    break;
                }
            }
        }



        //从后往前再检查一遍,处理这种情况 "((((*))"
        left = 0;
        right = 0;
        star = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            char c = array[i];
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            } else {
                star++;
            }

            if (left > right) {//需要使用star补充right
                if (star > 0) {
                    star--;
                    left--;//消耗一个start,抵消一个left
                } else {
                    res2 = false;
                    break;
                }
            }
        }


        return res1 && res2;//FIXME: 开始写的是 || 的关系，看了答案改成 &&， 正反计算一遍确保start足够就可以
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是 有效 字符串返回 true 。
// 
//
// 有效 字符串符合如下规则： 
//
// 
// 任何左括号 '(' 必须有相应的右括号 ')'。 
// 任何右括号 ')' 必须有相应的左括号 '(' 。 
// 左括号 '(' 必须在对应的右括号之前 ')'。 
// '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串 ""。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "(*)"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(*))"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 为 '('、')' 或 '*' 
// 
//
// Related Topics 栈 贪心 字符串 动态规划 👍 658 👎 0
