
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-10 10:32:19 
//最接近目标价格的甜点成本

import java.util.Arrays;

public class ClosestDessertCostTest {
    public static void main(String[] args) {
         Solution solution = new ClosestDessertCostTest().new Solution();
        solution.closestCost(new int[]{1,7}, new int[]{3,4}, 16);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
                int x = Arrays.stream(baseCosts).min().getAsInt();
                //基料最小值大于成本，直接返回最小值
                if (x >= target) {
                    return x;
                }
                boolean[] can = new boolean[target + 1];

                //res表示在大于成本的情况下最接近成本的值。
                // 对于最接近成本的值，可能大于成本可能小于成本，如果大于成本那么最大值也不会超过2 * target - x (即 res - target < target -x)，否则直接用基料肯定更接近成本
                int res = 2 * target - x;
                for (int b : baseCosts) {
                    if (b <= target) {
                        can[b] = true;//直接用基料
                    } else {
                        res = Math.min(res, b);//求在大于成本的情况下最接近成本的值
                    }
                }

                for (int t : toppingCosts) {
                    for (int count = 0; count < 2; ++count) {
                        /**
                         * FIXME
                         *  怎么理解从后往前遍历can[i]?
                         *      第一轮先把t能凑出的target求出来
                         *      第二轮再上一轮的基础上接着算，相当于滚动数组。例如上一轮求出来can[10] = true，那么这一轮计算到can[13]的时候， can[13] = can[13-3] = can[10] = true。
                         *  为什么要从后往前遍历can[i]?
                         *      如果正向遍历，dp[4] = true, dp[7] = dp[7-3] = true, dp[10] = dp[10-3] = true，正向遍历相当于多加了配料
                         *
                         */

                        for (int i = target; i > 0; --i) {
                            if (can[i] && i + t > target) {
                                res = Math.min(res, i + t);//在大于成本的情况下最接近成本的值
                            }
                            if (i - t > 0) {
                                can[i] = can[i] || can[i - t];
                                System.out.println("配料=" + t + " 成本=" + i + "可行？" + can[i]);
                            }
                        }
                    }
                }
                for (int i = 0; i <= res - target; ++i) {//res - target表示离成本的距离
                    if (can[target - i]) {
                        return target - i;//在小于成本的情况下最接近成本的值
                    }
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则： 
//
// 
// 必须选择 一种 冰激凌基料。 
// 可以添加 一种或多种 配料，也可以不添加任何配料。 
// 每种类型的配料 最多两份 。 
// 
//
// 给你以下三个输入： 
//
// 
// baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。 
// toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。 
// target ，一个整数，表示你制作甜点的目标价格。 
// 
//
// 你希望自己做的甜点总成本尽可能接近目标价格 target 。 
//
// 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。 
//
// 
//
// 示例 1： 
//
// 
//输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
//输出：10
//解释：考虑下面的方案组合（所有下标均从 0 开始）：
//- 选择 1 号基料：成本 7
//- 选择 1 份 0 号配料：成本 1 x 3 = 3
//- 选择 0 份 1 号配料：成本 0 x 4 = 0
//总成本：7 + 3 + 0 = 10 。
// 
//
// 示例 2： 
//
// 
//输入：baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
//输出：17
//解释：考虑下面的方案组合（所有下标均从 0 开始）：
//- 选择 1 号基料：成本 3
//- 选择 1 份 0 号配料：成本 1 x 4 = 4
//- 选择 2 份 1 号配料：成本 2 x 5 = 10
//- 选择 0 份 2 号配料：成本 0 x 100 = 0
//总成本：3 + 4 + 10 + 0 = 17 。不存在总成本为 18 的甜点制作方案。
// 
//
// 示例 3： 
//
// 
//输入：baseCosts = [3,10], toppingCosts = [2,5], target = 9
//输出：8
//解释：可以制作总成本为 8 和 10 的甜点。返回 8 ，因为这是成本更低的方案。
// 
//
// 示例 4： 
//
// 
//输入：baseCosts = [10], toppingCosts = [1], target = 1
//输出：10
//解释：注意，你可以选择不添加任何配料，但你必须选择一种基料。 
//
// 
//
// 提示： 
//
// 
// n == baseCosts.length 
// m == toppingCosts.length 
// 1 <= n, m <= 10 
// 1 <= baseCosts[i], toppingCosts[i] <= 10⁴ 
// 1 <= target <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 回溯 👍 185 👎 0
