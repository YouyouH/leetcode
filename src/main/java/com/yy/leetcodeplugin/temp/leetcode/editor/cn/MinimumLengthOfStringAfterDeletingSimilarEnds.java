
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-12 21:51:59 
//删除字符串两端相同字符后的最短长度

public class MinimumLengthOfStringAfterDeletingSimilarEnds{
    public static void main(String[] args) {
         Solution solution = new MinimumLengthOfStringAfterDeletingSimilarEnds().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLength(String s) {
        /**
         * 双指针，左指针和右指针分别在字符串的首尾。
         * 左右指针指向的字符串相同
         *      1.分别移动指针收缩直到字母不同处
         *      2.重新开始判断
         * 结束标志：
         *      1.指针不能相遇
         *      2.指向的字符不同
         */
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;


        while (l<r && chars[l] == chars[r]) {
//            if (r - l == 1) {
//                return 0;
//            }
//            if (r == l) {
//                return 1;
//            }
            //FIXME 下面这里是个小优化，可以让代码更简洁（不过要多跑一遍循环）
            char c = chars[l];
            //收缩左指针
            //FIXME chars[l] == c 这种写法确保循环结束的时候l指向下一个不相同的字符串
            // 我写的是 chars[l] == chars[l+1] 这种写法要判断l+1不能超过边界，并且跳出循环之后还要再额外的执行l++让指针指向下一个不用的字符
            while (l<=r && chars[l] == c) {
                l++;
            }
//            if (l == r) {
//                return 0;
//            }
//            l++;
            //收缩右指针
            while (l<=r  && chars[r] == c) {
                r--;
            }
//            r--;
        }
        return r - l + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次： 
//
// 
// 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。 
// 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。 
// 前缀和后缀在字符串中任意位置都不能有交集。 
// 前缀和后缀包含的所有字符都要相同。 
// 同时删除前缀和后缀。 
// 
//
// 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ca"
//输出：2
//解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
// 
//
// 示例 2： 
//
// 
//输入：s = "cabaabac"
//输出：0
//解释：最优操作序列为：
//- 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
//- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
//- 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
//- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。 
//
// 示例 3： 
//
// 
//输入：s = "aabccabba"
//输出：3
//解释：最优操作序列为：
//- 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
//- 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含字符 'a'，'b' 和 'c' 。 
// 
//
// Related Topics 双指针 字符串 👍 84 👎 0
