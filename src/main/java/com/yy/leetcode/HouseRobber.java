package com.yy.leetcode;

/**
 * @author youyouhuang
 * @create 2019-09-19
 * @desc
 **/

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if(null == nums || 0 ==nums.length){
            return 0;
        }
        int size = nums.length;
        if(size == 1){
            return nums[0];
        }
        int[] memo = new int[2];
        int result = nums[0];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0],nums[1]);
        if(size <3){
            return Math.max(memo[0],memo[1]);
        }
        for(int i =3;i<=size;i++){
            result = Math.max(memo[0]+nums[i-1], memo[1]);
            memo[0] = memo[1];
            memo[1] = result;
        }
        return result;
    }
}
