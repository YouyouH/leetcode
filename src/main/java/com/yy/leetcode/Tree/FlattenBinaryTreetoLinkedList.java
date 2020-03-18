package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-17
 * @desc https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 输入：[1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 **/

import java.util.LinkedList;

/**
 * 前序遍历
 */
public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //result tree
        TreeNode preHead = new TreeNode(0);
        TreeNode pNode = preHead;
        LinkedList<TreeNode> result = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            if (null != root) {
                //前序遍历
                result.offer(root);

                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }

        while (!result.isEmpty()) {
            pNode.right = new TreeNode(result.poll().val);
            pNode = pNode.right;
        }
        root = preHead.right;

    }

    //迭代法
    public void flatten1(TreeNode root) {
        if(null == root){
            return;
        }
        LinkedList<TreeNode> result = new LinkedList();

        //result tree
        TreeNode preHead = new TreeNode(0);
        TreeNode pNode = preHead;

        traverseTree(root, result);
        while (!result.isEmpty()) {
            TreeNode node = result.poll();
            pNode.left = null;
            pNode.right = node;
            pNode = pNode.right;
        }
        root = preHead.right;
    }

    private void traverseTree(TreeNode root, LinkedList result) {
        if (root == null) {
            return;
        }
        //前序遍历
        result.add(root);
        traverseTree(root.left, result);
        traverseTree(root.right, result);
    }
}
