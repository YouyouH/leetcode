package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementsTest {
    RemoveElements removeElements = new RemoveElements();
    @Test
    public void removeElements() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        Assert.assertEquals(1, removeElements.removeElements(head, 6).val);
    }

    @Test
    public void removeElements2() {
        ListNode head = new ListNode(6);
        Assert.assertEquals(null, removeElements.removeElements(head, 6));
    }
}