
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-21 17:18:23 
//编辑距离

import java.util.Arrays;

public class EditDistance{
    public static void main(String[] args) {
         Solution solution = new EditDistance().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        /**
         * 对每一个字符有三种选择，保留，删除，替换
         * FIXME
         *      当前字符 相等，保留当前字符不用操作 dp[i][j] =dp[i-1][j-1]
         *      当前字符 不相等，思考这三种情况：
         *          dp[i-1][j],dp[i-1][j-1],dp[i][j-1]
         *              替换word1当前字符 dp[i-1][j-1] + 1
         *              插入word1当前字符 dp[i][j-1] + 1
         *              删除word1当前字符 dp[i-1][j] + 1
         *              三种情况取最小值
         */

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        //初始化
        for (int i = 0; i < l1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < l2 + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < l1 + 1; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j < l2 + 1; j++) {
                char c2 = word2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    //替换
                    int a = dp[i - 1][j - 1] + 1;
                    //删除
                    int b = dp[i - 1][j] + 1;
                    //增加
                    int c = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(a, Math.min(b, c));
                }
            }
        }
        return dp[l1][l2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3570 👎 0
