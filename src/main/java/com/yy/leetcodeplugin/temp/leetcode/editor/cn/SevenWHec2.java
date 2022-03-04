  //给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 32 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-28 14:08:59 
//链表排序

  import com.yy.leetcode.linkedlist.LinkedListFactory;
  import com.yy.leetcode.linkedlist.ListNode;

  public class SevenWHec2{
    public static void main(String[] args) {

        Solution solution = new SevenWHec2().new Solution();
        solution.sortList(LinkedListFactory.createLinkedList(new int[]{1,3,2}));
        solution.sortList(LinkedListFactory.createLinkedList(new int[]{1,3,2,4}));
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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        //快慢指针不停的二分，然后排序。思路就是归并排序
        //要点：找到中间节点之后要断开链表
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode lo) {
        //分割到只有一个节点了，终止
        if (lo.next == null) {
            return lo;
        }

        ListNode slow = lo;

        ListNode fast = lo;

        ListNode pre = null;

        while (fast != null && fast.next != null) {
            //每次循环结束后，pre都在slow前面
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割好之后要把链表在中间断开
        pre.next = null;
        ListNode l = mergeSort(lo);
        ListNode r = mergeSort(slow);

        return merge(l, r);
    }

    private ListNode merge(ListNode lo, ListNode mid) {
        //链表分为lo-mid和mid-end(null)两部分，通过这个函数把链表排好序
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;


        while (lo != null && mid != null) {
            if (lo.val < mid.val) {
                dummy.next = lo;
                lo = lo.next;
            } else {
                dummy.next = mid;
                mid = mid.next;
            }
            dummy = dummy.next;
        }

        //下面这两个循环肯定只有一个存在.
        if (lo != null) {
            //把lo代表的链表全接上
            dummy.next = lo;
        } else if (mid != null) {
            dummy.next = mid;
        }
        return head.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}