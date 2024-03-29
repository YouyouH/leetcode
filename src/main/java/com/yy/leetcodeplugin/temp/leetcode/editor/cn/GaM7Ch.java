  //给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 322 题相同： https://leetcode-cn.com/problems/coin-change/ 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 46 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-08-28 11:56:35 
//最少的硬币数目

public class GaM7Ch{
    public static void main(String[] args) {
         Solution solution = new GaM7Ch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }
            int[] mem = new int[amount];

            //为什么可以记忆化搜索？
            //因为有很多重复计算，例如假如硬币是1，2，3，4，总额是10
            //那么 排列121和112，剩余的都是6.所以6的结果可以缓存下来。

            return traverse(coins, amount,mem);
        }

        private int traverse(int[] coins, int amount, int[] mem) {


            if (amount < 0) {
                return -1;
            }

            if (amount == 0) {
                return 0;
            }

            if(mem[amount-1] != 0){
                return mem[amount-1];
            }

            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                int res = traverse(coins, amount - coin, mem);
                if (res >= 0 && res < min) {
                    min = res + 1;//为什么+1？ 因为当前这个要加上
                }

            }

            mem[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
            return mem[amount-1];

        }

    }


    /**
     * 暴力法：超时了
     */
    class Solution1 {

        int res = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {

            //先用回溯法全部遍历一遍

            traverse(coins, amount,0);

            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }

        public void traverse(int[] coins, int amount, int count) {

            if (amount < 0) {
                return;
            }
            if (amount == 0) {
                res = Math.min(res, count);
                return;
            }

            for (int coin : coins) {
                traverse(coins, amount - coin, count+1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}