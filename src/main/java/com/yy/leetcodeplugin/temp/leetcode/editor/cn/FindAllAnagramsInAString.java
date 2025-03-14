
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-07 17:26:36 
//找到字符串中所有字母异位词

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString{
    public static void main(String[] args) {
         Solution solution = new FindAllAnagramsInAString().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public List<Integer> findAnagrams(String s, String p) {
                if (s.length() < p.length()) {
                    return new ArrayList<>();
                }
                //把p保存在map里，key是字母，value是出现的次数
                //用固定长度的滑动窗口遍历s
                Map<Character, Integer> pmap = new HashMap<>();
                char[] pchars = p.toCharArray();
                for (int i = 0; i < pchars.length; i++) {
                    pmap.put(pchars[i], pmap.getOrDefault(pchars[i], 0) + 1);
                }

                //固定窗口
                int l = 0;
                int r = 0;
                char[] schars = s.toCharArray();
                Map<Character, Integer> count = new HashMap<>();

                //填充固定窗口
                while (r - l + 1 <= p.length()) {
                    count.put(schars[r], count.getOrDefault(schars[r], 0) + 1);
                    r++;
                }
                //此时r指向窗口的下一个字符,重新让它指向窗口末尾
                r = p.length() - 1;

                List<Integer> res = new ArrayList<>();
                while (r < s.length()) {
//                    System.out.println("l=" + l + " r=" + r);
//                    System.out.println(print(count));
                    if (find(count, pmap)) {
                        res.add(l);
                    }
                    if (r == s.length() - 1) {
                        break;
                    }
                    //窗口整体前进
                    count.put(schars[l], count.get(schars[l]) - 1);
                    l++;
                    r++;
                    count.put(schars[r], count.getOrDefault(schars[r], 0) + 1);
                }

                return res;

            }

            private boolean find(Map<Character, Integer> count, Map<Character, Integer> pmap) {
                //count中的所有字符都要在p中出现并且次数相等
                for (Map.Entry<Character, Integer> entry : count.entrySet()) {
                    Character c = entry.getKey();
                    if(count.get(c) == 0) continue;

                    if (!pmap.containsKey(c) || !pmap.get(c).equals(entry.getValue())) {
                        return false;
                    }
                }
                return true;
            }

            private String print(Map<Character, Integer> count) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<Character, Integer> entry : count.entrySet()) {
                    sb.append(entry.getKey() + "=" + entry.getValue()+" ");
                }
                return sb.toString();
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
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
// Related Topics 哈希表 字符串 滑动窗口 👍 1582 👎 0
