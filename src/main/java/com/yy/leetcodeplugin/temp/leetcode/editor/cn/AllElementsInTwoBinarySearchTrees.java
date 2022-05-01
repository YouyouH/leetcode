//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 102 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-05-01 10:48:25
//两棵二叉搜索树中的所有元素

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> res1 = new ArrayList<>();
            List<Integer> res2 = new ArrayList<>();
            traverseTree(root1, res1);
            traverseTree(root2, res2);
            return merge(res1, res2);
        }

        private List<Integer> merge(List<Integer> res1, List<Integer> res2) {
            List<Integer> res = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < res1.size() && j < res2.size()) {
                if (res1.get(i) <= res2.get(j)) {
                    res.add(res1.get(i));
                    i++;
                } else {
                    res.add(res2.get(j));
                    j++;
                }
            }
            while (i < res1.size()) {
                res.add(res1.get(i));
                i++;
            }
            while (j < res2.size()) {
                res.add(res2.get(j));
                j++;
            }
            return res;
        }

        //中序遍历
        private void traverseTree(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            traverseTree(root.left, res);
            res.add(root.val);
            traverseTree(root.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}