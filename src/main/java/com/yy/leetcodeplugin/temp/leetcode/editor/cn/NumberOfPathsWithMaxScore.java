
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-02 22:32:59 
//最大得分的路径数目

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class NumberOfPathsWithMaxScore{
    public static void main(String[] args) {
         Solution solution = new NumberOfPathsWithMaxScore().new Solution();
        solution.pathsWithMaxScore(Arrays.asList("E23", "2X2", "12S"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int MOD = 1_000_000_000 + 7;
    public int[] pathsWithMaxScore(List<String> board) {
        /**
         * 动态规划
         *  三个方向值求最大值
         */
        int m = board.size();
        int n = board.get(0).length();

        long[][] dp = new long[m][n];

        long[][] count = new long[m][n];//记录到达每一个点的方案数

        count[m - 1][n - 1] = 1;//起始点方案数为1.

        dp[m - 1][n - 1] = 0;//起点是S，值设为0

        boolean block = false;
        //处理最后一列
        for (int i = m - 2; i >= 0; i--) {
            char c = board.get(i).charAt(n - 1);
            if (c == 'X' || block) {
                count[i][n - 1] = 0;//有障碍物就不可到达
                dp[i][n - 1] = -1;
//                System.out.println("m=" + i + " n=" + (n - 1) + " val=" + dp[i][n - 1]);
//                System.out.println("m=" + i + " n=" + (n - 1) + " count=" + count[i][n - 1]);
                block = true;
                continue;
            }
            count[i][n - 1] = 1;//没有障碍物就只有一个方案可以到达
            dp[i][n - 1] = dp[i + 1][n - 1] + c - '0';

//            if (count[i][n - 1] < 0) {
//                System.out.println("count[i][n - 1]");
//            }
//            System.out.println("m=" + i + " n=" + (n - 1) + " val=" + dp[i][n - 1]);
//            System.out.println("m=" + i + " n=" + (n - 1) + " count=" + count[i][n - 1]);
        }
        System.out.println("stage1");

        block = false;
        for (int i = n - 2; i >= 0; i--) {
            char c = board.get(m - 1).charAt(i);
            if (c == 'X' || block) {
                count[m - 1][i] = 0;//有障碍物就不可到达
                dp[m - 1][i] = -1;
//                System.out.println("m=" + (m-1) + " n=" + i + " val=" + dp[m - 1][i]);
//                System.out.println("m=" + (m-1) + " n=" + i + " count=" + count[m - 1][i]);
                block = true;
                continue;
            }
            count[m - 1][i] = 1;//没有障碍物就只有一个方案可以到达
            dp[m - 1][i] = dp[m - 1][i + 1] + c - '0';
            if (count[m - 1][i] < 0) {
                System.out.println("count[m - 1][i]");
            }
//            System.out.println("m=" + (m-1) + " n=" + i + " val=" + dp[m - 1][i]);
//            System.out.println("m=" + (m-1) + " n=" + i + " count=" + count[m - 1][i]);
        }
        System.out.println("stage2");


        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X') {
                    dp[i][j] = -1;
//                    System.out.println("m=" + i + " n=" + j + " val=" + dp[i][j]);
//                    System.out.println("m=" + i + " n=" + j + " count=" + count[i][j]);
                    continue;
                }
                long max = Math.max(dp[i][j + 1], Math.max(dp[i + 1][j], dp[i + 1][j+1]));
                if (max == -1) {
                    dp[i][j] = -1;
//                    System.out.println("m=" + i + " n=" + j + " val=" + dp[i][j]);
//                    System.out.println("m=" + i + " n=" + j + " count=" + count[i][j]);
                    continue;
                }
                if (c == 'E') {
                    c = '0';//遇到终点
                }

                if (c == 'S') {
                    c = '0';//遇到起点
                }
                dp[i][j] = c - '0' + max;//周围三个方向的最大值

                //有几个最大值就把对应的方案数加上
                if (dp[i][j + 1] == max) {
                    count[i][j]+=count[i][j+1] % MOD;
                }
                if (dp[i + 1][j] == max) {
                    count[i][j]+=count[i + 1][j] % MOD;
                }
                if (dp[i + 1][j+1] == max) {
                    count[i][j]+=count[i + 1][j+1] % MOD;
                }

                if (count[i][j] < 0) {
                    System.out.println("count[i][j]");
                }
//
//                System.out.println("m=" + i + " n=" + j + " count=" + count[i][j]);
//                System.out.println("m=" + i + " n=" + j + " val=" + dp[i][j]);
            }
        }

        return dp[0][0] == -1 ? new int[]{0, 0} : new int[]{(int) (dp[0][0] % MOD), (int) (count[0][0] % MOD)};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个正方形字符数组 board ，你从数组最右下方的字符 'S' 出发。 
//
// 你的目标是到达数组最左上角的字符 'E' ，数组剩余的部分为数字字符 1, 2, ..., 9 或者障碍 'X'。在每一步移动中，你可以向上、向左或者左上
//方移动，可以移动的前提是到达的格子没有障碍。 
//
// 一条路径的 「得分」 定义为：路径上所有数字的和。 
//
// 请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对 10^9 + 7 取余。 
//
// 如果没有任何路径可以到达终点，请返回 [0, 0] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = ["E23","2X2","12S"]
//输出：[7,1]
// 
//
// 示例 2： 
//
// 
//输入：board = ["E12","1X1","21S"]
//输出：[4,2]
// 
//
// 示例 3： 
//
// 
//输入：board = ["E11","XXX","11S"]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= board.length == board[i].length <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 91 👎 0