package com.yy.leetcode.twopointers;

import com.yy.leetcode.linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class linkedlistcycleiiTest {
    linkedlistcycleii linkedlistcycleii = new linkedlistcycleii();

    @Test
    public void detectCycle() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n2;
        linkedlistcycleii.detectCycle(n1);
    }
}