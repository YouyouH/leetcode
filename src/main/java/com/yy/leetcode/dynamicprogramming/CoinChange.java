package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-08
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>给定不同面额的硬币 coins 和一个总金额 amount。
 * <p>编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * <p>如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>示例 1:
 * <p>输入: coins = [1, 2, 5], amount = 11
 * <p>输出: 3
 * <p>解释: 11 = 5 + 5 + 1
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * <p>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CoinChange {
    int totalStep = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);

        int[] dp = new int[amount];
        totalStep = Integer.MAX_VALUE;
        coin(coins, amount, 0, dp, 0);

        return totalStep == Integer.MAX_VALUE ? -1 : totalStep;

    }

    private void coin(int[] coins, int amount, int tempAmount, int[] dp, int step) {
        if (tempAmount == amount) {
            totalStep = Math.min(step, totalStep);
            return;
        }
        if (tempAmount > amount) {
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            coin(coins, amount, tempAmount + coins[i], dp, step + 1);
        }

    }
}
