package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-22
 * @desc https://leetcode-cn.com/problems/path-sum/
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 **/

/**
 * 宽度遍历，递归
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return traverseTree(root,0,sum);
    }

    private boolean traverseTree(TreeNode root, int value, int sum) {
        if(root == null){
            return false;
        }
        value = value + root.val;
        if(null == root.left && root.right == null){
            return value ==sum;
        }

        return traverseTree(root.left,value,sum) || traverseTree(root.right,value,sum);
    }
}
