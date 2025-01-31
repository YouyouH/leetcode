
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-31 12:21:55 
//分割回文串 II

public class PalindromePartitioningIi{
    public static void main(String[] args) {
         Solution solution = new PalindromePartitioningIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        /**
         * 最少分割次数，就是求最少回文子串
         * dp[i]表示以s[i]结尾的最少回文子串数量
         *
         * FIXME: 可以加一个预处理提前统计出每个子串是不是回文
         */
        int length = s.length();

        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            if (isPalindrome(s, 0, i)) {//判断是否需要分割
                dp[i] = 1;
                continue;//已经取得最小值
            }else{
                dp[i] = i+1; //最大值，即分成一个一个的字符。后面再求更小的值
            }
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[length - 1] - 1;
    }

            boolean isPalindrome(String s, int start, int end) {
                while (start <= end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        return false;
                    }
                    start++;
                    end--;
                }
                return true;
            }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 779 👎 0
