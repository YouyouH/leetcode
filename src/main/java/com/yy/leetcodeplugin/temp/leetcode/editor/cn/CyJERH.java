  //如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单
//调递增 的。 
//
// 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。 
//
// 返回使 s 单调递增 的最小翻转次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "00110"
//输出：1
//解释：我们翻转最后一位得到 00111.
// 
//
// 示例 2： 
//
// 
//输入：s = "010110"
//输出：2
//解释：我们翻转得到 011111，或者是 000111。
// 
//
// 示例 3： 
//
// 
//输入：s = "00011000"
//输出：2
//解释：我们翻转得到 00000000。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20000 
// s 中只包含字符 '0' 和 '1' 
// 
//
// 
//
// 注意：本题与主站 926 题相同： https://leetcode-cn.com/problems/flip-string-to-monotone-
//increasing/ 
// Related Topics 字符串 动态规划 👍 28 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-05-04 17:50:01 
//翻转字符

public class CyJERH{
    public static void main(String[] args) {
         Solution solution = new CyJERH().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlipsMonoIncr(String s) {
        //递推公式: （抄的）
        //简单DP思路：如果s[i] == '1'，那么这个字符不影响翻转次数，故有：dp[i] = dp[i - 1]。
        // 若s[i] == '0'，那我们有两种情况：1. 将s[i]由0翻转到1。2. 将前面的字符串s[0:i-1]中所有1翻转到0，两种情况取最小值，有dp[i] = min{dp[i - 1] + 1, oneCount}。所以我们还得用一个变量记录1的数量。

        /**
         * 思路：判断dp[i] 和 dp[i-1]之间的关系。如果dp[i-1]是递增序列，那么s[i] == 1就不需要翻转，是s[i] == 0的时候才需要
         * 考虑吧如何翻转
         */

        //改进：只和dp[i-1]有关，不需要数组保存。
        char[] chars = s.toCharArray();
        int length = chars.length;
        //统计 1 的个数
        int[] oneCount = new int[length];
        oneCount[0] = chars[0] == '1' ? 1 : 0;
        int c = oneCount[0];

        int[] dp = new int[length];
        dp[0] = 0;

        for (int i = 1; i < length; i++) {
            if (chars[i] == '1') {
                c++;
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(oneCount[i - 1], dp[i - 1] + 1);
            }
            oneCount[i] = c;

        }

        return dp[length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}