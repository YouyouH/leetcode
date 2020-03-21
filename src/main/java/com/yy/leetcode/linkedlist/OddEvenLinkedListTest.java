package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class OddEvenLinkedListTest {

    @Test
    public void oddEvenList0() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        ListNode listNode = oddEvenLinkedList.oddEvenList(head);
        Assert.assertEquals(1, listNode.val);
        Assert.assertEquals(null, listNode.next);
    }

    @Test
    public void oddEvenList() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = oddEvenLinkedList.oddEvenList(head);
        Assert.assertEquals(1, listNode.val);
        Assert.assertEquals(3, listNode.next.val);
        Assert.assertEquals(5, listNode.next.next.val);
        Assert.assertEquals(2, listNode.next.next.next.val);
        Assert.assertEquals(4, listNode.next.next.next.next.val);
        Assert.assertEquals(null, listNode.next.next.next.next.next);
    }

    @Test
    public void oddEvenList1() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = oddEvenLinkedList.oddEvenList(head);
        Assert.assertEquals(1, listNode.val);
        Assert.assertEquals(3, listNode.next.val);
        Assert.assertEquals(2, listNode.next.next.val);
        Assert.assertEquals(4, listNode.next.next.next.val);
        Assert.assertEquals(null, listNode.next.next.next.next);
    }
}