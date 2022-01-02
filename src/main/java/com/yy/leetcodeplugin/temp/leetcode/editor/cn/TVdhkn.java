//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
// Related Topics 位运算 数组 回溯 👍 10 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-02 14:56:17
//所有子集

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TVdhkn{
    public static void main(String[] args) {
         Solution solution = new TVdhkn().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            sets(nums,0,new LinkedList<Integer>());
            return res;
        }

        private void sets(int[] nums, int start, LinkedList<Integer> array) {
            res.add(new ArrayList<>(array));

            if (start == nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                array.addLast(nums[i]);
                sets(nums, i + 1, array);
                array.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}