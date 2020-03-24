package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-17
 * @desc https://leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 **/

public class SymmetricTree {

    //复制一棵树，对两棵树一棵从左边遍历，一棵从右边
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode root1 = root;
        return traverseTree(root, root1);

    }

    private boolean traverseTree(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }

        if (root.val != root1.val) {
            return false;
        }

        return traverseTree(root.left, root1.right) && traverseTree(root.right, root1.left);
    }
}
