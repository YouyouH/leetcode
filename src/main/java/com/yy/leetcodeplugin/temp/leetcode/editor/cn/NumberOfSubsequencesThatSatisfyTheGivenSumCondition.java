
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-17 17:16:31 
//满足条件的子序列数目

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition{
    public static void main(String[] args) {
         Solution solution = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
            public int numSubseq(int[] nums, int target) {
                /**
                 * 索引不同就算不同的子序列
                 * 双指针指向左右端点
                 * 1.对数组排序
                 * 2.两个指针加起来大于target的时候右指针收缩。
                 *      1.收缩到值加起来小于target的时候计算子序列数目。 然后收缩左指针
                 *          怎么计算子序列数目？
                 *              两个数之间有几个数，就是2的几次方. 每个数可以有存在和不存在两种情况，所以就是2
                 *  FIXME 思路大致正确，代码是看的答案再写出来的
                 */
                int length = nums.length;
                Arrays.sort(nums);
                //建立一个2的次方的缓存，因为计算子序列数目的时候要用
                int[] cache = new int[length];
                cache[0] = 1;//2的0次方
                for (int i = 1; i < length; i++) {
                    cache[i] = (cache[i - 1] * 2) % MOD;
                }

                int l = 0;
                int r = length - 1;
                int res = 0;
                while (l <= r) {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    }else{
                        //符合条件，开始计算子序列数目
                        res = (res + cache[r - l]) % MOD;
                        //计算完之后收缩l
                        l++;
                    }
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums 和一个整数 target 。 
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 
//
// 由于答案可能很大，请将结果对
// 10⁹ + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// 示例 3： 
//
// 
//输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= target <= 10⁶ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 159 👎 0
