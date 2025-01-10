
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-10 15:32:48 
//盈利计划

public class ProfitableSchemes{
    public static void main(String[] args) {
         Solution solution = new ProfitableSchemes().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        /**
         * 01背包，背包容量是n个员工,物品是工作，价值是profit
         *
         * dp[i][j][k] 表示前i种工作,j个员工，至少产生利润k的方案数
         *
         * dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-group[i-1]][k-profit[i-1]]
         *
         * FIXME 由于我们定义的第三维是工作利润至少为 k 而不是 工作利润恰好为 k，因此上述状态转移方程中右侧的第三维是 max(0,k−profit[i]) 而不是 k−profit[i]。读者可以思考这一步的妙处所在。
         *  注意第三个维度k定义为利润至少达到k,所以对于 [k-profit[i-1]]，如果k<profit[i-1],则为0，意思是当前任务利润，profit[i-1]已经超过了至少要获得的利润，那么前i-1个任务只需至少获得利润0即可
         */

        int projectCount = group.length;

        int[][][] dp = new int[projectCount + 1][n + 1][minProfit + 1];

        //初始化
        dp[0][0][0] = 1;

        for (int i = 1; i < projectCount + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < minProfit + 1; k++) {
                    if (j - group[i - 1] >= 0) {
                        if (k - profit[i - 1] >= 0) {
                            dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][k - profit[i - 1]]) % MOD;
                        } else {
                            //k<profit[i - 1] 表示当前最少利润小于当前项目利润，那么当前最小利润是0就够了
                            dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][0]) % MOD;
                        }
                    } else {
                        //人手不够了
                        dp[i][j][k] = dp[i - 1][j][k] % MOD;
                    }

                }
            }
        }

        int ans = 0;
        //遍历所有项目，达到minProfit的和就是答案
        /**
         * FIXME: 遍历所有员工数量，为什么？
         *   因为dp定义为，刚好使用j个人的方案数。那么就要遍历所有人数的情况。同时只初始化dp[0][0][0] = 1.
         *   对于dp[0][1][0] 我们保持0。
         *
         *   假如定义dp为最多使用j个人，那么dp[0][j][0]就要全部初始化为1。答案也就不需要累加。
         *
         *   为什么不用遍历所有项目？因为dp定义为前i个项目，不是说必须要用所有项目。
         *   为什么不遍历profit? dp定义的是至少达到minProfit，小于minProfit的不用管。
         *
         */

        for (int i = 0; i < n + 1; i++) {
            ans = (ans + dp[projectCount][i][minProfit]) % MOD;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //集团里有 n 名员工，他们可以完成各种各样的工作创造利润。 
//
// 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。 
//
// 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。 
//
// 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
//输出：2
//解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
//总的来说，有两种计划。 
//
// 示例 2： 
//
// 
//输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
//输出：7
//解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
//有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= minProfit <= 100 
// 1 <= group.length <= 100 
// 1 <= group[i] <= 100 
// profit.length == group.length 
// 0 <= profit[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 325 👎 0
