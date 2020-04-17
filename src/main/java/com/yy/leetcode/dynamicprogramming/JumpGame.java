package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-17
 **/

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null){
            return false;
        }
        Boolean[] dp = new Boolean[nums.length];
        return jump(nums, 0, dp);
    }

    private boolean jump(int[] nums, int i, Boolean[] dp) {
        if (i >= nums.length - 1) {
            return true;
        }
        if (i + nums[i] == i) {
            return false;
        }
        boolean result = false;

        if (i + nums[i] > nums.length - 1) {
            return true;
        }
        for (int j = i + nums[i]; j >= i + 1; j--) {
            if (dp[j] == null) {
                dp[j] = jump(nums, j, dp);
            }
            result = result || dp[j];
        }
        return result;
    }
}