  //正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
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
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 19 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-27 19:18:48 
//生成匹配的括号

  import java.util.ArrayList;
  import java.util.List;

  public class IDBivT{
    public static void main(String[] args) {
         Solution solution = new IDBivT().new Solution();
        solution.generateParenthesis(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            //思路：剩余左括号大于右括号，任选
            //      左括号等于右括号，选左括号
            //      左括号小于右括号，失败
            generate(n, n,"");
            return res;

        }

        private void generate(int left, int right,String tmp) {
            if (left == 0 && right == 0) {
                res.add(tmp);
                return;
            }
            if (left > right) {
                return;
            }
            if (left < 0 || right < 0) {
                return;
            }
            //选择
            if (left == right) {
                generate(left - 1, right, tmp+"(");
            } else {
                //两个选择
                //先选左
                generate(left-1, right, tmp+"(");
                //再选右
                generate(left, right-1, tmp+")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}