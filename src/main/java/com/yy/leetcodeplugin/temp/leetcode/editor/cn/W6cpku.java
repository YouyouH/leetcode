  //给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。 
//
// 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 
//输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 
//输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 10⁴ 之间。 
// 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
//
// 
//
// 注意： 
//
// 
// 本题与主站 538 题相同： https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 
//
// 本题与主站 1038 题相同：https://leetcode-cn.com/problems/binary-search-tree-to-
//greater-sum-tree/ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 11 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-19 12:09:52 
//所有大于等于节点的值之和

  import java.util.SortedMap;
  import java.util.TreeMap;

  public class W6cpku{
    public static void main(String[] args) {
         Solution solution = new W6cpku().new Solution();
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
    public TreeNode convertBST(TreeNode root) {
        //方法一：二叉搜索树，特点是中序遍历是一个单调递增的序列。如果反着中序遍历就能得到一个单调递减序列
        //方法二：
        //用链表保存节点，用treemap按照value排序
        //遍历map，跟新节点value
        TreeMap<Integer, TreeNode> value2node = new TreeMap<>();
        traverseTree(root, value2node);

        int sum = 0;
        for (Integer value : value2node.descendingKeySet()) {
            TreeNode node = value2node.get(value);
            sum += value;
            node.val = sum;
        }


        return root;
    }

    private void traverseTree(TreeNode root, TreeMap<Integer, TreeNode> value2node) {
        if (root == null) {
            return;
        }
        //把节点保存到map里并且按value排序
        value2node.put(root.val, root);
        traverseTree(root.left, value2node);
        traverseTree(root.right, value2node);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}