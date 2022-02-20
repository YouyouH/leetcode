//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 11 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-19 19:47:28
//含有重复元素集合的全排列 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SevenP8L0Z{
    public static void main(String[] args) {
         Solution solution = new SevenP8L0Z().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            //看这个分析  https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/

            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];

            //要排序才能判断重复数字然后剪枝
            Arrays.sort(nums);

            traverse(nums, res,new ArrayList<>(),used);
            return res;
        }

        private void traverse(int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp, boolean[] used) {
            //返回全排列，所以当tmp长度达到nums长度的时将tmp加入结果集
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //跳过选过的数字
                if (used[i]) {
                    continue;
                }
                //这里需要剪枝，跳过会重复的结果集。思路看上面的链接。
                //即当前的选取的数字和前一个数字是一样的，并且前面一个数字在当前排列中没有选取，
                //这种情况下，选取当前数字和选前一个数字得到的排列一定是一样的。
                //相反，即使当前数字和前一个数字一样，但是前一个数字也被选了，这种情况是新的排列，不需要跳过
                //所以加一个memo记录选过的数字
                if (i >= 1 && nums[i - 1] == nums[i] && !used[i-1]) {
                    continue;
                }

                tmp.add(nums[i]);
                used[i] = true;

                traverse(nums, res, tmp, used);

                //递归结束后还原
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}