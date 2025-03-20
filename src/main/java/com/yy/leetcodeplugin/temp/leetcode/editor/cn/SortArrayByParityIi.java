
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-20 15:32:11 
//按奇偶排序数组 II

public class SortArrayByParityIi{
    public static void main(String[] args) {
         Solution solution = new SortArrayByParityIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        /**
         * 做法有点麻烦，看答案有更简单的
         */
        int l = 0;
        int r = 0;
        int length = nums.length;
        while (r < length) {
//            System.out.println("l=" + l + " r=" + r);
            if ((l % 2 == 0 && nums[r] % 2 == 0) || (l % 2 == 1 && nums[r] % 2 == 1)) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r = l + 1;
                continue;
            }
            r++;
        }
        return nums;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个非负整数数组 nums， nums 中一半整数是 奇数 ，一半整数是 偶数 。 
//
// 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。 
//
// 你可以返回 任何满足上述条件的数组作为答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁴ 
// nums.length 是偶数 
// nums 中一半是偶数 
// 0 <= nums[i] <= 1000 
// 
//
// 
//
// 进阶：可以不使用额外空间解决问题吗？ 
//
// Related Topics 数组 双指针 排序 👍 331 👎 0
