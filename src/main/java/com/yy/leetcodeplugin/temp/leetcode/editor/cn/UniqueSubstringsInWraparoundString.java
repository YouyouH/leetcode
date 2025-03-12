
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-11 16:58:22 
//环绕字符串中唯一的子字符串

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsInWraparoundString{
    public static void main(String[] args) {
         Solution solution = new UniqueSubstringsInWraparoundString().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSubstringInWraproundString(String s) {
        /**
         * 滑动窗口
         * FIXME: 要去除重复的子串
         *  怎么去除重复子串？
         *      不需要用map记录每个子串，
         *      记录以每个字母结尾的子串的最大长度即可。长度更短的子串肯定会被更长的子串覆盖。
         *      最后再把每个字母的结果加起来
         *      如何判断 z 和 a是连着的？
         *      (s(r) - s(r-1) + 26) % 26 == 1, 对于z和a, (0-25 + 26) % 26
         *
         */
        int length = s.length();

        int[] dp = new int[26];

        int size = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                size++;
            }else{
               size = 1;
           }
            dp[s.charAt(i) - 'a'] = Math.max(dp[s.charAt(i) - 'a'], size);
//            System.out.println(s.charAt(i) + "=" + dp[s.charAt(i) - 'a']);
        }
        return Arrays.stream(dp).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //定义字符串 base 为一个 "abcdefghijklmnopqrstuvwxyz" 无限环绕的字符串，所以 base 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
// 
//
// 给你一个字符串 s ，请你统计并返回 s 中有多少 不同非空子串 也在 base 中出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a"
//输出：1
//解释：字符串 s 的子字符串 "a" 在 base 中出现。
// 
//
// 示例 2： 
//
// 
//输入：s = "cac"
//输出：2
//解释：字符串 s 有两个子字符串 ("a", "c") 在 base 中出现。
// 
//
// 示例 3： 
//
// 
//输入：s = "zab"
//输出：6
//解释：字符串 s 有六个子字符串 ("z", "a", "b", "za", "ab", and "zab") 在 base 中出现。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 432 👎 0
