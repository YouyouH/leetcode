
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-09 21:44:56 
//最小覆盖子串

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
         Solution solution = new MinimumWindowSubstring().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        /**
         * 滑动窗口。
         *      怎么统计是否覆盖了？用两个数组
         */

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";

        int l = 0;
        int r = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            //先填充窗口，右边界扩张
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while ((r - l + 1) >= t.length() && window(map,charMap)) {
                if (res.isEmpty()) {
                    res = s.substring(l, r + 1);
                } else {
                    if (r - l + 1 < res.length()) {
                        res = s.substring(l, r + 1);
                    }
                }
                //左边界收缩
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return res;
    }

    private boolean window(Map<Character, Integer> map, Map<Character, Integer> charMap) {
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            Character key = entry.getKey();
            if (!map.containsKey(key) || map.get(key) < (entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3171 👎 0
