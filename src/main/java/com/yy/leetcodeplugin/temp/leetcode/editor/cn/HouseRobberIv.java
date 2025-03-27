
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-26 16:56:17 
//打家劫舍 IV

import java.util.Arrays;

public class HouseRobberIv{
    public static void main(String[] args) {
         Solution solution = new HouseRobberIv().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int minCapability(int[] nums, int k) {
                /**
                 * 二分查找窃取能力的最小值- 偷窃房屋的最大值的最小值
                 *      需要检查的是能否在只偷最大金额小于target的情况下偷窃K间房，即检查是否有至少不相邻的K间房，房间的最大金额小于等于target
                 *          怎么检查小于target的不相邻房间数量？
                 *              遍历房子。统计连续符合条件的房子数量，除以2向上取整。例如3个就是2，4个也是2.
                 */
                int l = Arrays.stream(nums).min().getAsInt();
                int r = Arrays.stream(nums).max().getAsInt();

                int ans = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (check(mid, nums) >= k) {
                        ans = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                return ans;
            }

            //FIXME:速度慢了(因为有除法？)，换成DP（每个房间偷或者不偷）/或者贪心（遇到符合条件就先偷）
            private int check2(int target, int[] nums) {
                int total = 0;

                int l = 0;
                while (l < nums.length) {
                    int count = 0;
                    while (l < nums.length && nums[l] <= target) {
                        count++;
                        l++;
                    }
                    if (count > 0) {
                        total += (count + 1) / 2;//向上取整 count + 2 - 1
                    }
                    l++;
                }
                return total;
            }

            //贪心算法，没有除法快很多
            private int check(int target, int[] nums) {
                int total = 0;

                int l = 0;
                while (l < nums.length) {
                    if (nums[l] <= target) {
                        total++;
                        l++;
                    }
                    l++;
                }
                return total;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。 
//
// 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。 
//
// 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。 
//
// 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。 
//
// 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。 
//
// 返回小偷的 最小 窃取能力。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,5,9], k = 2
//输出：5
//解释：
//小偷窃取至少 2 间房屋，共有 3 种方式：
//- 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
//- 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
//- 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
//因此，返回 min(5, 9, 9) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9,3,1], k = 2
//输出：2
//解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= (nums.length + 1)/2 
// 
//
// Related Topics 数组 二分查找 👍 238 👎 0
