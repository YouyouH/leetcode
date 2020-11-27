package com.yy.leetcode.unclear;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangyou
 */
public class findfirstandlastpositionofelementinsortedarray {
    public int[] searchRange(int[] nums, int target) {

        if(null == nums || nums.length == 0) return new int[]{-1, -1};

        int length = nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                int l = mid - 1;
                int r = mid + 1;
                while (l >= 0 && nums[l] == target) l--;
                while (r <= nums.length - 1 && nums[r] == target) r++;
                return new int[]{l+1, r-1};

            }
            //边界条件,避免陷入死循环
            if (nums[mid] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }

        }
        return new int[]{-1, -1};

    }
}
