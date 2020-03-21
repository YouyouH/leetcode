package com.yy.leetcode.Tree;

/**
 * @author youyouhuang
 * @create 2020-03-21
 * @desc https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 将一个按照 升序排列 的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 *给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 **/

public class ConvertSortedArraytoBinarySearchTree {

    //递归构建BTS二分搜索树。左边小于父节点，右边大于父节点
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        int end = nums.length;
        return constructTree(nums,0,end -1);
    }

    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //如果 start + end > Interger.max 会报错，这里采用位运算的方式避免
        int middle = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = constructTree(nums,start,middle-1);
        root.right = constructTree(nums,middle+1,end);
        return root;
    }
}
