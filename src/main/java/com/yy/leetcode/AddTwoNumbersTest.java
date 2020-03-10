package com.yy.leetcode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddTwoNumbersTest {


    /**
     * (3->5)+(5->2) = (8->7)
     * 53+25=78
     */
    @Test
    public void addTwoNumbersTest() {
        AddTwoNumbers addTwoNumbersTest = new AddTwoNumbers();

        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(2);

        ListNode result = addTwoNumbersTest.addTwoNumbers(listNode1, listNode2);
        Assert.assertTrue(result.val == 8);
        Assert.assertTrue(result.next.val == 7);
    }

    /**
     * (3->5)+(0) = (3->5)
     */
    @Test
    public void addTwoNumbersTest2() {
        AddTwoNumbers addTwoNumbersTest = new AddTwoNumbers();

        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5);

        ListNode listNode2 = new ListNode(0);

        ListNode result = addTwoNumbersTest.addTwoNumbers(listNode1, listNode2);
        Assert.assertTrue(result.val == 3);
        Assert.assertTrue(result.next.val == 5);
    }

    /**
     * (2->4)+(5->6) = (7->0->1)
     */
    @Test
    public void addTwoNumbersTest3() {
        AddTwoNumbers addTwoNumbersTest = new AddTwoNumbers();

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);

        ListNode result = addTwoNumbersTest.addTwoNumbers(listNode1, listNode2);
        Assert.assertTrue(result.val == 7);
        Assert.assertTrue(result.next.val == 0);
        Assert.assertTrue(result.next.next.val == 1);
    }

    /**
     * (9)+(1->9->9->9->9->9->9->9->9->9) = (0->0->0->0->0->0->0->0->0->0->1)
     */
    @Test
    public void addTwoNumbersTest4() {
        AddTwoNumbers addTwoNumbersTest = new AddTwoNumbers();

        ListNode listNode1 = new ListNode(9);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        listNode2.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next.next = new ListNode(9);


        ListNode result = addTwoNumbersTest.addTwoNumbers(listNode1, listNode2);
        Assert.assertTrue(result.val == 0);
        Assert.assertTrue(result.next.val == 0);
        Assert.assertTrue(result.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.next.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.next.next.next.next.next.val == 0);
        Assert.assertTrue(result.next.next.next.next.next.next.next.next.next.next.val == 1);
    }
}