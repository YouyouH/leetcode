
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-24 17:36:00 
//二叉搜索树中第 K 小的元素

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthSmallestElementInABst{
    public static void main(String[] args) {
         Solution solution = new KthSmallestElementInABst().new Solution();
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
    public int kthSmallest(TreeNode root, int k) {
        /**
         * 方法一：遍历然后排序 nlogn
         * 方法二：拿值当数组下标，数组的值是出现的次数。 n
         * 方法三：用大小为k的小根堆。最上面的就是第k小的元素
         * FIXME：
         *   1.利二叉搜索树的性质，中序遍历一定是升序。
         *
         *
         */

        //默认就是小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>( (a, b) -> a.compareTo(b));
        traverse(root, queue);
        int ans = 0;
        while (!queue.isEmpty() && k-- > 0) {
            ans = queue.poll();

        }
        return ans;
        
    }

    private void traverse(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.offer(root.val);
        traverse(root.left, queue);
        traverse(root.right, queue);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 947 👎 0
