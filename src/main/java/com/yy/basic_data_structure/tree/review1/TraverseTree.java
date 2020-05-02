package com.yy.basic_data_structure.tree.review1;
/**
 * @author youyouhuang
 * @create 2020-05-01
 **/

import com.yy.leetcode.Tree.TreeNode;

/**
 *
 *<p>
 *
 *</p>
 **/
public class TraverseTree {

    public void preOrder(TreeNode treeNode){
        preOrderTraverse(treeNode);
    }

    private void preOrderTraverse(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        preOrderTraverse(treeNode.left);
        preOrderTraverse(treeNode.right);
    }

}
