package com.yy.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobIIITest {

    @Test
    public void rob() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        treeNode.left = leftNode;
        treeNode.right = rightNode;

        HouseRobIII houseRobIII = new HouseRobIII();
        System.out.println(houseRobIII.rob(treeNode));
    }

    @Test
    public void rob2(){
        //[3,2,3,null,3,null,1] except 7

        TreeNode treeNode = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);

        TreeNode treeNode3 = null;
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = null;
        TreeNode treeNode6 = new TreeNode(1);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        HouseRobIII houseRobIII = new HouseRobIII();
        System.out.println(houseRobIII.rob(treeNode));
    }

    @Test
    public void rob3(){
        //[3,2,3,null,3,null,1] except 7

        TreeNode treeNode = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = null;
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = null;
        TreeNode treeNode6 = new TreeNode(1);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        HouseRobIII houseRobIII = new HouseRobIII();
        System.out.println(houseRobIII.rob(treeNode));
    }

    @Test
    public void rob4(){
        //[4,1,null,2,null,3] except 7

        TreeNode treeNode = new TreeNode(4);

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = null;
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = null;
        TreeNode treeNode5 = new TreeNode(3);

        treeNode1.left = treeNode3;
        treeNode1.right = null;

        treeNode3.left = treeNode5;
        treeNode3.right = null;

        treeNode.left = treeNode1;
        treeNode.right = null;

        HouseRobIII houseRobIII = new HouseRobIII();
        System.out.println(houseRobIII.rob(treeNode));
    }
}