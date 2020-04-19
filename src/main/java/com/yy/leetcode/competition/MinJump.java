package com.yy.leetcode.competition;
/**
 * @author youyouhuang
 * @create 2020-04-18
 **/

/**
 * https://leetcode-cn.com/contest/season/2020-spring/problems/zui-xiao-tiao-yue-ci-shu-UGC/
 * <p>
 *
 * </p>
 **/
public class MinJump {

    public int minJump(int[] jump) {
        int len = jump.length;
        //dp[]数组 每一位 代表该位到跳出的最少次数
        int[] dp = new int[len];
        //利用后面的dp[]来决定前面的
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = i + jump[i] >= len ? 1 : dp[i + jump[i]] + 1;
            for (int j = i + 1; j < len && j < i + jump[i] && dp[j] > dp[i]; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[0];
    }
}
