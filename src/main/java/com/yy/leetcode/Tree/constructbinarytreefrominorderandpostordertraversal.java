package com.yy.leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class constructbinarytreefrominorderandpostordertraversal {
    /**
     * 中序遍历 inorder = [9,3,15,20,7]
     * 左节点   根节点  右节点
     * 后序遍历 postorder = [9,15,7,20,3]
     * 左子树  右子树  根节点
     */
    Map<Integer, Integer> indexMap = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //对左子树右子树的端点标记
        buildMap(indexMap, inorder);
        post= postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {

        if (inorderLeft > inorderRight || postorderLeft > postorderRight) return null;

        TreeNode rootNode = new TreeNode(post[postorderRight]);
        Integer rootIndex = indexMap.get(post[postorderRight]);
        int leftTreeSize = rootIndex - inorderLeft;
        rootNode.left = buildTree(inorderLeft, rootIndex - 1, postorderLeft, postorderLeft + leftTreeSize-1);
        rootNode.right = buildTree(rootIndex + 1, inorderRight, postorderLeft + leftTreeSize, postorderRight-1);

        return rootNode;
    }

    private void buildMap(Map<Integer, Integer> indexMap, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
    }
}
