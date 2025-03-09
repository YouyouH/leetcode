
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-07 16:22:21 
//串联所有单词的子串

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
         Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        /**
         * 遍历整个字符串
         *      用一个定长窗口，判断到有一个符合的就继续判断，否则退出。
         * 时间复杂度：
         *       n的平方
         *
         * FIXME
         *    单词可能有重复的，需要计数确保都匹配了
         *
         *    FIXME: 太慢了！！！！
         *      看的答案：
         *      1.双层循环：外层遍历左指针，内层是滑动窗口，初始窗口大小是 单词长度 乘 单词数量
         *
         */
        List<Integer> res = new ArrayList<>();

        int wordLength = words[0].length();
        //对每个单词计数，确保都匹配到了
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int size = wordLength * words.length;//整个子串的长度

        Map<String, Integer> temp = new HashMap<>();//记录当前遍历得到的子串情况
        int l = 0;
        for (int r = wordLength-1; r < s.length(); ) {
//            System.out.println("l=" + l + " r=" + r);
            String word = s.substring(r + 1-wordLength, r + 1);
//            System.out.println("word=" + word);
            if (count.containsKey(word)) {
                temp.put(word, temp.getOrDefault(word, 0) + 1);
            }else{
                //发现不存在的单词，移动l
                l++;
                r = l + wordLength - 1;
//                System.out.println("move l");
                temp.clear();
                continue;
            }
            if (r - l + 1 == size) {
//                System.out.println("possible");
                boolean valid = true;
                //可能符合条件，还要检查temp，是不是所有单词出现的次数也是对的
                for (Map.Entry<String, Integer> entry : count.entrySet()) {
                    String key = entry.getKey();
                    int v = entry.getValue();
                    if(!temp.containsKey(key) || v != temp.get(key)){
                        valid = false;
                        temp.clear();
                        break;
                    }
                }
                if(valid) {
                    res.add(l);
                }

                l++;//继续检查
                r = l + wordLength - 1;
//                System.out.println("continue" + " l=" + l + " r=" + r);
                temp.clear();
                continue;
            }

            r += wordLength;
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1188 👎 0
