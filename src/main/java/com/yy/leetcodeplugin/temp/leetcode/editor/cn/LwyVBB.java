  //某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。 
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 
//false。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
//
// 示例 2： 
//
// 
//输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
//
// 示例 3： 
//
// 
//输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅
//' 是空白字符，定义为比任何其他字符都小（更多信息）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
// 
//
// 
//
// 注意：本题与主站 953 题相同： https://leetcode-cn.com/problems/verifying-an-alien-
//dictionary/ 
// Related Topics 数组 哈希表 字符串 👍 11 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-02 22:22:46 
//外星语言是否排序

  import java.util.Arrays;
  import java.util.Comparator;
  import java.util.HashMap;
  import java.util.Map;

  public class LwyVBB{
    public static void main(String[] args) {
         Solution solution = new LwyVBB().new Solution();
        solution.isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //题意开始都理解错了，不需要前一个单词的每一个字母都比后一个单词小,只需要从前往后有一个字符小就行了
        public boolean isAlienSorted(String[] words, String order) {
            int[] index = new int[26];
            for (int i = 0; i < order.length(); ++i)
                index[order.charAt(i) - 'a'] = i;

            search:
            for (int i = 0; i < words.length - 1; ++i) {
                String word1 = words[i];
                String word2 = words[i + 1];

                // Find the first difference word1[k] != word2[k].
                for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        // If they compare badly, it's not sorted.
                        if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                            return false;
                        continue search;
                    }
                }

                // If we didn't find a first difference, the
                // words are like ("app", "apple").
                if (word1.length() > word2.length())
                    return false;
            }

            return true;

//            作者：LeetCode
//            链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary/solution/yan-zheng-wai-xing-yu-ci-dian-by-leetcode/
//            来源：力扣（LeetCode）
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}