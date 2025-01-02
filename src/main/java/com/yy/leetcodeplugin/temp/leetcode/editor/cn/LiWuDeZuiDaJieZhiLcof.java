
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-31 22:34:47 
//珠宝的最高价值

public class LiWuDeZuiDaJieZhiLcof{
    public static void main(String[] args) {
         Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jewelleryValue(int[][] frame) {
        /**
         * 二维动态规划：
         *  dp[i][j] 表示拿到位置i,j处珠宝的最大值
         *  dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + frame[i][j]
         *
         *  FIXME 压缩成一维数组. dp[n]表示当前行，每一列的值
         *   dp[n] = max(dp[n],dp[n-1]) + frame[i][j]
         */
        int m = frame.length;
        int n = frame[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = frame[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + frame[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + frame[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
            }
        }
        return dp[m - 1][n - 1];
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为： 
//
// 
// 只能从架子的左上角开始拿珠宝 
// 每次可以移动到右侧或下侧的相邻位置 
// 到达珠宝架子的右下角时，停止拿取 
// 
//
// 注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。 
//
// 
//
// 示例 1： 
//
// 
//输入：frame = [[1,3,1],[1,5,1],[4,2,1]]
//输出：12
//解释：路径 1→3→5→2→1 可以拿到最高价值的珠宝 
//
// 
//
// 提示： 
//
// 
// 0 < frame.length <= 200 
// 0 < frame[0].length <= 200 
// 
//
// 
//
// Related Topics 数组 动态规划 矩阵 👍 551 👎 0
