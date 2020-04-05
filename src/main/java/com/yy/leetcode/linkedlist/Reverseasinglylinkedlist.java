package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-19
 * @desc https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 **/

public class Reverseasinglylinkedlist {

    //迭代法
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }


}
