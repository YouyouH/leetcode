package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-05-24
 **/

/**
 *给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *<p>
 *
 *</p>
 **/
public class IntegerBreak {

    //F(n) = max(1*F(N-1),2*F(N-2),3*F(N-3)....)
    //动态规划方程式： Math.max(Math.max(j*(i-j),j*memo[i-j]),memo[i]);
    //绳子可以剪（j*memo[i-j]） 也可以不剪（j*(i-j)）
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] memo = new int[n+1];
        memo[1] = 1;//?
        memo[2] = 1;
        memo[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(Math.max(j*(i-j),j*memo[i-j]),memo[i]);
            }
        }
        return memo[n];
    }
}
