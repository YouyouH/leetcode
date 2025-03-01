

package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-23 22:15:38 
//二叉搜索树的最近公共祖先

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LowestCommonAncestorOfABinarySearchTree{
    public static void main(String[] args) {
         Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> parentsp = new ArrayList<>();
    List<TreeNode> parentsq = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 分别递归两次把到达两个点的路径记下来，然后再比较这两个路径找出最近公共祖先
         * FIXME：遍历的时候可以用上二叉搜索树的性质
         *  怎么找分叉点？
         *      从头开始找，遇到不一样的就说明分叉了不是公共点了
         */
        List<TreeNode> parents = new ArrayList<>();
        parents.add(root);
        traverse(root, p, q, parents);
        TreeNode node = null;
        for (int i = 0; i < Math.min(parentsp.size(), parentsq.size()); i++) {
            TreeNode p1 = parentsp.get(i);
            TreeNode q1 = parentsq.get(i);
            if (p1 == q1) {
                node = p1;
            }else{
                return node;
            }
        }
        return node;
    }

    private void traverse(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> parents) {
        if (root == null) {
            return;
        }
        if (root == p) {
            parentsp.addAll(new ArrayList<>(parents));
//            StringBuilder sb = new StringBuilder();
//            for (TreeNode node : parentsp) {
//                sb.append(node.val);
//            }
//            System.out.println("found p:" + sb);
        }
        if (root == q) {
            parentsq.addAll(new ArrayList<>(parents));
//            StringBuilder sb = new StringBuilder();
//            for (TreeNode node : parentsq) {
//                sb.append(node.val);
//            }
//            System.out.println("found q:" + sb);
        }
        if (!parentsp.isEmpty() && !parentsq.isEmpty()) {
            return;
        }
        if (root.left != null) {
            parents.add(root.left);
        }
        traverse(root.left, p, q, parents);
        if (root.left != null) {
            parents.remove(parents.size()-1);
        }
        if (root.right != null) {
            parents.add(root.right);
        }
        traverse(root.right, p, q, parents);
        if (root.right != null) {
            parents.remove(parents.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1301 👎 0
