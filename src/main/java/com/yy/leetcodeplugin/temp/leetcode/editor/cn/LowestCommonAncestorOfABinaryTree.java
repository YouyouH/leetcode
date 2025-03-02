
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-01 14:15:49 
//二叉树的最近公共祖先

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
         Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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

  //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2908 👎 0
