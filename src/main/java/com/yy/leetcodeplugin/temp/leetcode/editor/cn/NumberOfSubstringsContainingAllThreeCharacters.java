
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-12 21:14:48 
//包含所有三种字符的子字符串数目

public class NumberOfSubstringsContainingAllThreeCharacters{
    public static void main(String[] args) {
         Solution solution = new NumberOfSubstringsContainingAllThreeCharacters().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSubstrings(String s) {
        int length = s.length();
        char[] array = s.toCharArray();//FIXME: 转换成char arry要快很多
        int l = 0;
        int[] count = new int[3];
        int res = 0;

        for (int r = 0; r < length; r++) {
            int i = array[r] - 'a';
            if (i >= 0 && i <= 2) {
                count[i]++;
            }
            while ((count[0] > 0) && (count[1] > 0) && (count[2] > 0)) {
                res += length - r;
                int j = array[l] - 'a';
                if (j >= 0 && j <= 2) {
                    count[j]--;
                }
                l++;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个字符串 s ，它只包含三种字符 a, b 和 c 。 
//
// 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcabc"
//输出：10
//解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", 
//"bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
// 
//
// 示例 2： 
//
// 输入：s = "aaacb"
//输出：3
//解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
// 
//
// 示例 3： 
//
// 输入：s = "abc"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 5 x 10^4 
// s 只包含字符 a，b 和 c 。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 133 👎 0
