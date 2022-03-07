  //给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 22 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-07 16:47:06 
//含有所有字符的最短字符串

  import org.junit.Assert;

  import java.util.HashMap;
  import java.util.Map;

  public class M1oyTv{
    public static void main(String[] args) {
         Solution solution = new M1oyTv().new Solution();
        Assert.assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("", solution.minWindow("ab", "A"));
        Assert.assertEquals("b", solution.minWindow("ab", "b"));
        Assert.assertEquals("b", solution.minWindow("abc", "b"));
        Assert.assertEquals("c", solution.minWindow("abc", "c"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //滑动窗口，右边界先向右，直到符合条件，然后左边界收缩，直到不满足条件，然后右边界再次向右，循环这个过程直到右边界到边界
        //用hashmap记录是否满足条件
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> smap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        //优化：用diffmap.s字串要包含t,即smap的所有字符数量要大于等于t中的
        Map<Character, Integer> diffMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            Character character = entry.getKey();
            Integer count = entry.getValue();
            if (smap.containsKey(character)) {
                diffMap.put(character, smap.get(character) - count);
            }else {
                diffMap.put(character, -count);
            }
        }

        if (containsT(diffMap)) {
            return s.substring(0, t.length());
        }

        int res = Integer.MAX_VALUE;
        String resString = "";
        //右边窗口直接前进一步再开始
        int left = 0, right = t.length();
        while (right < s.length()) {
            //不断增加右边界
            while (right < s.length()) {
                char c = s.charAt(right);
                if (diffMap.containsKey(c)) {
                    diffMap.put(c, diffMap.get(c) + 1);
                }
                if (containsT(diffMap)) {
                    break;
                }
                right++;
            }
            if (right == s.length()) {
                return resString;
            }

            //不断减小左边界
            while (left <= right ) {
                diffMap.computeIfPresent(s.charAt(left), (key, value) -> value-1);
                left++;
                if (!containsT(diffMap)) {
                    break;
                }
            }
            int length = s.substring(left - 1, right + 1).length();
            if (length < res) {
                resString = s.substring(left-1, right + 1);
                res = length;
                System.out.println("Candidates:" + resString);
            }

            right++;
        }

        return resString;

    }

        private boolean containsT(Map<Character, Integer> diffMap) {
            return diffMap.values().stream().mapToInt(Integer::intValue).noneMatch(n -> n < 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}