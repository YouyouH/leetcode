
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-06 14:05:43 
//扣分后的最大得分

public class MaximumNumberOfPointsWithCost{
    public static void main(String[] args) {
         Solution solution = new MaximumNumberOfPointsWithCost().new Solution();
        solution.maxPoints(new int[][]{{1, 5}, {2, 3}, {4, 2}});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {

            private long res = 0;
            public long maxPoints(int[][] points) {
                /**
                 * DFS 超时了
                 */

                for (int i = 0; i < points[0].length; i++) {
                    dfs(points, 0, i, points[0][i]);
                }
                return res;
            }

            private void dfs(int[][] points, int i, int j, long sum) {
                int m = points.length;
                int n = points[0].length;

//                if (i == m) {
//                    res = Math.max(res, sum);
//                    return;
//                }

//                System.out.println("i=" + i + " j=" + j + " sum=" + sum);
                res = Math.max(res, sum);
                for (int k = i+1; k < m; k++) {//从下一行开始
                    for (int l = 0; l < n; l++) {//每一行都从头开始遍历
                        //到下一行以后遍历一遍所有列
                        dfs(points, k, l, sum + points[k][l] - Math.abs(l - j));
//                        System.out.println("k=" + k + " l=" + l + " sum=" + sum);
                    }
                }
            }
        }

    class Solution {

        public long maxPoints(int[][] points) {
            /**
             * FIXME 上面DFS 超时了，看的答案
             *      用动态规划 还要加上技巧
             *      1. 动态规划一层一层确定每一个数的最大值
             *      2. 正常做法是对每一个数都要计算上面一整行确认最大值。此事时间复杂度是mnn。要想办法变成mn
             *          要想办法在求当前列的时候不要再去遍历上一列，而是直接计算得到。这样复杂度就从nn降到了n。
             */


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 m x n 的整数矩阵 points （下标从 0 开始）。一开始你的得分为 0 ，你想最大化从矩阵中得到的分数。 
//
// 你的得分方式为：每一行 中选取一个格子，选中坐标为 (r, c) 的格子会给你的总得分 增加 points[r][c] 。 
//
// 然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行 r 和 r + 1 （其中 0 <= r < m - 1），选中坐标为 (r, 
//c1) 和 (r + 1, c2) 的格子，你的总得分 减少 abs(c1 - c2) 。 
//
// 请你返回你能得到的 最大 得分。 
//
// abs(x) 定义为： 
//
// 
// 如果 x >= 0 ，那么值为 x 。 
// 如果 x < 0 ，那么值为 -x 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[1,2,3],[1,5,1],[3,1,1]]
//输出：9
//解释：
//蓝色格子是最优方案选中的格子，坐标分别为 (0, 2)，(1, 1) 和 (2, 0) 。
//你的总得分增加 3 + 5 + 3 = 11 。
//但是你的总得分需要扣除 abs(2 - 1) + abs(1 - 0) = 2 。
//你的最终得分为 11 - 2 = 9 。
// 
//
// 示例 2： 
// 
// 
//输入：points = [[1,5],[2,3],[4,2]]
//输出：11
//解释：
//蓝色格子是最优方案选中的格子，坐标分别为 (0, 1)，(1, 1) 和 (2, 0) 。
//你的总得分增加 5 + 3 + 4 = 12 。
//但是你的总得分需要扣除 abs(1 - 1) + abs(1 - 0) = 1 。
//你的最终得分为 12 - 1 = 11 。
// 
//
// 
//
// 提示： 
//
// 
// m == points.length 
// n == points[r].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 0 <= points[r][c] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 146 👎 0
