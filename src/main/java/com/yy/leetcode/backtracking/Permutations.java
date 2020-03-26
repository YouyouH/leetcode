package com.yy.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author youyouhuang
 * @create 2020-03-26
 * @desc https://leetcode-cn.com/problems/permutations/
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 **/

public class Permutations {

    //递归
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        int length = nums.length;
        boolean[] used = new boolean[length];
        traverse(nums, 0, length, used, new ArrayList<>(), result);

        return result;
    }

    private void traverse(int[] nums, int depth, int length, boolean[] used, List<Integer> cur, List<List<Integer>> result) {

        if (depth == length) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(cur);
            result.add(list);
            return;
        }

        for (int i = 0; i < length ; i++) {
            if(!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                traverse(nums, depth + 1, length, used, cur, result);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}
