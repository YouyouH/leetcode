  //给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// 
//
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 26 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-07 13:05:44 
//合并排序链表

  import com.yy.leetcode.linkedlist.ListNode;

  import java.util.*;

  public class VvXgSW{
    public static void main(String[] args) {
         Solution solution = new VvXgSW().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        //多路归并

        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> pointers = new ArrayList<>(lists.length);
        //初始化指针
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            if (listNode == null) {
                continue;
            }
            pointers.add(listNode);
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode pointer : pointers) {
            priorityQueue.add(pointer);
        }


        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            //移动p
            p.next = listNode;
            p = p.next;
            //移动到链表下一个节点
            listNode = listNode.next;
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
            //如果有一个链表到头了，那就接着从剩下的链表拿。知道全部链表都到头了，queue就空了，退出循环
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
  }