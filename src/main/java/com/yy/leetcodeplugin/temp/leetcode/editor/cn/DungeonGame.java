
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-03 17:55:40 
//地下城游戏

public class DungeonGame{
    public static void main(String[] args) {
         Solution solution = new DungeonGame().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        /**
         * 看得题解：
         *  两种方式
         *      1.DFS
         *      2.动态规划。这道题正向动态规划不行，后面的选择可能影响前面的选择，有后效性。
         *      要反方向求动态规划
         *
         *      dp[i][j] 表示在i,j处的最小初始健康点数
         *      dp[i][j] = Math.min(dp[i+1][j]-dungeon[i][j-1],  dp[i][j+1]-dungeon[i-1][j])，如果为负数则等于1。因为至少有一点。
         *
         */

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m+1][n+1];

        /**
         * 怎么初始化：
         * 初始值: dp[m][n-1]  dp[m-1][n]
         *
         * dp[m][] 和dp[][n]是无效值，赋值为10000(大于题目给定的范围),表示需要的初始血量无限大，不可能需要从这些位置出发
         *
         *      另外dp[m-1][n-1]的值为 max(1-dungeon[m-1][n-1],1), 同时表达式中需要用到 dp[m-1][n] 和 dp[m][n-1]，
         *      所以特别设置这两个值为1
         *
         */

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 10000;
        }
        for (int i = 0; i <= n; i++) {
            dp[m][i] = 10000;
        }

        dp[m][n - 1] = 1;
        dp[m-1][n] = 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                System.out.println("dp[i + 1][j]="+dp[i + 1][j]);
                System.out.println("dp[i][j + 1]="+dp[i][j + 1]);
                int min = Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]);
                if (min <= 0) {//如果为负数就置为1，因为1是最小血量
                    min = 1;
                }
                System.out.println("i=" + i + " j=" + j + " val=" + min);
                dp[i][j] = min;
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //
//
// 恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间
//里，他必须穿过地下城并通过对抗恶魔来拯救公主。 
//
// 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 
//
// 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么
//包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 
//
// 为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。 
//
// 返回确保骑士能够拯救到公主所需的最低初始健康点数。 
//
// 注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
//
// 
//
// 示例 1： 
// 
// 
//输入：dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
//输出：7
//解释：如果骑士遵循最佳路径：右 -> 右 -> 下 -> 下 ，则骑士的初始健康点数至少为 7 。 
//
// 示例 2： 
//
// 
//输入：dungeon = [[0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == dungeon.length 
// n == dungeon[i].length 
// 1 <= m, n <= 200 
// -1000 <= dungeon[i][j] <= 1000 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 875 👎 0
