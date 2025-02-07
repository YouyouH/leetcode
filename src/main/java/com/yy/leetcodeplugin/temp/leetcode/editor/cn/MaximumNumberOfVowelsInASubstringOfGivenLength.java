
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-06 17:53:26 
//定长子串中元音的最大数目

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength{
    public static void main(String[] args) {
         Solution solution = new MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        /**
         * 滑动窗口
         */

        int l = 0;
        int r = k-1;

        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');

        int res = 0;

        //初始化
        while (--k >= 0) {
            if (characters.contains(s.charAt(k))) {
                res++;
            }
        }
//        System.out.println("1: "+res);
        int max = res;

        l++;
        r++;
        while (r < s.length()) {
            if (characters.contains(s.charAt(r))) {
                res++;
            }

            //右移动的时候左边界可能要先减一个
            if (characters.contains(s.charAt(l - 1))) {
                res--;
            }
//            System.out.println("l=" + l + " r=" + r + " res=" + res);
            max = Math.max(max, res);
            l++;
            r++;
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你字符串 s 和整数 k 。 
//
// 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。 
//
// 英文中的 元音字母 为（a, e, i, o, u）。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abciiidef", k = 3
//输出：3
//解释：子字符串 "iii" 包含 3 个元音字母。
// 
//
// 示例 2： 
//
// 输入：s = "aeiou", k = 2
//输出：2
//解释：任意长度为 2 的子字符串都包含 2 个元音字母。
// 
//
// 示例 3： 
//
// 输入：s = "leetcode", k = 3
//输出：2
//解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
// 
//
// 示例 4： 
//
// 输入：s = "rhythms", k = 4
//输出：0
//解释：字符串 s 中不含任何元音字母。
// 
//
// 示例 5： 
//
// 输入：s = "tryhard", k = 4
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 由小写英文字母组成 
// 1 <= k <= s.length 
// 
//
// Related Topics 字符串 滑动窗口 👍 144 👎 0
