//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 👍 13 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-03 19:35:02
//有效的回文

public class XltzEq{
    public static void main(String[] args) {
         Solution solution = new XltzEq().new Solution();
//        solution.isPalindrome("A man, a plan, a canal: Panama");
        solution.isPalindrome("0P");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //两个指针，一前一后，遇到空格就移动
        int length = s.length();
        char[] chars = s.toLowerCase().toCharArray();
        int l = 0;
        int r = length - 1;
        while (l < r) {
            while (l < r && !Character.isAlphabetic(chars[l]) && !Character.isDigit(chars[l])) l++;
            while (l < r && !Character.isAlphabetic(chars[r]) && !Character.isDigit(chars[r])) r--;

            if (l < r && chars[l] != chars[r]) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}