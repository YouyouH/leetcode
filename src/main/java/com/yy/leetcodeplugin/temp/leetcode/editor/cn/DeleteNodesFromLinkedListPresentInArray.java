
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-09 20:28:27 
//从链表中移除在数组中存在的节点

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray{
    public static void main(String[] args) {
         Solution solution = new DeleteNodesFromLinkedListPresentInArray().new Solution();
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        /**
         *
         * FIXME 抄的这个答案更简洁。特别注意删除节点的写法：
         *  while (cur.next != null) {
         *     if (set.contains(cur.next.val)) {
         *          cur.next = cur.next.next; // 删除
         *          }
         *
         *
         * ListNode dummy = new ListNode(0, head);
         *         ListNode cur = dummy;
         *         while (cur.next != null) {
         *             if (set.contains(cur.next.val)) {
         *                 cur.next = cur.next.next; // 删除
         *             } else {
         *                 cur = cur.next; // 向后移动
         *             }
         *         }
         *         return dummy.next;
         *
         * 作者：灵茶山艾府
         * 链接：https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array/solutions/2843071/shao-bing-jie-dian-yi-ci-bian-li-pythonj-imre/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode p1 = dummyHead;
        ListNode p2 = head;

        while (p2 != null) {
            if (set.contains(p2.val)) {
                p2 = p2.next;//只移动p2
                p1.next = p2;//p1先暂时接上p2，后面还可以再更新
            }else{
                //没有遇到nums中的节点
                p1.next = p2;
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3], head = [1,2,3,4,5] 
// 
//
// 输出： [4,5] 
//
// 解释： 
//
// 
//
// 移除数值为 1, 2 和 3 的节点。 
//
// 示例 2： 
//
// 
// 输入： nums = [1], head = [1,2,1,2,1,2] 
// 
//
// 输出： [2,2,2] 
//
// 解释： 
//
// 
//
// 移除数值为 1 的节点。 
//
// 示例 3： 
//
// 
// 输入： nums = [5], head = [1,2,3,4] 
// 
//
// 输出： [1,2,3,4] 
//
// 解释： 
//
// 
//
// 链表中不存在值为 5 的节点。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// nums 中的所有元素都是唯一的。 
// 链表中的节点数在 [1, 10⁵] 的范围内。 
// 1 <= Node.val <= 10⁵ 
// 输入保证链表中至少有一个值没有在 nums 中出现过。 
// 
//
// Related Topics 数组 哈希表 链表 👍 10 👎 0
