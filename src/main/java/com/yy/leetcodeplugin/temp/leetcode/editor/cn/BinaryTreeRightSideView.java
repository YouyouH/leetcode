
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-16 20:42:23 
//二叉树的右视图

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView{
    public static void main(String[] args) {
         Solution solution = new BinaryTreeRightSideView().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        /**
         * FIXME:
         *  DFS,每次递归都记录深度。当前深度遇到的第一个数就是从右边看到的
         */
        List<Integer> ans = new ArrayList<>();

        traverse(root, 0, ans);

        return ans;

    }

    private void traverse(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() <= depth) {
            ans.add(root.val);
        }

        //FIXME: 先从右边开始，可以先把数组填满
        traverse(root.right, depth+1, ans);

        traverse(root.left, depth+1,ans);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1： 
//
// 
// 输入：root = [1,2,3,null,5,null,4] 
// 
//
// 输出：[1,3,4] 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2,3,4,null,null,null,5] 
// 
//
// 输出：[1,3,4,5] 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：root = [1,null,3] 
// 
//
// 输出：[1,3] 
//
// 示例 4： 
//
// 
// 输入：root = [] 
// 
//
// 输出：[] 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1165 👎 0
