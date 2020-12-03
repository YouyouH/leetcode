package com.yy.leetcode.Tree;

/**
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if(null == root) return root;
        Node levelStart = null;
        Node last = null;

        Node start = root;

        while (start != null) {
            last = null;
            levelStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (null != p.left) {
                    if (levelStart == null) {
                        levelStart = p.left;
                    }
                    if (last != null) {
                        last.next = p.left;
                    }
                    last = p.left;
                }

                if (null != p.right) {
                    if (levelStart == null) {
                        levelStart = p.right;
                    }
                    if (last != null) {
                        last.next = p.right;
                    }
                    last = p.right;
                }
            }
            start = levelStart;
        }
        return root;
    }
}
