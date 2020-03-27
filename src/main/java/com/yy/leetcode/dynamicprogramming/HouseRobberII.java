package com.yy.leetcode.dynamicprogramming;

/**
 * @author youyouhuang
 * @create 2019-09-19
 * @desc https://leetcode.com/problems/house-robber-ii/
 **/

public class HouseRobberII {

    public int rob(int[] nums) {
        if(null == nums || 0 ==nums.length){
            return 0;
        }
        int size = nums.length;
        if(size < 4) {
            int tmp = 0;
            for (int num : nums) {
                if (num > tmp) {
                    tmp = num;
                }
            }
            return tmp;
        }

        int[] memo = new int[2];
        int result0 = 0;
        int result = 0;

        //stole the first house(so skip the last one)
        memo[0] = nums[0];
        memo[1] = nums[0];

        for(int i =4;i<=size;i++){
            result0 = Math.max(memo[0]+nums[i-2], memo[1]);
            memo[0] = memo[1];
            memo[1] = result0;
        }

        //stole the last house(so skip the first one)
        memo[0] = nums[1];
        memo[1] = Math.max(nums[1],nums[2]);

        for(int i =4;i<=size;i++){
            result = Math.max(memo[0]+nums[i-1], memo[1]);
            memo[0] = memo[1];
            memo[1] = result;
        }

        return Math.max(result,result0);
    }
}
