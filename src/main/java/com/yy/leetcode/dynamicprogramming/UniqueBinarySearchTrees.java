package com.yy.leetcode.dynamicprogramming;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    /**
     * 1,2,3,4,5,6,7,8
     * 例如 已3为根节点，则可以构造出 [1,2] * [4,5,6,7,8] 种二叉树
     *
     */
    public int numTrees(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;


        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }

        }
        return dp[n];

    }
}
