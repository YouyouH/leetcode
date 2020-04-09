package com.yy.leetcode.twopointers;
/**
 * @author youyouhuang
 * @create 2020-04-09
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *<p>示例 1:
 *<p>
 *<p> 输入: S = "ababcbacadefegdehijhklij"
 *<p> 输出: [9,7,8]
 *<p> 解释:
 *<p> 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 *<p> 每个字母最多出现在一个片段中。
 *<p> 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *<p>
 *<p> 注意:
 *<p>
 *<p>     S的长度在[1, 500]之间。
 *<p>     S只包含小写字母'a'到'z'。
 *<p>
 *<p> 来源：力扣（LeetCode）
 *<p> 链接：https://leetcode-cn.com/problems/partition-labels
 *<p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> results = new ArrayList<>();
        if(null == S ||S.length() == 0){
            return results;
        }
        Map<Character,Integer> characterPosition = new HashMap<>();
        for (int i = S.length()-1; i >=0; i--) {
            char ch = S.charAt(i);
            characterPosition.putIfAbsent(ch,i);
        }

        int start = 0;
        while(start<S.length()) {
            int i = start;
            int j = characterPosition.get(S.charAt(i));
            while (i <= j) {
                j = Math.max(j, characterPosition.get(S.charAt(i)));
                i++;
            }
            results.add(j-start+1);
            start = j+1;
        }
        return results;
    }
}
