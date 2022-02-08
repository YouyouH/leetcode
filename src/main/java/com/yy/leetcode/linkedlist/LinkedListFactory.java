package com.yy.leetcode.linkedlist;

public class LinkedListFactory {

    public static ListNode createLinkedList(int[] linkedList) {
        ListNode root = new ListNode(linkedList[0]);
        ListNode head = root;
        for (int i = 1; i < linkedList.length; i++) {
            root.next = new ListNode(linkedList[i]);
            root = root.next;
        }
        return head;
    }
}
