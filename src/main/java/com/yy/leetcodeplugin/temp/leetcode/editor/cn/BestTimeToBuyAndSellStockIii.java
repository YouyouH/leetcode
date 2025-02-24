
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-27 23:56:34 
//买卖股票的最佳时机 III

public class BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
         Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 定义 dp为第i天的时候，交易了0/1/2次的情况下，持有/不持有 的情况下的利润最大值
         * dp[i][j][0]
         * dp[i][j][1]
         *
         */
        int size = prices.length;
        int[][][] dp = new int[size][3][2];

        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = -prices[0];
            dp[0][i][1] = 0;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < 3; j++) {
                /**
                 * FIXME 注意买入卖出算一次交易。
                 *     对于当前持有的情况，可以从两种情况转移：
                 *          前一天持有：dp[i-1][j][0]
                 *          前一天不持有：dp[i-1][j-1][1]-prices[i]，今天买入。今天买入交易次数要加一，所以前一天是j-1。今天买入是新的交易的开始，所以j要变。
                 *     对于当前不持有的情况：可以从两种情况转移：
                 *          前一天持有：dp[i-1][j][0]+prices[i] 今天卖出赚钱。 前一个状态持有到今天状态卖出，属于同一个交易，所以j不变。
                 *          前一天不持有：dp[i-1][j][1]
                 */

                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][0] + prices[i], dp[i-1][j][1]);
            }
        }
        return dp[size-1][2][1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 1789 👎 0
