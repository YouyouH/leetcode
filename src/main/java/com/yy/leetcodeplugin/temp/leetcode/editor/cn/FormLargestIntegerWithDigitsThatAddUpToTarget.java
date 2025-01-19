
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-17 17:47:33 
//数位成本和为目标值的最大数字

import java.util.Arrays;

public class FormLargestIntegerWithDigitsThatAddUpToTarget{
    public static void main(String[] args) {
         Solution solution = new FormLargestIntegerWithDigitsThatAddUpToTarget().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public String largestNumber(int[] cost, int target) {
                /**
                 * 完全背包问题:
                 *  1. 物品是1-9，每个物品价值是cost[i],值必须等于target.
                 *
                 *  FIXME 注意是刚好等于，不是小于等于target，所以如果凑不出的情况要设置为MIN
                 */
                String[][] dp = new String[10][target + 1];

                //初始化
                Arrays.fill(dp[0], "0");//用0表示不可能
                dp[0][0] = "";//空字符串相当于0

                for (int i = 1; i < 10; i++) {
                    for (int j = 0; j < target + 1; j++) {
                        if (j - cost[i - 1] >= 0) {
                            if (dp[i][j - cost[i - 1]].equals("0")) {
                                dp[i][j] = dp[i - 1][j];
                                continue;
                            }
                            dp[i][j] = max(dp[i - 1][j], String.valueOf(i).concat(dp[i][j - cost[i - 1]]));
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
//                System.out.println("i=" + i + " j=" + j + " value=" + dp[i][j]);
                    }
                }
                return dp[9][target];
            }

            private String max(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2) >= 0 ? s1 : s2;
                }

                return s1.length() > s2.length() ? s1 : s2;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数： 
//
// 
// 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。 
// 总成本必须恰好等于 target 。 
// 添加的数位中没有数字 0 。 
// 
//
// 由于答案可能会很大，请你以字符串形式返回。 
//
// 如果按照上述要求无法得到任何整数，请你返回 "0" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
//输出："7772"
//解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要
//求的数字，但 "7772" 是较大的数字。
// 数字     成本
//  1  ->   4
//  2  ->   3
//  3  ->   2
//  4  ->   5
//  5  ->   6
//  6  ->   7
//  7  ->   2
//  8  ->   5
//  9  ->   5
// 
//
// 示例 2： 
//
// 
//输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
//输出："85"
//解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
// 
//
// 示例 3： 
//
// 
//输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
//输出："0"
//解释：总成本是 target 的条件下，无法生成任何整数。
// 
//
// 示例 4： 
//
// 
//输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
//输出："32211"
// 
//
// 
//
// 提示： 
//
// 
// cost.length == 9 
// 1 <= cost[i] <= 5000 
// 1 <= target <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 192 👎 0
