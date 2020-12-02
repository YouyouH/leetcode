package com.yy.leetcode.unclear;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (Objects.equals(s, t)) return true;

        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Map<Character, Character> s2t = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = sch[i];
            char ti = tch[i];
            if (s2t.containsKey(si)) {
                if (!s2t.get(si).equals(ti)) {
                    return false;
                }
            } else if (s2t.containsValue(ti)) {
                return false;
            } else {
                s2t.put(si, ti);
            }
        }
        return true;
    }
}
