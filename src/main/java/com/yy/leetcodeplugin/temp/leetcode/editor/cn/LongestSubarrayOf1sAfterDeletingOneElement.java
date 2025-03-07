
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-06 13:58:15 
//删掉一个元素以后全为 1 的最长子数组

public class LongestSubarrayOf1sAfterDeletingOneElement{
    public static void main(String[] args) {
         Solution solution = new LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        /**
         * 滑动窗口，最多只包含一个0
         */
        int count = 0;
        int l = 0;
        int ans = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
            }
            if (count < 2) {
                if (count == 0) {
                    ans = Math.max(ans, r - l + 1 - 1);
                } else {
                    ans = Math.max(ans, r - l + 1-count);
                }
            }else{
                //收缩左边界
                while (count > 1) {
                    if (nums[l] == 0 ) {
                        count--;
                    }
                    l++;

                }
            }
        }
        return ans;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 
//输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 要么是 1 。 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 170 👎 0
