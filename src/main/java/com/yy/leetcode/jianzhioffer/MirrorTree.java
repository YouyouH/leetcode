package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-06-06
 **/

import com.yy.leetcode.Tree.TreeNode;

/**
 *
 *<p>
 *
 *</p>
 **/
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        TreeNode mirrorTree = new TreeNode(root.val);
        traverse(root,mirrorTree);
        return mirrorTree;
    }

    private void traverse(TreeNode point, TreeNode mirrorPoint){
        if(null == point){
            return;
        }
        mirrorPoint.val = point.val;
        if(point.left != null) {
            mirrorPoint.right = new TreeNode(0);
        }
        traverse(point.left,mirrorPoint.right);
        mirrorPoint.val = point.val;
        if(point.right != null) {
            mirrorPoint.left = new TreeNode(0);
        }
        traverse(point.right,mirrorPoint.left);
    }

}
