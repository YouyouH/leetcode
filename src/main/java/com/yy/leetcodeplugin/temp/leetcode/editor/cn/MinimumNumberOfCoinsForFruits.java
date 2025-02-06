
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-02 12:04:24 
//购买水果需要的最少金币数

public class MinimumNumberOfCoinsForFruits{
    public static void main(String[] args) {
         Solution solution = new MinimumNumberOfCoinsForFruits().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCoins(int[] prices) {
        /**
         * FIXME: 抄的答案
         */
        int n = prices.length;
        int[] dp = new int[n + 1]; // dp[i]表示获得第1到第i个水果的最小花费

        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;//初始化给一个极大值避免后面滚动更新的时候影响比较最小值
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // 购买第i个水果
            int maxFreeIndex = Math.min(n, i + i); // 计算免费获得的最后一个水果的下标
//            System.out.println("--------i=" + i);
            for (int j = i; j <= maxFreeIndex; j++) {
                //往前滚动更新数组
                //在j-maxFreeIndex范围之间的值要么是之前更新过，要么是当前把prices[i - 1]买了。两者取最小值。
                dp[j] = Math.min(dp[j], dp[i - 1] + prices[i - 1]); // 更新dp[j]，考虑购买第i个水果的情况
//                System.out.println("j=" + j + " val=" + dp[j]);
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 下标从 0 开始的 整数数组 prices ，其中 prices[i] 表示你购买第 i + 1 个水果需要花费的金币数目。 
//
// 水果超市有如下促销活动： 
//
// 
// 如果你花费 prices[i] 购买了下标为 i + 1 的水果，那么你可以免费获得下标范围在 [i + 1, i + i] 的水果。 
// 
//
// 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j - 1] 个金币去购买它以获得它的奖励。 
//
// 请你返回获得所有水果所需要的 最少 金币数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：prices = [3,1,2] 
// 
//
// 输出：4 
//
// 解释： 
//
// 
// 用 prices[0] = 3 个金币购买第 1 个水果，你可以免费获得第 2 个水果。 
// 用 prices[1] = 1 个金币购买第 2 个水果，你可以免费获得第 3 个水果。 
// 免费获得第 3 个水果。 
// 
//
// 请注意，即使您可以免费获得第 2 个水果作为购买第 1 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。 
//
// 示例 2： 
//
// 
// 输入：prices = [1,10,1,1] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
// 用 prices[0] = 1 个金币购买第 1 个水果，你可以免费获得第 2 个水果。 
// 免费获得第 2 个水果。 
// 用 prices[2] = 1 个金币购买第 3 个水果，你可以免费获得第 4 个水果。 
// 免费获得第 4 个水果。 
// 
//
// 示例 3： 
//
// 
// 输入：prices = [26,18,6,12,49,7,45,45] 
// 
//
// 输出：39 
//
// 解释： 
//
// 
// 用 prices[0] = 26 个金币购买第 1 个水果，你可以免费获得第 2 个水果。 
// 免费获得第 2 个水果。 
// 用 prices[2] = 6 个金币购买第 3 个水果，你可以免费获得第 4，5，6（接下来的三个）水果。 
// 免费获得第 4 个水果。 
// 免费获得第 5 个水果。 
// 用 prices[5] = 7 个金币购买第 6 个水果，你可以免费获得第 7 和 第 8 个水果。 
// 免费获得第 7 个水果。 
// 免费获得第 8 个水果。 
// 
//
// 请注意，即使您可以免费获得第 6 个水果作为购买第 3 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 1000 
// 1 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 队列 数组 动态规划 单调队列 堆（优先队列） 👍 58 👎 0
