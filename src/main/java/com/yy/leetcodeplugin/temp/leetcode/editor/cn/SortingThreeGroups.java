
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-27 21:16:52 
//将三个组排序

import java.util.List;

public class SortingThreeGroups{
    public static void main(String[] args) {
         Solution solution = new SortingThreeGroups().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(List<Integer> nums) {
        /**
         * 跟求最长递增子序列类似
         */
        int size = nums.size();
        int[] dp = new int[size];
        int ans = 1;
        for (int i = 0; i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }else{
                    //第i个数组不能接在j后面，跳过
                }
            }
            ans = Math.max(ans, dp[i]);
            System.out.println("i=" + i + " value=" + dp[i]);
        }
        return size - ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums 。nums 的每个元素是 1，2 或 3。在每次操作中，你可以删除 nums 中的一个元素。返回使 nums 成为 非递减 顺序
//所需操作数的 最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3,2,1]
//输出：3
//解释：
//其中一个最优方案是删除 nums[0]，nums[2] 和 nums[3]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,1,3,3]
//输出：2
//解释：
//其中一个最优方案是删除 nums[1] 和 nums[2]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,2,2,2,3,3]
//输出：0
//解释：
//nums 已是非递减顺序的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 3 
// 
//
// 进阶：你可以使用 O(n) 时间复杂度以内的算法解决吗？ 
//
// Related Topics 数组 二分查找 动态规划 👍 23 👎 0
