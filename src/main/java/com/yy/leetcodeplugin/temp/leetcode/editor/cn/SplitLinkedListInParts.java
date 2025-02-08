
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-08 18:22:11 
//分隔链表

public class SplitLinkedListInParts{
    public static void main(String[] args) {
         Solution solution = new SplitLinkedListInParts().new Solution();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        solution.splitListToParts(node1, 3);
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        /**
         * 怎么划分?
         *  四个数分成三份， 211 220不行，2和0相差2
         *   5个数分成三份 5/3=1 余数2，将余数分成2份加到前两个部分   2 2 1
         *   三个数分成5份，3/5 = 0 余数3，将余数3分到前三份，111 00
         *   十个数分成三份， 10/3 = 3 余数1，分到第一份  4 3 3
         */
        int n = 0;

        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
//        System.out.println("length=" + n);

        int partSize = n / k;

        int extra = n % k;

        p = head;

        ListNode[] nodes = new ListNode[k];
        //划分成每一部分去生成   //5个数分成三份 5/3=1 余数2，将余数分成2份加到前两个部分   2 2 1
                            // 3个数分成5份，余数3 11100
        for (int i = 0; i < k; i++) {

            int size = partSize;
            if (extra-- > 0) {
                size += 1;
            }
//            System.out.println("size=" + size);
            if (0 == size) {
                nodes[i] = null;
                continue;
            }


            nodes[i] = p;

            while (p != null && --size > 0) {//--size 是为了让循环结束的时候指针指向最后一个节点，而不是下一个节点
                p = p.next;
            }
//            System.out.println("end p=" + p.val);
            //FIXME 注意学习下面这段怎么断开的
            ListNode next = p.next;
            p.next = null;
            p = next;

        }
        return nodes;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。 
//
// 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。 
//
// 返回一个由上述 k 部分组成的数组。 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3], k = 5
//输出：[[1],[2],[3],[],[]]
//解释：
//第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//解释：
//输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 1000] 
// 0 <= Node.val <= 1000 
// 1 <= k <= 50 
// 
//
// Related Topics 链表 👍 326 👎 0
