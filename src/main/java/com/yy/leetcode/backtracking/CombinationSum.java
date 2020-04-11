package com.yy.leetcode.backtracking;
/**
 * @author youyouhuang
 * @create 2020-04-11
 **/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:  输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为: [   [7],   [2,2,3] ]
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();
        if(null == candidates ||candidates.length == 0){
            return results;
        }

        combination(candidates, target, 0, new ArrayList<Integer>(), results,0);

        return results;
    }

    private void combination(int[] candidates, int target, int sum, ArrayList<Integer> integers, List<List<Integer>> results, int start) {
        if (sum == target) {
            results.add(new ArrayList<>(integers));
            return;
        }
        if(sum > target){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            integers.add(candidates[i]);
            combination(candidates, target, sum+candidates[i], integers, results, i);
            integers.remove(integers.size() - 1);
        }
    }
}
