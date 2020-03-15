package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedListsTest {

    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void mergeTwoLists() {
        Assert.assertEquals(mergeTwoSortedLists.mergeTwoLists(null, null), null);
        Assert.assertEquals(mergeTwoSortedLists.mergeTwoLists(new ListNode(0), null).val, 0);
        Assert.assertEquals(mergeTwoSortedLists.mergeTwoLists(null, new ListNode(0)).val, 0);
    }

    @Test
    public void mergeTwoLists1() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        Assert.assertEquals(listNode.val, 2);
        Assert.assertEquals(listNode.next.val, 4);
    }

    @Test
    public void mergeTwoLists2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        Assert.assertEquals(listNode.val, 1);
        Assert.assertEquals(listNode.next.val, 1);
        Assert.assertEquals(listNode.next.next.val, 2);
        Assert.assertEquals(listNode.next.next.next.val, 3);
        Assert.assertEquals(listNode.next.next.next.next.val, 4);
        Assert.assertEquals(listNode.next.next.next.next.next.val, 4);
    }

    @Test
    public void mergeTwoLists999() {
        if (Character.isDigit("5".charAt(0))) {
            int integer = "5".charAt(0) - '0';
            System.out.println(integer);
        }
    }
}