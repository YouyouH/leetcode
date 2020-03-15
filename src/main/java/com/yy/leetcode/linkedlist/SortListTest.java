package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SortListTest {

    SortList_incorrect sortList = new SortList_incorrect();

    @Test
    public void sortList() {
        Assert.assertEquals(sortList.sortList(null), null);
        Assert.assertEquals(sortList.sortList(new ListNode(0)).val, 0);
    }

    @Test
    public void sortList1() {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(1);
        sortList.sortList(l1);

        Assert.assertEquals(l1.val,1);
        Assert.assertEquals(l1.next.val,2);
        Assert.assertEquals(l1.next.next.val,4);
        Assert.assertEquals(l1.next.next.next.val,4);
    }
}