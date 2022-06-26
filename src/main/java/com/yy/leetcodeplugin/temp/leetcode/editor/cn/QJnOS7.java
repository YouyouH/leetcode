  //给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// 
//
// 注意：本题与主站 1143 题相同： https://leetcode-cn.com/problems/longest-common-
//subsequence/ 
// Related Topics 字符串 动态规划 👍 75 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-06-26 17:22:03 
//最长公共子序列

public class QJnOS7{
    public static void main(String[] args) {
         Solution solution = new QJnOS7().new Solution();
        solution.longestCommonSubsequence("ezupkr", "ubmrapg");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 思路：参考 dp_on_strings.md
         * dp[i][j]表示分别以索引 i 和 j 结尾的最长公共子序列长度
         *
         * 思考dp[i][j] 和 dp[i-1][j-1], dp[i][j-1], dp[i-1][j]的关系
         *
         */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int length1 = text1.length();
        int length2 = text2.length();

        /**
         * 这里为什么要处理成new int[length1 + 1][length2 + 1]？
         *     因为index表示为字串长度，而不是索引，方便处理字串长度为1的情况
         */
        int[][] dp = new int[length1 + 1][length2 + 1];

//        dp[1][1] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;

//        if (length2 > 1) {
//            if (text1.charAt(0) == text2.charAt(0) || text1.charAt(0) == text2.charAt(1)) {
//                dp[0][1] = 1;
//            }
//        }
//
//        if (length1 > 1) {
//            if (text1.charAt(1) == text2.charAt(0) || text1.charAt(0) == text2.charAt(0)) {
//                dp[1][0] = 1;
//            }
//        }

        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                //字符串最后一个相等， dp[i][j] = dp[i - 1][j - 1];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[length1][length2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}