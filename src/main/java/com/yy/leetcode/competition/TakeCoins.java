package com.yy.leetcode.competition;
/**
 * @author youyouhuang
 * @create 2020-04-18
 **/

/**
 * <p>
 *
 * </p>
 **/
public class TakeCoins {
    public int minCount(int[] coins) {
        if(coins == null){
            return 0;
        }
        int result = 0;
        for (int coin : coins) {
            if(coin == 0){
                continue;
            }
            result += coin / 2;
            if (coin % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}
