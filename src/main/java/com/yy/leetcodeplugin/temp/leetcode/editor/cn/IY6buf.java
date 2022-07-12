  //给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。 
//
// 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 97 题相同： https://leetcode-cn.com/problems/interleaving-string/ 
// Related Topics 字符串 动态规划 👍 21 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-06-27 10:35:26 
//字符串交织

  public class IY6buf{
    public static void main(String[] args) {
        Solution solution = new IY6buf().new Solution();
        solution.isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力：从s3里面 从前往后删除s1的字符，再从前往后删除s2的字符.
         * 这个方法不行，因为s1和s2可能有相同的字符，删除顺序有讲究，遇到一个字符的时候，先从s1里面删还是先从s2里面删结果不一样。
         * <p>
         * 参考别人思路https://leetcode.cn/problems/interleaving-string/solution/guan-fang-ti-jie-de-si-lu-xiu-zheng-bu-c-nmc6/
         * 第一不要用删除，用三个指针判断。
         * 第二遇到两个指针同时匹配的情况要搜索多条路径
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];
            if (s1.length() + s2.length() != s3.length()) return false;
            traverse(s1, s2, s3, 0, 0, 0, visited);
            return visited[s1.length()][s2.length()];//检查有没有访问过终点
        }

        /**
         * 深度遍历
         * 终止条件就是 i1和i2都访问到了终点
         */
        private void traverse(String s1, String s2, String s3, int i1, int i2, int i3, boolean[][] visited) {
            //检查有没有访问过
            if (visited[i1][i2]) return;

            //标记i1, i2
            visited[i1][i2] = true;

            if (i1 < s1.length() && i2 < s2.length()) {//s1 s2都没到达终点
                if (s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3)) {
                    traverse(s1, s2, s3, i1 + 1, i2, i3+1, visited);
                    traverse(s1, s2, s3, i1, i2 + 1, i3+1, visited);
                } else if (s1.charAt(i1) == s3.charAt(i3)) {
                    traverse(s1, s2, s3, i1 + 1, i2, i3+1, visited);
                } else if (s2.charAt(i2) == s3.charAt(i3)) {
                    traverse(s1, s2, s3, i1, i2 + 1, i3+1, visited);
                } else {
                    return;
                }
            } else if (i1 < s1.length()) {//s2已经到达终点了
                if (s1.charAt(i1) == s3.charAt(i3)) {
                    traverse(s1, s2, s3, i1 + 1, i2, i3+1, visited);
                } else {
                    return;
                }
            } else if (i2 < s2.length()) {//s1已经到达终点
                if (s2.charAt(i2) == s3.charAt(i3)) {
                    traverse(s1, s2, s3, i1, i2 + 1, i3+1, visited);
                } else {
                    return;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}