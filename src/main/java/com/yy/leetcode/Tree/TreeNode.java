package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-16
 * @desc
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
