package com.yy.leetcode.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author youyouhuang
 * @create 2020-03-27
 * @desc https://leetcode.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 **/

/**
 * 方法一:backtracking
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //第一步 排序
        if (nums == null || nums.length < 3) return new ArrayList<>(new ArrayList<>());

        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();

        //确定第一个数，然后用双指针从一头一尾开始去找剩下的两个数。找到了就继续找，直到相遇
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }
            }
        }
        return result;
    }
}
