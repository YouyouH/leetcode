
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-18 22:03:19 
//二叉树剪枝

public class BinaryTreePruning{
    public static void main(String[] args) {
         Solution solution = new BinaryTreePruning().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     *FIXME 官方答案
     *
     */
    public TreeNode pruneTree(TreeNode root) {
        return traverse(root);

    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = traverse(root.left);

        root.right = traverse(root.right);

        if (root.left == root.right && root.val == 0) {
            return null;
        }

        return root;
    }

    /**
     *自己想的方法不够简单
     *
     */
    public TreeNode pruneTree2(TreeNode root) {
        if (traverse2(root)) {
            return root;
        } else {
            return null;
        }
    }

    private boolean traverse2(TreeNode root) {//true 表示包含1，false表示不包含1，要移除
        if (root == null) {
            return false;
        }
        if (root.left == root.right) {//遇到叶子节点
            return root.val == 1;
        }

        boolean left = traverse2(root.left);
        if (!left) {
            root.left = null;
        }

        boolean right = traverse2(root.right);
        if (!right) {
            root.right = null;
        }

        return root.val == 1 || left || right;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。 
//
// 返回移除了所有不包含 1 的子树的原二叉树。 
//
// 节点 node 的子树为 node 本身加上所有 node 的后代。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,0,0,1]
//输出：[1,null,0,null,1]
//解释：
//只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,1,0,0,0,1]
//输出：[1,null,1,null,1]
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,1,0,1,1,0,1,0]
//输出：[1,1,0,1,1,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 200] 内 
// Node.val 为 0 或 1 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 380 👎 0
