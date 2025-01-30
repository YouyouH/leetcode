
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-30 11:50:10 
//单词拆分

import java.util.*;

public class WordBreak{
    public static void main(String[] args) {
         Solution solution = new WordBreak().new Solution();
        solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * dp[i] 表示长度为i的子串能否利用字典拼出
         *  dp[i] = dp[0..j] && substring(j,i) (只要存在j满足表达式为true即可)
         */
        int length = s.length();
        boolean[] dp = new boolean[length];

        Set<String> set = new HashSet<>(wordDict);

        //FIXME: 可以索引+1优化代码。i从1开始
        for (int i = 0; i < length; i++) {
            dp[i] = set.contains(s.substring(0, i+1));//不切分的情况下能否拼出
            for (int j = 0; j < i; j++) {
                dp[i] |= dp[j] && set.contains(s.substring(j + 1, i+1));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2656 👎 0
