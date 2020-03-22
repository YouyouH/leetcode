package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-22
 * @desc https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 **/


import java.util.LinkedList;

/**
 * 先中去遍历，再重新构建树
 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> nodes = new LinkedList();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while(!stack.isEmpty() || pNode !=null){
            if(pNode !=null) {
                stack.push(pNode);
                pNode = pNode.left;
            }else {
                TreeNode node = stack.pop();
                nodes.offer(node);
                pNode = node.right;
            }
        }
        TreeNode preNode = new TreeNode(0);
        TreeNode p = preNode;
        while(!nodes.isEmpty()){
            p.right = nodes.poll();
            p.left = null;
            p = p.right;
        }
        return preNode.right;
    }
}
