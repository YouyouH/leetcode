//给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺
//序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 35 题相同： https://leetcode-cn.com/problems/search-insert-position/ 
// Related Topics 数组 二分查找 👍 10 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-20 14:06:59
//查找插入位置

public class N6YdxV{
    public static void main(String[] args) {
         Solution solution = new N6YdxV().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        //二分查找,记住模板
        /**
         * https://leetcode-cn.com/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
         * public int searchInsert(int[] nums, int target) {
         *         int left = 0, right = nums.length - 1;
         *         while(left <= right) {
         *             int mid = (left + right) / 2;
         *             if(nums[mid] == target) {
         *                 return mid;
         *             } else if(nums[mid] < target) {
         *                 left = mid + 1;
         *             } else {
         *                 right = mid - 1;
         *             }
         *         }
         *         //为什么返回left???
         *         //因为到最后一次循环的时候，left = mid = right,然后执行left+1,即得到插入点
         *         return left;
         *     }
         *
         * 作者：guanpengchn
         * 链接：https://leetcode-cn.com/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */

        int res = nums.length;

        int lo = 0;

        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}