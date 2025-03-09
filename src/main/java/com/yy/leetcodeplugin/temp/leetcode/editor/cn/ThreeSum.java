
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-09 10:50:18 
//三数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
         Solution solution = new ThreeSum().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 1.排序
         * 2.双层循环
         */
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(",");
        }
        System.out.println(sb);

        int length = nums.length;

        for (int i = 0; i < length-2; i++) {
//            System.out.println("---i=" + i);
            if (nums[i] > 0) {
                continue;
            }
            //FIXME：比较前一个，而不是后一个，这样假如遇到两个相同的数才有机会被检查一遍
            if (i -1 >=0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = length-1;
//            System.out.println("---i=" + i + " l=" + l + " r=" + r);
            List<Integer> temp = new ArrayList<>();
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
//                System.out.println("i=" + i + " l=" + l + " r=" + r + " sum=" + sum);
//                System.out.println("---i=" + nums[i] + " l=" + nums[l] + " r=" + nums[r] + " sum=" + sum);
                //-4 -1 -1 0 1 2
                //-1 -1 0 1
                //-1 -1 0 1
                //-10,-5,-5,-4,-4,-3,-2,-2,0,0,1,2,2,2,2,5,5,
                if (sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(new ArrayList<>(temp));
                    temp.clear();
                    //fixme: 下面这一段是抄的。
                    // 把重复的值跳过
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    //找到之后收缩左右指针，继续找
                    l++;
                    r--;
                    continue;
                }

                if (sum > 0) {
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 7345 👎 0
