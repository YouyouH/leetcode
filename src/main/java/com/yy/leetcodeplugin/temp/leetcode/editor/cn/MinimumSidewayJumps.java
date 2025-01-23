
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-22 21:07:18 
//最少侧跳次数

public class MinimumSidewayJumps{
    public static void main(String[] args) {
         Solution solution = new MinimumSidewayJumps().new Solution();
        solution.minSideJumps(new int[]{0,1,2,3,0});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int UNREACHABLE = Integer.MAX_VALUE - 1;
    public int minSideJumps(int[] obstacles) {
        /**
         * 状态是三条道路，n个点。最后取三个点的最小值
         *      dp[i][k] 表示达到第i个点的第k条路(一共 0 1 2三条路)的最少测跳次数
         *          dp[i][k] = min(dp[i-1][0] + dp[i-1][1] + dp[i-1][2])
         *          另外要判断到底需不需要测跳。同一条路没有障碍就不需要测跳。
         */

        //给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。
        //给你一个长度为 n + 1 的数组 obstacles. 如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
        int l1 = obstacles.length;
        int[][] dp = new int[l1+1][3];//三条路

        //初始化 从第二条路出发
//        dp[0][0] = UNREACHABLE;
//        dp[0][1] = 0;
//        dp[0][2] = UNREACHABLE;

        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[1][2] = 1;

        //如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。

        for (int i = 2; i < l1 + 1; i++) {//直接从第二个点出发
            //第i个点的障碍在第obstacle条路上
            int obstacle = obstacles[i-1];

            //------------------第一阶段，考虑从同一条路跳过来-------------------
            //当前在第一条路
            if (obstacle == 1) {
                //当前第一条路上有障碍
                dp[i][0] = UNREACHABLE;
            } else {
                dp[i][0] = dp[i - 1][0];
            }

            //当前在第二条路
            if (obstacle == 2) {
                //当前第一条路上有障碍
                dp[i][1] = UNREACHABLE;
            } else {
                dp[i][1] = dp[i - 1][1];
            }

            //当前在第三条路
            if (obstacle == 3) {
                //当前第一条路上有障碍
                dp[i][2] = UNREACHABLE;
            } else {
                dp[i][2] = dp[i - 1][2];
            }

            //------------------第二阶段，考虑从其他路跳过来和从当前路跳过来的最小值-------------------
            //当前在第一条路
            if (obstacle != 1) {
                dp[i][0] = Math.min(dp[i][0], Math.min(dp[i][1],dp[i][2])+1);
            }

            //当前在第二条路
            if (obstacle != 2) {
                dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][0],dp[i][2])+1);
            }

            //当前在第三条路
            if (obstacle != 3) {
                dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][0],dp[i][1])+1);
            }

        }
        return Math.min(dp[l1][0], Math.min(dp[l1][1], dp[l1][2]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处
//。然而道路上可能有一些障碍。 
//
// 给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 
//obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。 
//
// 
// 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。 
// 
//
// 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外
//一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。 
//
// 
// 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。 
// 
//
// 这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。 
//
// 注意：点 0 处和点 n 处的任一跑道都不会有障碍。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacles = [0,1,2,3,0]
//输出：2 
//解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
//注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
// 
//
// 示例 2： 
// 
// 
//输入：obstacles = [0,1,1,3,3,0]
//输出：0
//解释：跑道 2 没有任何障碍，所以不需要任何侧跳。
// 
//
// 示例 3： 
// 
// 
//输入：obstacles = [0,2,1,0,3,0]
//输出：2
//解释：最优方案如上图所示。总共有 2 次侧跳。
// 
//
// 
//
// 提示： 
//
// 
// obstacles.length == n + 1 
// 1 <= n <= 5 * 10⁵ 
// 0 <= obstacles[i] <= 3 
// obstacles[0] == obstacles[n] == 0 
// 
//
// Related Topics 贪心 数组 动态规划 👍 127 👎 0
