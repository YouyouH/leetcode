
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-18 21:32:45 
//出现次数最多的子树元素和

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum{
    public static void main(String[] args) {
         Solution solution = new MostFrequentSubtreeSum().new Solution();
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
    private Map<Integer, Integer> count = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans.clear();
                ans.add(entry.getKey());
                continue;
            }
            if (entry.getValue() == max) {
                ans.add(entry.getKey());
                continue;
            }
        }
        int[] ints = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ints[i] = ans.get(i);
        }
        return ints;

    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);

        int right = traverse(root.right);

        int sum = root.val + left + right;

        Integer countOrDefault = count.getOrDefault(sum, 0);
        count.put(sum, countOrDefault + 1);

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 255 👎 0
