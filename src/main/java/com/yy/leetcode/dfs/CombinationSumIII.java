package com.yy.leetcode.dfs;
/**
 * @author youyouhuang
 * @create 2020-04-26
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
 * 说明：      所有数字都是正整数。     解集不能包含重复的组合。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (k == 0 || n == 0) {
            return results;
        }
        combination(0, 0, k, n, new ArrayList<>(), results, 1);
        return results;
    }

    private void combination(int tempK, int tempSum, int k, int n, List<Integer> tmpResult, List<List<Integer>> result, int pre) {
        if (tempK >= k) {
            if (tempSum == n) {
                result.add(new ArrayList<>(tmpResult));
            }
            return;
        }

        for (int i = pre; i < 10; i++) {
            tmpResult.add(i);
            combination(tempK + 1, tempSum + i, k, n, tmpResult, result, i + 1);
            tmpResult.remove(tmpResult.size() - 1);
        }

    }
}
