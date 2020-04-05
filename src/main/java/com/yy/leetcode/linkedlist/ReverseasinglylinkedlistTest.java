package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseasinglylinkedlistTest {

    Reverseasinglylinkedlist reverseasinglylinkedlist = new Reverseasinglylinkedlist();

    /**
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     */
    @Test
    public void reverseList() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode node = reverseasinglylinkedlist.reverseList(listNode);

        Assert.assertEquals(node.val,5);
        Assert.assertEquals(node.next.val,4);
        Assert.assertEquals(node.next.next.val,3);
        Assert.assertEquals(node.next.next.next.val,2);
        Assert.assertEquals(node.next.next.next.next.val,1);


    }
}