
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-01 14:40:33 
//寻找旋转排序数组中的最小值

public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
         Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        /**
         * 时间复杂度要求是logn, 只能用二分法找分界点
         * 分界点的特点，大于左边端点，也大于右边端点。（旋转之后是原数组的不符合这个规律特殊处理）
         */
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println("l=" + l + " mid=" + mid + " r=" + r);
            if (nums[mid] >= nums[0] && nums[mid] <= nums[len - 1]) {
                return nums[0];//说明数组旋转之后还原了
            }
            if (nums[mid] >= nums[0] && nums[mid] >= nums[len - 1]) {//说明mid在左边部分
                ans = mid;//FIXME 为什么在这里赋值ans? 不在下面赋值？ 因为找的是最大值，最后返回的是ans+1
                l = mid + 1;
            }else
            if (nums[mid] <= nums[len - 1] && nums[mid] < nums[0]) {//说明mid在右边部分
                r = mid - 1;
            }
        }
//        System.out.println("ans=" + ans);
        return nums[ans + 1];
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
//化后可能得到：
//
// 
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2] 
// 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7] 
// 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数 互不相同 
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// Related Topics 数组 二分查找 👍 1223 👎 0
