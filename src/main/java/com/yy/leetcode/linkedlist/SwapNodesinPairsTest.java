package com.yy.leetcode.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwapNodesinPairsTest {

    @Test
    public void swapPairs() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        SwapNodesinPairs swapNodesinPairs = new SwapNodesinPairs();
        ListNode result = swapNodesinPairs.swapPairs(node);
        Assert.assertEquals(2,result.val);
        Assert.assertEquals(1,result.next.val);
        Assert.assertEquals(4,result.next.next.val);
        Assert.assertEquals(3,result.next.next.next.val);
    }
}