
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-16 17:52:37 
//完全平方数

import java.util.Arrays;

public class PerfectSquares{
    public static void main(String[] args) {
         Solution solution = new PerfectSquares().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        /**
         * 完全背包因为数字可以重复使用，物品就是完全平方数，背包容量n
         *
         * FIXME:
         *  优化：压缩空间
         */
        int value = new Double(Math.sqrt(n)).intValue();
        System.out.println("number limit="+value);

        int[][] dp = new int[value + 1][n+1];

        //初始化. 凑不出的用无穷小表示
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i < value + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j - Math.pow(i, 2) >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][(int) (j - Math.pow(i, 2))] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
//                System.out.println("i=" + i + " j=" + j + " value=" + dp[i][j]);
            }
        }

        return dp[value][n];
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 2088 👎 0
