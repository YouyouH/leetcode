package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-18
 * @desc https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 **/

/**
 * 先序遍历
 */
public class MergeTwoBinaryTrees {

    //同时对两棵树先序遍历
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        traverseTree(t1, t2);
        return t1;
    }

    private void traverseTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return;
        }
        if(t2!=null) {
            t1.val = t1.val + t2.val;
        }else{
            return;
        }

        if (t1.left == null && t2.left!=null) {
            t1.left = new TreeNode(0);
        }
        if (t1.right == null && t2.right!=null) {
            t1.right = new TreeNode(0);
        }
        traverseTree(t1.left, t2.left);
        traverseTree(t1.right, t2.right);
    }
}
