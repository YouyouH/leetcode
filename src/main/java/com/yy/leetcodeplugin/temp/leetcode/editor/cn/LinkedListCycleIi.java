
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-13 17:49:11 
//环形链表 II

public class LinkedListCycleIi{
    public static void main(String[] args) {
         Solution solution = new LinkedListCycleIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /**
         * FIXME：
         *  1.两个指针，快指针是慢指针速度的两倍
         *  2.慢指针一定会在环形的第一圈就和快指针相遇。为什么？
         *      假如快慢指针同时从环形起点出发，那么慢指针会在第一圈回到起点的时候和快指针相遇，此时快指针走了两圈。这是最坏的情况。
         *      假如环形起点不在链表头部，那么当慢指针到达环形起点的时候，快指针已经在环里了，只会比上面的情况更快的在慢指针的第一圈相遇
         *  3.怎么求环形起点？
         *      快慢指针相遇后，从起点再设置一个指针，同时前进，新的指针和慢指针相遇的时候就是环形的起点。可以在纸上画图列方程求出来。
         *
         */
        if (head == null) {
            //0个结点
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        //没有环怎么处理？？？

        int start = 0;//刚开始的时候slow == fast,所以加一个flag
        while (slow != fast || start == 0) {
            start = 1;
            slow = slow.next;
            if (fast == null || fast.next == null || fast.next.next == null) {
                //有环的坏就永远不会为null
                return null;
            }
            fast = fast.next.next;
        }
        //slow 和 fast相遇
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }

        return p;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
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
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 2722 👎 0
