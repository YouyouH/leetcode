package com.yy.leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * @author huangyou
 */
public class constructbinarytreefrompreorderandinordertraversal {
    /**
     * 前序遍历： 根节点  左子树前序遍历   右子树前序遍历
     * 中序遍历： 左子树中序遍历  根节点   右子树中序遍历
     *
     * int preordeRLeft = 0;
     * int preordeRRight = preorder.length - 1;
     * int inorderLeft = 0;
     * int inorderRight = inorder.length - 1;
     */
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //求出每一段的端点
        int preordeRLeft = 0;
        int preordeRRight = preorder.length - 1;

        int inorderLeft = 0;
        int inorderRight = inorder.length - 1;

        buildIndexMap(inorder);

        return buildTree(preorder, inorder, preordeRLeft, preordeRRight, inorderLeft, inorderRight);

    }

    private void buildIndexMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preordeRLeft, int preordeRRight, int inorderLeft, int inorderRight) {
        if (preordeRLeft > preordeRRight || inorderLeft > inorderRight) {
            return null;
        }
        //前序遍历的第一个节点是根节点
        TreeNode root = new TreeNode(preorder[preordeRLeft]);
        Integer rootIndex = indexMap.get(root.val);
        int leftTreeSize = rootIndex - inorderLeft;

        //build 左子树
        root.left = buildTree(preorder, inorder, preordeRLeft + 1, preordeRLeft + leftTreeSize, inorderLeft, rootIndex - 1);
        //build 右子树
        root.right = buildTree(preorder, inorder, preordeRLeft + leftTreeSize + 1, preordeRRight, rootIndex + 1, inorderRight);
        return root;
    }
}
