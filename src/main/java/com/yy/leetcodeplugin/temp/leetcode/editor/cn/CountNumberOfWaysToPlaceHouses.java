
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-27 22:01:03 
//统计放置房子的方式数

public class CountNumberOfWaysToPlaceHouses{
    public static void main(String[] args) {
         Solution solution = new CountNumberOfWaysToPlaceHouses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int MOD = 1_000_000_000 + 7;
    public int countHousePlacements(int n) {
        /**
         * 动态规划：
         *  每条街的放置方式算出来，街道两侧就是放置方式的平方。
         *
         *  dp[n] = dp[n-2] + dp[n-1]  //前n个地块的方式 等于前n-1个地块的方式（第n个地块不放置） 加上 前n-2个地块的方式（第n个地块放置）
         */
        long dp0 = 1;
        long dp1 = 2;

        if (n == 1) {
            return 2*2;
        }

        long result = 0;

        for (int i = 2; i < n + 1; i++) {
            result = (dp0 + dp1) % MOD;
            dp0 = dp1% MOD;
            dp1 = result% MOD;
        }

        return (int) ((result * result) % MOD);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。 
//
// 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 10⁹ + 7 取余后再返回。 
//
// 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：4
//解释：
//可能的放置方式：
//1. 所有地块都不放置房子。
//2. 一所房子放在街道的某一侧。
//3. 一所房子放在街道的另一侧。
//4. 放置两所房子，街道两侧各放置一所。
// 
//
// 示例 2： 
// 输入：n = 2
//输出：9
//解释：如上图所示，共有 9 种可能的放置方式。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 动态规划 👍 60 👎 0
