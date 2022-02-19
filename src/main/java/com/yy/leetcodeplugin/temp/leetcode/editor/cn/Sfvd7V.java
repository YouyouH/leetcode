  //给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。 
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/ 
// Related Topics 哈希表 字符串 排序 👍 15 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-19 10:36:38 
//变位词组

  import java.util.*;
  import java.util.stream.Collectors;

  public class Sfvd7V{
    public static void main(String[] args) {
         Solution solution = new Sfvd7V().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //遍历一遍，用array表示每个字符串出现的字母的频率
        //如果能过对这些array生成一个key，则可以加快寻找? 可以用Arrays.hashcode
        Map<Integer, List<String>> key2p = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] array = new int[26];
            for (char c : strs[i].toCharArray()) {
                array[c - 'a']++;
            }
            int hashCode = Arrays.hashCode(array);
            List<String> list = key2p.getOrDefault(hashCode, new ArrayList<>());
            list.add(strs[i]);
            key2p.put(hashCode, list);

        }
        return new ArrayList<List<String>>(key2p.values());
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}