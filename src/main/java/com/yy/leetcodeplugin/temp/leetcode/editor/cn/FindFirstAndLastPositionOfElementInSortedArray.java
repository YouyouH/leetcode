
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-23 21:21:09 
//在排序数组中查找元素的第一个和最后一个位置

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
         Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
         * 二分法找到目标值，再向两边找边界
         */
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1,-1};
        }
        int l = 0;
        int r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
//            System.out.println("l=" + l + " r=" + r + " mid=" + mid);
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //找到target了
        int i = (l + r) / 2;
        if (nums[i] != target) {
            return new int[]{-1,-1};
        }
//        System.out.println(i);
        while (i >= 0 && nums[i] == target) {
            i--;
        }
//        System.out.println(i);
        int[] res = new int[2];
        res[0] = ++i;
        i = (l + r) / 2;
        while (i < length && nums[i] == target) {
            i++;
        }
//        System.out.println(i);
        res[1] = --i;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2955 👎 0
