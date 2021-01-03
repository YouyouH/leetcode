package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionListTest {

    PartitionList partitionList = new PartitionList();

    @Test
    public void partition0() {
        Assert.assertEquals(null,partitionList.partition(null, 0));
    }

    @Test
    public void partition() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partitionList.partition(head, 3);
    }

    @Test
    public void partition2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partitionList.partition(head, 7);
    }
}