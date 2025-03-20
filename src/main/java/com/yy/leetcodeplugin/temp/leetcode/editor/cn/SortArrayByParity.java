
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-20 15:09:53 
//按奇偶排序数组

public class SortArrayByParity{
    public static void main(String[] args) {
         Solution solution = new SortArrayByParity().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] % 2 == 0) {//遇到偶数就跟慢指针替换
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
            r++;
        }
        return nums;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
//
// Related Topics 数组 双指针 排序 👍 404 👎 0
