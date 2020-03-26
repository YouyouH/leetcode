package com.yy.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author youyouhuang
 * @create 2020-03-26
 * @desc https://leetcode.com/problems/subsets/
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 **/

/*
方法一:字典排序
方法二:递归
 */
public class Subsets {

    //字典排序
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    //迭代排序
    public List<List<Integer>> subsets1(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        results.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> result : results) {
                ArrayList<Integer> integers = new ArrayList<>(result);
                integers.add(nums[i]);
                tmp.add(integers);
            }
            results.addAll(tmp);
        }
        return results;
    }
}
