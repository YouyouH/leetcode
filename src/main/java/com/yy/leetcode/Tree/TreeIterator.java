package com.yy.leetcode.Tree;

import java.util.LinkedList;

/**
 * @author youyouhuang
 * @create 2020-03-16
 * @desc
 **/

public class TreeIterator {

    public void preOrderTraverse1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraverse1(root.left);
        preOrderTraverse1(root.right);
    }

    public void inOrderTraverse1(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse1(root.left);
        System.out.println(root.val);
        inOrderTraverse1(root.right);
    }

    public void postOrderTraverse1(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverse1(root.left);
        postOrderTraverse1(root.right);
        System.out.println(root.val);
    }

    //前序遍历
    public void preOrderTraverse(TreeNode root) {
        //初始化一个栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        //指针用来移动
        TreeNode pNode = root;
        //到最后stack 空了就表明处理完了
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    //前序遍历
    public void inOrderTraverse(TreeNode root) {
        //初始化一个栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        //指针用来移动
        TreeNode pNode = root;
        //到最后stack 空了就表明处理完了
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                //前序遍历
//                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                if (node != null) {
                    System.out.println(node.val);
                }
                pNode = node.right;
            }
        }
    }

//    public void postOrderTraverse(TreeNode root){
//        //初始化一个栈
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        //指针用来移动
//        TreeNode pNode = root;
//        //到最后stack 空了就表明处理完了
//        while(pNode != null || !stack.isEmpty()){
//            if(pNode != null){
//                //前序遍历
////                System.out.println(pNode.val);
//                stack.push(pNode);
//                pNode = pNode.left;
//
//            }else{
//                TreeNode node = stack.pop();
//                pNode = node.right;
//            }
//        }
//    }

    //层次遍历
    public void levelTraverse(TreeNode root) {
        //先进先出
        LinkedList<TreeNode> queue = new LinkedList();

        //添加到队列末尾
        queue.offer(root);

        while (!queue.isEmpty()) {
            //从队列头取出
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
    }

    //深度优先遍历。 就是前序遍历。
    public void depthOrderTraverse(TreeNode root) {
    }
}
