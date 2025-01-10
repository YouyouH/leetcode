
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-08 15:03:55 
//执行操作可获得的最大总奖励 I

import java.util.Arrays;

public class MaximumTotalRewardUsingOperationsI{
    public static void main(String[] args) {
         Solution solution = new MaximumTotalRewardUsingOperationsI().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxTotalReward(int[] rewardValues) {
        /**
         * 看了题解
         *      先排序，然后转换成01背包问题
         *      为什么要排序？因为假如先选大数再选小数肯定是亏的
         *
         *      dp[i][j] 表示前i个数在总和为j的情况下最大能获得的总奖励。最后对数组dp[i]取最大值。
         *      j相当于背包容量，数字本身大小相当于重量也相当于价值。
         *
         *      FIXME
         *          更流行的做法是用dp[i][j]表示前i个数能否凑出总价值j
         *              j的范围？
         *                  j<2*max-1,因为如果选择的最后一个数假如是m,那么前面的和加起来最大是m-1,加上m就是2m-1
         */

        int[] sortedValues = Arrays.stream(rewardValues).sorted().toArray();
        int max = sortedValues[sortedValues.length - 1];

        int m = rewardValues.length;
        boolean[][] dp = new boolean[m+1][2*max];
        //前0个数除了构成0 其他都不行
        dp[0][0] = true;

        for (int i = 1; i < m+1; i++) {
            int curValue = sortedValues[i - 1];
            for (int j = 0; j < 2 * max; j++) {
//                if (j - curValue >= 0) {
                //FIXME 这里额外多一个条件 curValue > (j-curValue)？
                //当前奖励curValue大于之前的总奖励（j - curValue）才能选
                if (j - curValue >= 0 && curValue > (j-curValue)) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curValue];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = 0;
        //遍历dp返回值等于true的时候的最大j
        for (int i = 0; i < 2 * max; i++) {
            if (dp[m][i]) {
                ans = Math.max(ans, i);
            }
        }
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 rewardValues，长度为 n，代表奖励的值。 
//
// 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ： 
//
// 
// 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。 
// 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + 
//rewardValues[i]），并 标记 下标 i。 
// 
//
// 以整数形式返回执行最优操作能够获得的 最大 总奖励。 
//
// 
//
// 示例 1： 
//
// 
// 输入：rewardValues = [1,1,3,3] 
// 
//
// 输出：4 
//
// 解释： 
//
// 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。 
//
// 示例 2： 
//
// 
// 输入：rewardValues = [1,6,4,3,2] 
// 
//
// 输出：11 
//
// 解释： 
//
// 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。 
//
// 
//
// 提示： 
//
// 
// 1 <= rewardValues.length <= 2000 
// 1 <= rewardValues[i] <= 2000 
// 
//
// Related Topics 数组 动态规划 👍 58 👎 0
