
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-08 17:17:19 
//一和零

public class OnesAndZeroes{
    public static void main(String[] args) {
         Solution solution = new OnesAndZeroes().new Solution();
        solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int findMaxForm(String[] strs, int m, int n) {
                /**
                 * 01背包问题变形。这里背包容量有两个维度m,n。每个物品的重量也是两个维度。问最多能装多少个物品？
                 *
                 * dp[i][m][n] 表示使用前i个物品，容量最大为m,n的背包最多可以装多少个物品。
                 *      dp[i][m][n] = max(dp[i-1][m][n], dp[i-1][m-m[i]][n-n[i]])
                 */

                int length = strs.length;
                int[][][] dp = new int[length + 1][m + 1][n + 1];

                dp[0][0][0] = 0;//只用前0个字符，子集长度为0

                for (int i = 1; i < length + 1; i++) {
                    for (int j = 0; j < m + 1; j++) {
                        for (int k = 0; k < n + 1; k++) {
                            int zeroCount = getCount(strs[i - 1], '0');
                            int oneCount = getCount(strs[i - 1], '1');
                            if (j - zeroCount >= 0 && k - oneCount >= 0) {
                                dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroCount][k - oneCount] + 1);
                            }else{
                                dp[i][j][k] = dp[i - 1][j][k];
                            }
                        }
                    }
                }
                return dp[length][m][n];

            }

            private int getCount(String str, char c) {
                int count = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == c) {
                        count++;
                    }
                }
                return count;
            }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
// 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
//
// Related Topics 数组 字符串 动态规划 👍 1203 👎 0
