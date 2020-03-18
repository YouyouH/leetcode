package com.yy.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2020-03-17
 * @desc https://leetcode.com/problems/binary-tree-inorder-traversal/
 **/

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }

        inOrderTraverse(root, list);
        return list;
    }

    private void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

    //方法二: 迭代
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return results;
        }
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                if (node != null) {
                    results.add(node.val);
                }
                pNode = node.right;
            }
        }
        return results;
    }

}
