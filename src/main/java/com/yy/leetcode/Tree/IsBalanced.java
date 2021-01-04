package com.yy.leetcode.Tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(null == root){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);



    }

    public int height(TreeNode root){
        if(null == root) return 0;

        return 1 + Math.max(height(root.left),height(root.right));

    }
}
