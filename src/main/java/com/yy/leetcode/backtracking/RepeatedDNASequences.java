package com.yy.leetcode.backtracking;
/**
 * @author youyouhuang
 * @create 2020-04-10
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *<p>所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。
 *<p> 在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *<p> 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 *<p>
 *<p> 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 *<p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return list;
        }
        Map<String, Integer> string2map = new HashMap<>();



        int length = s.length();
        int i = 0;
        while (i + 10 <= length) {
            String substring = s.substring(i, i + 10);
            Integer integer = string2map.get(substring);
            if (null == integer) {
                string2map.put(substring, 1);
            } else {
                string2map.put(substring, integer + 1);
            }
            i++;
        }
        return string2map.entrySet().stream().filter(entry->entry.getValue() >1).map(entry->entry.getKey()).collect(Collectors.toList());
    }
}
