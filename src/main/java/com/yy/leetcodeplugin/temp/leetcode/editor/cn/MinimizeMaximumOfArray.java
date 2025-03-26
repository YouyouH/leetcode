
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-26 13:44:01 
//最小化数组中的最大值

import java.util.Arrays;

public class MinimizeMaximumOfArray{
    public static void main(String[] args) {
         Solution solution = new MinimizeMaximumOfArray().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int minimizeArrayValue(int[] nums) {
                /**
                 * 二分法求最小值。
                 *      检查条件是能否通过不限次数的操作实现所有数都小于等于target
                 */
                int l = Arrays.stream(nums).min().getAsInt();//数组是非负整数，所以最大值的最小值是1.不可能是0，是0的话所有数字都小于等于0.
                int r = Arrays.stream(nums).max().getAsInt();

                int ans = 0;

                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    boolean check = check(mid, nums);
                    if (check) {
                        ans = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                return ans;
            }

            private boolean check(int target, int[] nums) {
                long extra = 0;
                if (nums[0] > target) {
                    return false;
                }
                for (int i = 0; i < nums.length; i++) {
                    extra = target + extra - nums[i];
                    if (extra < 0) {
                        return false;
                    }

                    //FIXME： 太慢了。直接计算差值
//                    while (i < nums.length - 1 && nums[i] < target) {//从第一个数开始增加到target，同时减小第二个数
//                        nums[i]++;
//                        nums[i + 1]--;
//                    }
                }
                return extra >= 0;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。 
//
// 每一步操作中，你需要： 
//
// 
// 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。 
// 将 nums[i] 减 1 。 
// 将 nums[i - 1] 加 1 。 
// 
//
// 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,7,1,6]
//输出：5
//解释：
//一串最优操作是：
//1. 选择 i = 1 ，nums 变为 [4,6,1,6] 。
//2. 选择 i = 3 ，nums 变为 [4,6,2,5] 。
//3. 选择 i = 1 ，nums 变为 [5,5,2,5] 。
//nums 中最大值为 5 。无法得到比 5 更小的最大值。
//所以我们返回 5 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1]
//输出：10
//解释：
//最优解是不改动 nums ，10 是最大值，所以返回 10 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 102 👎 0
