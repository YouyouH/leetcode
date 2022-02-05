  //给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "a"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// 
//
// 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode-cn.com/problems/valid-anagram/ 
// Related Topics 哈希表 字符串 排序 👍 13 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-05 19:54:48 
//有效的变位词

  import java.util.HashMap;
  import java.util.Map;
  import java.util.Objects;

  public class DKk3P7{
    public static void main(String[] args) {
         Solution solution = new DKk3P7().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchars = t.toCharArray();
        if (schar.length != tchars.length) {
            return false;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        boolean equal = true;
        for (int i = 0; i < schar.length; i++) {
            updateMap(smap, schar[i]);
            updateMap(tmap, tchars[i]);
            if (schar[i] != tchars[i]) {
                equal = false;
            }
        }
        if (equal) {
            return false;
        }
        for (Character c : smap.keySet()) {
            //在长度一样的前提下，如果每个key出现的次数都一样则说明是相等的
            if (!tmap.containsKey(c) || !Objects.equals(tmap.get(c), smap.get(c))) {
                return false;
            }
        }
        return true;

    }

        private void updateMap(Map<Character, Integer> smap, char c) {
            if (smap.containsKey(c)) {
                smap.put(c, smap.get(c) + 1);
            }else{
                smap.put(c, 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}