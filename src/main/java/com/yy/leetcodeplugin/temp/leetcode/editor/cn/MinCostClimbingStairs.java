
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2024-12-25 15:28:06 
//使用最小花费爬楼梯

import java.util.ArrayList;
import java.util.Arrays;

public class MinCostClimbingStairs{
    public static void main(String[] args) {
         Solution solution = new MinCostClimbingStairs().new Solution();
         System.out.println(solution.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * 动态规划
         *      为什么可以用动态规划？
         *        爬到第五层的最小花费只与爬到第四层的最小花费和爬到第三层的最小花费有关
         *
         * dp[i]表示跨过下标为i的台阶的最小花费，注意dp[0]/dp[1] 花费都是0.
         * dp[5] 表示到达下标为5（第六级台阶）的台阶。 dp[5] = min(dp[3]+cost[3]+ cost[5], dp[4]+cost[4])
         *
         *  dp[i] = Math.min(dp[i - 2] + cost[i - 2] + cost[i], dp[i - 1] + cost[i - 1]); //到达i-2之后再爬两级+cost[i] (必须跨过i)，或者到达i-1之后再爬两级(跨过i)
         */
        if (cost.length == 0 || cost.length == 1) {
            return 0;
        }

        int[] dp = new int[cost.length+1]; //为什么要取+1？ 看示例2，到达下标为9的台阶后还在再爬一级到楼梯顶部

        //起始点可以选择第一或者第二级台阶
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            //i-2 不用再加上cost[i], （dp[i - 2] + cost[i - 2]）表示已经到达dp[i]了，不用再从dp[i]往上了
//            dp[i] = Math.min(dp[i - 2] + cost[i - 2] + cost[i], dp[i - 1] + cost[i - 1]);
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[cost.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// Related Topics 数组 动态规划 👍 1586 👎 0
