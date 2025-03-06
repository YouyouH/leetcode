
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-05 17:26:05 
//至少有 K 个重复字符的最长子串

public class LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args) {
         Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private int ans = 0;
            public int longestSubstring(String s, int k) {
                /**
                 * 从0开始枚举每一个位置的字符
                 * FIXME:
                 *  1. 如何用滑动窗口？
                 *      因为只有26个字母，所以可以通过双层循环，最外层遍历窗口内字母数量，从1开始一直到26，内层使用滑动窗口遍历字符串
                 *  2. 递归。每层递归都把当前字符串按照字符出现次数少于k的情况去拆分。（因为假如一个字符出现次数小于K，那么一定不会被包括在子串中）
                 */

                traverse(s, k);
                return ans;

            }

            private void traverse(String s, int k) {
                if (s.length() < k) {
                    return;
                }
                int[] chars = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    chars[s.charAt(i) - 'a']++;
                }

                boolean exist = true;
                for (int i = 0; i < 26; i++) {
                    if (chars[i] == 0) {
                        continue;
                    }
                    if (chars[i] < k) {
                        String[] split = s.split(String.valueOf((char) (i + 'a')));
//                        System.out.println("s=" + s+" split="+(char) (i + 'a'));
                        for (String sub : split) {
                            if (sub.isEmpty() || sub.length() < k ||  sub.length() < ans) {
                                continue;
                            }
//                            System.out.println("sub="+sub);
                            traverse(sub,k);
                        }
                        //FIXME: 这里要return，相当于每次调用只拆分一次（按照第一个找到的不满足K次的字符）。
                        //  否则会出现循环
                        //  或者一次把所有的字符都找出来全部分割
                        return;

                    }
                }
                ans = Math.max(ans, s.length());
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 如果不存在这样的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 946 👎 0
