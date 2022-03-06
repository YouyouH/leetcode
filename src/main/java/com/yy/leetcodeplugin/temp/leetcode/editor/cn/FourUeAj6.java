  //给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。 
//
// 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。 
//
// 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。 
//
// 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。 
//
// 
//
// 示例 1： 
//
// 
// 
//
// 
//输入：head = [3,4,1], insertVal = 2
//输出：[3,4,1,2]
//解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后
//，整个列表如上图所示，最后返回节点 3 。
//
//
// 
//
// 示例 2： 
//
// 
//输入：head = [], insertVal = 1
//输出：[1]
//解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
// 
//
// 示例 3： 
//
// 
//输入：head = [1], insertVal = 0
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= Number of Nodes <= 5 * 10^4 
// -10^6 <= Node.val <= 10^6 
// -10^6 <= insertVal <= 10^6 
// 
//
// 
//
// 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-
//circular-linked-list/ 
// Related Topics 链表 👍 30 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-06 17:34:42 
//排序的循环链表

  import com.yy.leetcode.linkedlist.ListNode;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Objects;
  import java.util.TreeMap;

  public class FourUeAj6{
    public static void main(String[] args) {
         Solution solution = new FourUeAj6().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        //方法一：遍历一遍,treemap找到左右边界节点。速度很快但空间占用大
        //单调非递减，说明可以相等
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        TreeMap<Integer, List<Node>> navi = new TreeMap<>();
        Node p = head.next;

        addNode(head, navi);

        while (p != head) {
            addNode(p,navi);
            p = p.next;
        }
        //小于等于insertVal
        Integer floorKey = navi.floorKey(insertVal);
        System.out.println("floor: " + floorKey);
        //大于等于insertVal
        Integer ceilingKey = navi.ceilingKey(insertVal);
        System.out.println("ceilingKey: " + ceilingKey);

        //处在第一个或者最后一个
        if (floorKey == null || ceilingKey == null) {
            //直接找最后一个节点（一样大小就找最后一个点）
            Node maxNode = navi.lastEntry().getValue().get(navi.lastEntry().getValue().size() - 1);

            newNode.next = maxNode.next;
            maxNode.next = newNode;
            return head;
        }


        if (Objects.equals(floorKey, ceilingKey)) {
            newNode.next = navi.get(floorKey).get(0).next;
            navi.get(floorKey).get(0).next = newNode;
        } else {
            if (navi.containsKey(ceilingKey)) {
                newNode.next = navi.get(ceilingKey).get(0);
            }
            if (navi.containsKey(floorKey)) {
                navi.get(floorKey).get(navi.get(floorKey).size()-1).next = newNode;
            }
        }

        return head;
    }

    private void addNode(Node node, TreeMap<Integer, List<Node>> navi) {
        if (navi.containsKey(node.val)) {
            navi.get(node.val).add(node);
        }else{
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            navi.put(node.val, list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
