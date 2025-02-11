
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-11 21:28:09 
//K 个一组翻转链表

public class ReverseNodesInKGroup{
    public static void main(String[] args) {
         Solution solution = new ReverseNodesInKGroup().new Solution();
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
    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         * p1 p2 p3 p4 从左到右四个指针指向接口处
         */
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode cur = dummyNode;


        ListNode p1 = dummyNode;
        ListNode p2 = head;
        ListNode p3 = null;
        ListNode p4 = null;
        while (cur != null) {
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) {
                    return dummyNode.next;//不够了就退出，不用再反转了
                }
            }
//            System.out.println("cur=" + cur.val);

            p3 = cur;
            p4 = cur.next;
//            System.out.println("before");
//            System.out.println(p1.val);
//            System.out.println(p2.val);
//            System.out.println(p3.val);
//            System.out.println(p4.val);

            //断开
            p1.next = null;
            p3.next = null;

            reverse(p2);
            p1.next = p3;
            p2.next = p4;
            // 1-3-2-4
//            System.out.println("after");
//            System.out.println(p1.val);
//            System.out.println(p1.next.val);
//            System.out.println(p1.next.next.val);
//            System.out.println(p1.next.next.next.val);

            p1 = p2;
            p2 = p4;
//            System.out.println("last");
//            System.out.println(p1.val);
//            System.out.println(p2.val);

            cur = p1;//前面p3指向了cur所以这时候要重新赋值
        }

        return dummyNode.next;

        
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2474 👎 0
