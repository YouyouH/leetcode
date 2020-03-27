package com.yy.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-27
 * @desc https://leetcode-cn.com/problems/subsets-ii/
 * 给定一个可能包含 重复元素 的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 **/


/**
 * 1.先对数组排序
 * 2.每次递归index+1
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        traverse(nums, results, new ArrayList<Integer>(), 0,used);
        return results;
    }

    private void traverse(int[] nums, List<List<Integer>> results, ArrayList<Integer> cur, int start, boolean[] used) {

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            results.add(new ArrayList<>(cur));
            traverse(nums, results, cur, i+1, used);
            cur.remove(cur.size() - 1);

            used[i] = false;
        }

    }
}
