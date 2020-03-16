package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-16
 * @desc
 **/

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        TreeNode pNode = root;

        traverseTree(pNode);

        return root;
    }

    //宽度优先
    private void traverseTree(TreeNode root) {



    }

}
