  //给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]] 
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
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 16 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-11 16:56:03 
//分割回文子字符串

  import java.util.ArrayDeque;
  import java.util.ArrayList;
  import java.util.Deque;
  import java.util.List;

  public class M99OJA{
    public static void main(String[] args) {
         Solution solution = new M99OJA().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<String>> res = new ArrayList<>();

        public String[][] partition(String s) {
            //暴力计算所有划分情况
            dfs(s, 0, new ArrayDeque<>());
            String[][] array = new String[res.size()][];
            for (int i = 0; i < res.size(); i++) {
                array[i] = new String[res.get(i).size()];
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = res.get(i).get(j);
                }
            }
            return array;
        }

        private void dfs(String s, int index, Deque<String> temp) {
            if (s.length() == index) {
                //到边界了，保存结果
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = index; i < s.length(); i++) {
                //字串， new String(index,i)
                if (!isPan(s, index, i)) {
                    continue;
                }
                temp.addLast(new String(s.toCharArray(), index, i + 1 - index));
                dfs(s, i + 1, temp);
                temp.removeLast();
            }
        }

        private boolean isPan(String s, int index, int i) {
            char[] chars = s.toCharArray();
            while (index < i) {
                if (chars[index] != chars[i]) {
                    return false;
                }
                index++;
                i--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}