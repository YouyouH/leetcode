//给你一个字符串 s，找到 s 中最长的 回文 子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7462 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-23 16:29:34 
//最长回文子串

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("b"));
        System.out.println(solution.longestPalindrome("cb"));
        System.out.println(solution.longestPalindrome("aaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {

        int max = 0;
        String maxString = null;

        public String longestPalindrome(String s) {
            /**
             * 穷举：
             * 遍历所有子串，然后针对每一个子串判断是不是回文子串
             *
             * 如何遍历所有子串：
             *      1. 双层循环，外圈循环表示起始位置，内圈循环表示长度
             *
             * 下面代码写错了，穷举递归很难写，直接双循环遍历，时间复杂度：双层循环n平方。每个子串遍历一遍判断是不是回文，n, 一共n的三次方
             *
             */

            subString(s);

            return maxString;

        }

        private boolean subString(String s) {

            if (s.length() == 1) {
                return true;
            }

            if (s.length() == 2) {
                if (s.charAt(0) == s.charAt(1)) {
                    return true;
                } else {
                    return false;
                }
            }


            boolean result = true;
            for (int i = 0; i < s.length(); i++) {//i表示首字母下标
                //从最外面往里收缩, j表示长度

                for (int j = s.length() - i; j >= 3; j--) {//只有字符串长度大于3的才需要继续递归判断
                    //起始字母是s[i],末尾字母是s[i+j-1]
                    if (s.charAt(i) == s.charAt(i + j - 1)) {
                        result = result && subString(s.substring(i + 1, i + j - 1));//区间是左闭右开
                    } else {
                        result = false;
                    }
                    //如果不是就缩小子串长度
                    if (result) {
                        if (max < j) {
                            max = j;
                            maxString = s.substring(i, i + j - 1);
                        }
                        break; //因为字符串长度是从大到小检查，所以匹配到一个就可以退出了，从下一个首字母开始继续检查
                    }

                }
            }
            return result;
        }


    }

    class Solution {


        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            /**
             *
             * 动态规划：
             *      状态转移方程：
             *          i表示起始位置，j表示子串长度
             *          dp[i][j] = dp[i-1][j+2] && s[i] == s[i+j-1]
             *          dp[i][j] = dp[i+1][j-2]  && s[i] == s[i+j-1]
             *
             * 下面情况可以遍历字符串快速判断出来：
             *      dp[i][1]
             *      dp[i][2]
             *      dp[i][3]
             *  所以采用第二个状态转移方程。例如
             *  (dp[3][6]) = dp[4][4] && s[3]==s[9]) = (dp[5][2])
             *  (dp[3][7]) = dp[4][5] && s[3]==s[9]) = (dp[5][3])
             */

            boolean[][] dp = new boolean[s.length()][s.length() + 1];

            String max = "";

            for (int i = 0; i < s.length(); i++) {
                dp[i][0] = false;
                dp[i][1] = true;
                if (max.length() < 1) {
                    max = s.substring(i, i + 1);
                }

                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][2] = true;
                    if (max.length() < 2) {
                        max = s.substring(i, i + 2);
                    }
                } else {
                    dp[i][2] = false;
                }

                if (s.length() >2 && i + 2 < s.length() && s.charAt(i) == s.charAt(i + 2)) {
                    dp[i][3] = true;
                    if (max.length() < 3) {
                        max = s.substring(i, i + 3);
                    }
                } else if(s.length() >2) {
                    dp[i][3] = false;
                }
            }

            /**
             * 这里要思考两层循环的顺序，不要随便写。使用动态规划，需要从子问题入手，再根据状态转移方程推导其他情况。
             * 这里子问题应该是最短的字符串，然后再推导出更长的字符串。所以内层循环应该是子串长度不变，遍历首字母。先解决所有子串长度为2的再扩展到长度为3的。
             * 一开始没有思考，在内层循环处理子串长度，后面推导不出来了。
             */
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = 3; j <= s.length() - i; j++) {
//                    if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + j - 1)) {
//                        dp[i][j] = dp[i + 1][j - 2];
//                    } else {
//                        dp[i][j] = false;
//                    }
//
//                }
//            }


            for (int j = 3; j <= s.length(); j++) {//子串长度
                for (int i = 0; i < s.length(); i++) {//首字符位置
                    //子串首字符索引i, 子串末尾字符索引 i+j-1
                    if (i + 1 < s.length() && i + j - 1 < s.length() && s.charAt(i) == s.charAt(i + j - 1)) {
                        dp[i][j] = dp[i + 1][j - 2];
                    } else {
                        dp[i][j] = false;
                    }
                    if (dp[i][j] && j > max.length()) {
                        max = s.substring(i, i + j);
                    }
                }
            }
            return max;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}