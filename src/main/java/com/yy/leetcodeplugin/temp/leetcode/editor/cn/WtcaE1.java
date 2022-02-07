//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// 
//
// 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 19 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-07 13:50:51
//不含重复字符的最长子字符串

import java.util.HashSet;
import java.util.Set;

public class WtcaE1{
    public static void main(String[] args) {
         Solution solution = new WtcaE1().new Solution();
        solution.lengthOfLongestSubstring("tmmzuxt");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口，两个指针一前一后，后面的指针一直往前移动，直到遇到有重复的字符，此时前面的指针往前移动
        char[] chars = s.toCharArray();

        if (chars.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;

        int max = 0;

        Set<Character> set = new HashSet<>();
        //eg. tmmzuxt
        while (fast < chars.length) {
            if (set.contains(chars[fast])) {
                //如果字符出现过，则slow指针往前走,直到遇到这个字符并且移动到下一个位置.用slow++ 保证最后slow移动到下一个位置
                while (chars[slow] != chars[fast]){
                    //把遇到的字符串都删掉
                    set.remove(chars[slow]);
                    slow++;
                }
                slow++;
                max = Math.max(max, fast - slow + 1);
                fast++;
            } else {
                //如果没有出现过，就把新字符添加进集合，并且fast指针往前移动
                set.add(chars[fast]);
                max = Math.max(max, fast - slow + 1);
                fast++;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}