package com.yy.leetcode.backtracking;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangyou
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //todo: handle duplicates
        candidates = Arrays.stream(candidates).filter(num -> num <= target).sorted().toArray();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> used = new ArrayList<>();
        combination(candidates, used, result, 0, 0, target);

        return result;
    }


    private void combination(int[] candidates, List<Integer> used, List<List<Integer>> result, int start, int sum, int target) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(used);
            result.add(temp);
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            used.add(candidates[i]);
            sum += candidates[i];
            combination(candidates, used, result, i + 1, sum, target);
            used.remove(used.size() - 1);
            sum -= candidates[i];

        }
    }
}
