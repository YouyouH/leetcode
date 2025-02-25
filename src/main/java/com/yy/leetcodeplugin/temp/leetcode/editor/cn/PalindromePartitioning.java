
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-24 20:55:48 
//分割回文串

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args) {
         Solution solution = new PalindromePartitioning().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

            List<List<String>> ans = new ArrayList<>();

            public List<List<String>> partition(String s) {
                /**
                 * FIXME 看的答案
                 */

                traverse(s, 0, new ArrayList<String>());

                return ans;

            }

            private void traverse(String s, int start, List<String> res) {

                if (start == s.length()) {
                    ans.add(new ArrayList<>(res));
                    return;
                }

                /**
                 * i 相当于字符串终点位置
                 */
                for (int i = start; i < s.length(); i++) {
                    if (isPalindromeString(s, start, i)) {
                        res.add(s.substring(start, i+1));
                        traverse(s, i+1, res);
                        res.remove(res.size() - 1);
                    }
                }


            }

            private boolean isPalindromeString(String s, int start, int end) {
                while (start <= end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        return false;
                    }
                    start++;
                    end--;
                }
                return true;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1945 👎 0
