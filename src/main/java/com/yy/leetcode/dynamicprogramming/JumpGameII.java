package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-19
 **/

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。  数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 **/
public class JumpGameII {
    public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];

            //总是可以跳到最后一个位置所以从倒数第二个开始
            for (int i = nums.length - 2; i >= 0; i--) {
                if(nums[i] == 0){
                    dp[i] = nums.length+1;
                    continue;
                }
                int maxLength = i + nums[i];
                if (maxLength >= nums.length - 1) {
                    dp[i] = 1;
                } else {
                    int temp = nums.length+1;
                    for (int j = i+1; j <= i + nums[i] ; j++) {
                        temp = Math.min(temp,dp[j]) ;
                    }
                    dp[i] = temp+1;

                }
            }
            return dp[0];
    }
}
