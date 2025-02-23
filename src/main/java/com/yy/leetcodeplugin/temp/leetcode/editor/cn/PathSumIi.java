
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-23 10:29:09 
//路径总和 II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathSumIi{
    public static void main(String[] args) {
         Solution solution = new PathSumIi().new Solution();
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
    List<String> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        /**
         * 先用string保存，最后转成list
         */
        traverse(root,"",targetSum);

        List<List<Integer>> res = new ArrayList<>();

        for (String sb : ans) {
            res.add(Arrays.stream(sb.split(",")).map(s -> Integer.valueOf(s)).collect(Collectors.toList()));
        }
        return res;
    }

    private void traverse(TreeNode root, String path, int remain) {
        if (root == null) {
            return;
        }
        path += root.val;
        remain -= root.val;

        if (root.left == root.right) {
            if (remain == 0) {
                ans.add(path);
            }
            return;
        }
        path += ",";
        traverse(root.left, path,remain);
        traverse(root.right, path,remain);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1169 👎 0
