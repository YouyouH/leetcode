package com.yy.leetcode.Tree;

import java.util.LinkedList;

/**
 * @author youyouhuang
 * @create 2020-03-16
 * @desc
 **/

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return root;
        }

        TreeNode pNode = root;

        traverseTree(pNode);

        return root;
    }

    //宽度优先
    private void traverseTree(TreeNode pNode) {
        //队列，先进先出
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(pNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node !=null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }


    }

}
