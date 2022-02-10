  //给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 25 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-08 15:36:46 
//字符串中的变位词

  import java.util.Arrays;
  import java.util.HashMap;
  import java.util.Map;

  public class MPnaiL{
    public static void main(String[] args) {
         Solution solution = new MPnaiL().new Solution();
        solution.checkInclusion("adc", "dcda");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //滑动窗口
        //把问题转化为s2的子串和s1有相同的字符
        //用一个hashmap表示s1的字符和出现的数量
        //对s2用滑动窗口法，这个窗口的大小是固定的，如果窗口内不符合要求则窗口整体前进一位
        //怎么表示窗口内的字串和S1是不是一样的？？？
        //  方法一：排序之后转换成string表示？ 不好
        //  方法二: 用两个长度26的数组表示，然后用Arrays.equals判断这两个数组是否相等
        //  方法三: 在方法二的基础上，不要每次都全量比较两个数组，而是用diff来表示差异，diff为0则相同
        if (s2.length() < s1.length()) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        int s1Length = s1Chars.length;
        int[] characters = new int[26];
        //存每个字符出现的次数
        for (char s1Char : s1Chars) {
            characters[s1Char - 'a']++;
        }


        //滑动窗口判断S2
        int lo = 0;
        int hi = s1Length - 1;
        char[] s2Chars = s2.toCharArray();
        int[] characters2 = new int[26];
        for (int i = 0; i <= hi; i++) {
            characters2[s2Chars[i] - 'a']++;
        }
        if (Arrays.equals(characters, characters2)) {
            return true;
        }

        while (++hi < s2.length()) {
            characters2[s2Chars[lo] - 'a']--;
            lo++;
            characters2[s2Chars[hi] - 'a']++;
            if (Arrays.equals(characters, characters2)) {
                return true;
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}