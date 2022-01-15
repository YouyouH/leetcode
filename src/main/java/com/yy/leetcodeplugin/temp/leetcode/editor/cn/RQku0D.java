//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 👍 19 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-15 17:41:47
//最多删除一个字符得到回文

public class RQku0D{
    public static void main(String[] args) {
         Solution solution = new RQku0D().new Solution();
        solution.validPalindrome("cbbcc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        //一个一个的尝试
        //用双指针判断是不是回文子串
        //上面的方法超时！！！！！！！！！！！！！！！！！！！！！！！！！

        //不需要一个一个的尝试，直接判断是不是回文，并且只能有一次不相等的情况
        //遍历两次，第一次跳过左边的数，第二次跳过右边的数
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        int error = 0;

        boolean flag = true;

        while (left < right) {

            if (chars[left] != chars[right]) {
                error++;
                if (error > 1) {
                    flag = false;
                    break;
                }
                left++;
                continue;
            }
            left++;
            right--;
        }

        if(flag) return true;


        left = 0;
        right = chars.length - 1;
        error = 0;
        while (left < right) {

            if (chars[left] != chars[right]) {
                error++;
                if (error > 1) {
                    return false;
                }
                right--;
                continue;
            }
            left++;
            right--;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}