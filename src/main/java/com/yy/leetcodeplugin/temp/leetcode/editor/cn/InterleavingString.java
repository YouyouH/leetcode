
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-22 17:00:02 
//交错字符串

public class InterleavingString{
    public static void main(String[] args) {
         Solution solution = new InterleavingString().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        /**
         * FIXME
             dp[i][j] 表示s1前i个字符 和 s2前j个字符，能否组成s3 前 i+j 个字符
         *  当前字符相等
         *      （s1的第i个字符等于s3第i+j个字符）
         *          =dp[i-1][j]
         *      （s2的第j个字符等于s3第i+j个字符）
         *          =dp[i][j-1]
         *  当前字符不等
         *      dp[i][j] = false
         */
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 + l2 != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        //初始化
        dp[0][0] = true;
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        }

        for (int i = 1; i < l2 + 1; i++) {
            dp[0][i] = dp[0][i-1] && s3.charAt(i - 1) == s2.charAt(i - 1);
        }


        for (int i = 1; i < l1 + 1; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j < l2 + 1; j++) {
                char c2 = s2.charAt(j-1);
                char c3 = s3.charAt(i + j - 1);
                if (c1 == c3) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (c2 == c3) {
                    dp[i][j] = dp[i][j] || dp[i][j-1]; //FIXME 这里要注意dp[i][j]在上面是true
                }
                //其他情况是false
            }
        }
        return dp[l1][l2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 注意：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
// 
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它? 
//
// Related Topics 字符串 动态规划 👍 1072 👎 0
