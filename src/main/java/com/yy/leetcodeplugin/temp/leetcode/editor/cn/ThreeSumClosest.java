
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-09 19:36:38 
//最接近的三数之和

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args) {
         Solution solution = new ThreeSumClosest().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
//                System.out.println("i=" + i + " l=" + l + " r=" + r + " sum=" + sum);
                if (sum == target) {
                    //题目假定只有一个解
                    return target;
                }
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }

                if (sum > target) {
                    while (r > l && nums[r] == nums[r-1]) r--;
                    r--;
                }else{
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
//解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1708 👎 0
