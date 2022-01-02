//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 👍 11 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-01 21:01:25
//含有重复元素集合的组合

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSjJUc{
    public static void main(String[] args) {
         Solution solution = new FourSjJUc().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            sum(candidates, target, new LinkedList<>(), 0,0);
            return res;
        }

        private void sum(int[] candidates,int target,LinkedList<Integer> array,int sum,int start) {
            if (sum == target) {
                res.add(new ArrayList<>(array));
                return;
            }
            if (sum > target) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                //从第二个开始比较，如果跟前面一样的就跳过
                //技巧是不要比较i+1和i，容易溢出
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                array.addLast(candidates[i]);
                sum(candidates, target, array, sum+candidates[i], i+1);
                array.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}