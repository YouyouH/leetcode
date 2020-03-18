package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-18
 * @desc https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 **/

public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
