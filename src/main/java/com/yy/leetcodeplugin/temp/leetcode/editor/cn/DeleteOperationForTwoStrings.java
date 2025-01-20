
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-20 21:19:22 
//两个字符串的删除操作

public class DeleteOperationForTwoStrings{
    public static void main(String[] args) {
         Solution solution = new DeleteOperationForTwoStrings().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        /**
         * 跟最长公共子串一样，求出之后用总长度减去公共的长度是步数
         */

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for (int i = 1; i < l1+1; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j < l2+1; j++) {
                char c2 = word2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);//两种情况取最大值
                }
            }
        }

        return l1 + l2 - 2 * dp[l1][l2];
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定两个单词 word1 和
// word2 ，返回使得
// word1 和 
// word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
//
// Related Topics 字符串 动态规划 👍 713 👎 0
