package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-16
 * @desc
 **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
