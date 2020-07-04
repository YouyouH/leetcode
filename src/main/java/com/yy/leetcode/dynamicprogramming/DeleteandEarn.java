package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-07-04
 **/

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 *给定一个整数数组 nums ，你可以对它进行一些操作。  每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。  开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/delete-and-earn 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class DeleteandEarn {

    //转换成打家劫舍问题
    public int deleteAndEarn(int[] nums) {

        if(null == nums || nums.length == 0){
            return 0;
        }

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        //打家劫舍：不能打劫相邻的，所以如果打劫第i家，则等于第i-2家加上当前的；如果不打劫第i家，则等于第i-1家的最优解。
        int[] input = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            input[nums[i]] += 1;
        }

        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = 1 * input[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + i * input[i]);
        }

        return dp[max];
    }
    //深度遍历
    //复杂度太高了
    public int deleteAndEarn2(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int[] deleted = new int[length];
        Function<Integer, Integer> increase = i -> i + 1;
        Function<Integer, Integer> decrease = i -> i - 1;
        return earn(0,nums,deleted,increase,decrease);
    }

    private int earn(int start, int[] nums, int[] deleted, Function<Integer, Integer> increase, Function<Integer, Integer> decrease) {
        int max = 0;
        Set<Integer> memo = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(deleted[i] != 0 || memo.contains(nums[i])){
                continue;
            }
            deleted[i] = 1;
            memo.add(nums[i]);
            update(nums[i], nums,deleted,increase);
            max = Math.max(max,nums[i] + earn(i+1, nums,deleted, increase, decrease));
            deleted[i] = 0;
            update(nums[i], nums,deleted,decrease);
        }
        return max;
    }

    private void update(int num, int[] nums, int[] deleted, Function<Integer, Integer> update) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == num-1 || nums[i] == num+1){
                deleted[i] = update.apply(deleted[i]);
            }
        }
    }
}
