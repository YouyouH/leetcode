
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-20 21:25:31 
//两个字符串的最小ASCII删除和

public class MinimumAsciiDeleteSumForTwoStrings{
    public static void main(String[] args) {
         Solution solution = new MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        /**
         * 删除的字符串最小那么相等的字符串要最大，转换为求最大公共子串问题
         *     但是这题还要知道子串是什么（或者子串大小），这样才知道删除那个字符
         *
         *     FIXME 直接把dp定义改成最大子串的ASCII值
         */
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];


        for (int i = 1; i < l1 + 1; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j < l2 + 1; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] +c1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int s1Value = 0;
        for (int i = 0; i < l1; i++) {
            s1Value += s1.charAt(i);
        }

        int s2Value = 0;
        for (int i = 0; i < l2; i++) {
            s2Value += s2.charAt(i);
        }

        System.out.println("s1Value=" + s1Value);
        System.out.println("s2Value=" + s2Value);
        System.out.println("dp=" + dp[l1][l2]);

        return s1Value + s2Value - dp[l1][l2] * 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 412 👎 0
