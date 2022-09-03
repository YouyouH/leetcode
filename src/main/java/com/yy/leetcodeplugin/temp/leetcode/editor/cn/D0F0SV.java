  //给定一个由 不同 正整数组成的数组 nums ，和一个目标整数 target 。请从 nums 中找出并返回总和为 target 的元素组合的个数。数组中的
//数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// 
//
// 
// 注意：本题与主站 377 题相同：https://leetcode-cn.com/problems/combination-sum-iv/ 
//
// Related Topics 数组 动态规划 👍 37 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-09-02 22:38:59 
//排列的数目

public class D0F0SV{
    public static void main(String[] args) {
        int[] input = new int[]{10,
                20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650, 660, 670, 680, 690, 700, 710, 720, 730, 740, 750, 760, 770, 780, 790, 800, 810, 820, 830, 840, 850, 860, 870, 880, 890, 900, 910, 920, 930, 940, 950, 960, 970, 980, 990, 111};

        Solution solution = new D0F0SV().new Solution();
        solution.combinationSum4(input, 90);

//        solution.combinationSum4(new int[]{1,2,3}, 4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * 动态规划
     */
    class Solution {

        public int combinationSum4(int[] nums, int target) {
            //动态规划
            //dp[i]表示target为i有几种组合
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i - num >= 0) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }

    /**
     * 记忆化搜索超时了
     */
class Solution2 {
        public int combinationSum4(int[] nums, int target) {
            //带备忘录的搜索
            int[] memo = new int[target];
            int result = traverse(nums, target, memo);
            System.out.println(result);
            return result;
        }

        private int traverse(int[] nums, int target, int[] memo) {

            if (target < 0) {
                //不满足条件
                return 0;
            }

            if (target == 0) {
                return 1;
            }

            if (memo[target-1] != 0) {
                System.out.println("hit memo");
                return memo[target-1];
            }

            int res = 0;

            for (int num : nums) {
                res += traverse(nums, target - num, memo);
            }
            memo[target - 1] = res;

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}