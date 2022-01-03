//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 30 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-03 17:26:03
//数组中和为 0 的三个数

import java.util.*;

public class OneFGaJU{
    public static void main(String[] args) {

        Solution solution = new OneFGaJU().new Solution();
        solution.threeSum(new int[]{1, 1, -2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length <3) {
            return res;
        }
        Arrays.sort(nums);
        //两个指针一前一后指向b和c，相向而行，直到相遇
        //从头开始遍历a
        for (int i = 0; i < length - 2; i++) {
            //技巧： 比较和前一个数相等就跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    //继续相向而行直到相遇
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) l++;
                else if (nums[i] + nums[l] + nums[r] > 0) r--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}