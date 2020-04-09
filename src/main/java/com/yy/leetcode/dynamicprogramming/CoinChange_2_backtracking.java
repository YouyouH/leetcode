package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-08
 **/

import java.util.Arrays;
import java.util.stream.Collectors;

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
public class CoinChange_2_backtracking {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }

        Arrays.sort(coins);
        coins = Arrays.stream(coins).sorted().filter(c->c<=amount).toArray();

        int[] dp = new int[amount];

        int result = coin(coins, amount, 0, dp);

        return result > 999999 ? -1 : result;

    }

    private int coin(int[] coins, int amount, int tempAmount, int[] dp) {
        if (tempAmount == amount) {
            return 0;
        }
        if (tempAmount > amount) {
            return 999999;
        }
        int min = Integer.MAX_VALUE;
        if(dp[tempAmount] != 0){
            return dp[tempAmount];
        }
        for (int i = 0; i < coins.length; i++) {
            min = Math.min(min, 1 + coin(coins, amount, tempAmount + coins[i], dp));
        }
        dp[tempAmount] = min;
        return min;
    }
}
