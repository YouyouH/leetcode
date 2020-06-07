package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-06-07
 **/

/**
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *<p>
 *
 *</p>
 **/
public class erchasousuoshudehouxubianli {

    public boolean verifyPostorder(int[] postorder) {
        return verify(0,postorder.length-1,postorder);
    }

    private boolean verify(int start, int end, int[] postorder) {
        if(postorder== null || postorder.length == 0){
            return true;
        }

        if (end - start < 2) {
            return true;
        }

        int root = postorder[end];

        int leftTree = start;
        while (postorder[leftTree] < root){
            leftTree++;
        }

        int leftTree2 = leftTree;

        for (int i = leftTree2; i < end; i++) {
            if(postorder[i] < postorder[end]){
                return false;
            }
        }

        return verify(start, leftTree-1, postorder) &&
                verify(leftTree , end-1, postorder);
    }

}
