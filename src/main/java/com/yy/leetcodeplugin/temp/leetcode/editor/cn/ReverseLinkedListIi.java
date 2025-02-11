
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-10 09:56:38 
//反转链表 II

public class ReverseLinkedListIi{
    public static void main(String[] args) {
         Solution solution = new ReverseLinkedListIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /**
         * 用多次遍历锁定关键点
         *      FIXME：用dummy node不然后面不好处理
         *      要有四个指针，pre指向1，left指向2，right指向4，tail指向5
         */

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode newHead = null;

        ListNode cur = dummyNode;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }
        newHead = cur;

        cur = dummyNode;
        for (int i = 1; i < right+1; i++) {
            cur = cur.next;
        }
        ListNode rightNode = cur;
        ListNode newTail = rightNode.next;

//        System.out.println("newHead=" + newHead.val);
//        System.out.println("rightNode=" + rightNode.val);
//        System.out.println("newTail=" + newTail.val);

        ListNode leftNode = newHead.next;

        //FIXME:这里要断开
        newHead.next = null;
        rightNode.next = null;

//        System.out.println("start=" + newHead.next.val + " end=" + cur.val);
        ListNode[] listNodes = reverseList(leftNode, cur);
//        System.out.println("listNodes[0]=" + listNodes[0].val + " listNodes[1]=" + listNodes[1].val);


        leftNode.next = newTail;
        newHead.next = rightNode;

//        listNodes[1].next = newTail;
//        newTail.next = null;

//        System.out.println(newHead.val);
//        System.out.println(newHead.next.val);
//        System.out.println(newHead.next.next.val);
//        System.out.println(newHead.next.next.next.val);
//        System.out.println(newHead.next.next.next.next.val);
//        System.out.println(newHead.next.next.next.next.next.val);

        return dummyNode.next;

    }

    private ListNode[] reverseList(ListNode head, ListNode end){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return new ListNode[]{end,head};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1913 👎 0
