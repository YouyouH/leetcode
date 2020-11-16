package com.yy.leetcode.dynamicprogramming.Decision_Making;

import java.util.List;


/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 1
 * 23
 * 456
 * 7890
 *
 * @author huangyou
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i][j]  i,j为坐标
        int size = triangle.size();
        if (0 == size) {
            return 0;
        }
        int total = 0;
        for (List<Integer> list : triangle) {
            total = total + list.size();
        }
        if (0 == total) {
            return 0;
        }


        int[][] dp = new int[size][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < size; i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        for (int i = 1; i < size; i++) {
            List<Integer> level = triangle.get(i);
            for (int j = 1; j < level.size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + level.get(j);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(size - 1).size(); i++) {
            if (dp[size - 1][i] < result) {
                result = dp[size - 1][i];
            }
        }
        return result;
    }
}
