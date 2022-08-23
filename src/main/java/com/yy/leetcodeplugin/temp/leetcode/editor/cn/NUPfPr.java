  //给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
//
// Related Topics 数学 字符串 模拟 👍 54 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-08-14 14:09:45 
//分割等和子集

  import java.util.Arrays;

  public class NUPfPr{
    public static void main(String[] args) {
         Solution solution = new NUPfPr().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        //转化为0-1 背包问题
        //0-1的意思就是一个数要么选要么不选
        //状态-：前i个数 状态二：背包容量为j。dp[i][j]表示是否可以装满
        //选择: 装进背包或者不装进背包
        //最后的答案是：dp[数组长度][数组和的二分之一]
        //dp[0][j] = false
        //dp[i][0] = true

        long count = Arrays.stream(nums).sum();
        if (count % 2 != 0) {
            return false;
        }

        int length = nums.length;
        int t = (int) (count / 2);

        boolean[][] dp = new boolean[length+1][t+1];
        for (int i = 0; i <= length ; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= t; j++) {
                if (j - nums[i-1] < 0) {
                    //背包容量不足，不能装nums[i-1]了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //dp[i - 1][j]：不选当前的数，能否装满容量j。如果能装满，那么选了当前的数也能装满
                    //dp[i - 1][j - nums[t]] :  表示不选当前的数，能否装满j - nums[t]。
                    // 如果能装满，那选当前的数就能装满j。如果装不满，那选当前的数也装不满
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];

                }
            }
        }
        return dp[length][t];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}