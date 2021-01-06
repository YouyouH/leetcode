package com.yy.leetcode.linkedlist;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        ListNode p = head;

        if(null ==p) return null;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
}
