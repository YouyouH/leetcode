package com.yy.leetcode.jianzhioffer;

import com.yy.leetcode.Tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MirrorTreeTest {

    @Test
    public void mirrorTree() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        MirrorTree mirrorTree = new MirrorTree();
        mirrorTree.mirrorTree(root);
    }
}