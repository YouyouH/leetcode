package com.yy.leetcode.Tree;
/**
 * @author youyouhuang
 * @create 2020-05-02
 **/

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class TrimaBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return root;
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;

    }
}
