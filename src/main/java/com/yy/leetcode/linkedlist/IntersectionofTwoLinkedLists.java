package com.yy.leetcode.linkedlist;

/**
 * @author youyouhuang
 * @create 2020-03-19
 * @desc https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 **/

/**
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pNode1 = headA;

        ListNode pNode2 = headB;

        boolean a = false;
        boolean b = false;

        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            if (null == pNode1) {
                if(a){
                    return null;
                }
                pNode1 = headB;
                a = true;
            }
            pNode2 = pNode2.next;
            if (null == pNode2) {
                if(b){
                    return null;
                }
                pNode2 = headA;
                b = true;
            }
        }

        return pNode1;
    }
}

