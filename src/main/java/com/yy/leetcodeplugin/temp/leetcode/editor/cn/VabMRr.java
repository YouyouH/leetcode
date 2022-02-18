//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
//string/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 11 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-13 20:58:05
//字符串中的所有变位词

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VabMRr{
    public static void main(String[] args) {
         Solution solution = new VabMRr().new Solution();
//        solution.findAnagrams("cbaebabacd", "abc");
        solution.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //滑动窗口
        //用两个array分别表示窗口内的字符数量和p的字符数量
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] arrayP = new int[26];
        int[] arrayS = new int[26];

        char[] charsP = p.toCharArray();
        char[] charsS = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            arrayP[charsP[i] - 'a']++;
            arrayS[charsS[i] - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(arrayP, arrayS)) {
            res.add(0);
        }
        int lo = 0;
        int hi = p.length() - 1;
        while (hi < s.length()) {
            arrayS[charsS[lo] - 'a']--;
            //窗口前移一位
            lo++;
            hi++;
            if (hi < s.length()) {
                arrayS[charsS[hi] - 'a']++;
                if (Arrays.equals(arrayP, arrayS)) {
                    res.add(lo);
                }
            } else {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}