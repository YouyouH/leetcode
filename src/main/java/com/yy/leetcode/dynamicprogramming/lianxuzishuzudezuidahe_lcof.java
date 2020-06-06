package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-06-06
 **/

/**
 *输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。  要求时间复杂度为O(n)。
 *<p>
 *
 *</p>
 **/
public class lianxuzishuzudezuidahe_lcof {
    public int maxSubArray(int[] nums) {
        //以第n个数结尾的子数组的最大值是dp[n]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i< nums.length;i++){
            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];
            }
        }

        int result = nums[0];
        for(int sum : dp){
            result = Math.max(sum,result);
        }
        return result;

    }
}
