package com.yy.leetcode.Tree;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * 思路:
     * 层次遍历二叉树，遍历当前层时每一层都看成一个链表，通过遍历这个链表就可以遍历下一层的所有节点
     * <p>
     * start表示当前层的起始节点
     * nextStart 下层的起始节点
     * last 下一层链表的指针，用来修改next节点
     * p 指针用来遍历当前层的链表
     */
    public Node connect(Node root) {

        if (null == root) return null;

        Node start = root;

        Node nextStart = null;
        Node last = null;

        while (start != null) {
            //start 是当前层的起始节点
            nextStart = null;
            last = null;
            for (Node p = start; p != null; p = p.next) {
                Node left = p.left;
                if (null != left) {
                    if (nextStart == null) {
                        nextStart = left;
                    }
                    if (last != null) {
                        last.next = left;
                    }
                    last = left;
                }

                Node right = p.right;
                if (null != right) {
                    if (nextStart == null) {
                        nextStart = right;
                    }
                    if (last != null) {
                        last.next = right;
                    }
                    last = right;
                }
            }
            start = nextStart;
        }
        return root;
    }

}
