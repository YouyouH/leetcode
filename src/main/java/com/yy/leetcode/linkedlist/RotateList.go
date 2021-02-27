package linkedlist

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return head
	}
	tail := head

	size := 1
	for tail != nil {
		if tail.Next == nil {
			break
		}
		tail = tail.Next
		size++
	}

	move := k % size
	if move == 0 {
		return head
	}

	p2 := head
	move = size - move
	for move > 1 {
		p2 = p2.Next
		move--
	}
	newHead := p2.Next
	p2.Next = nil
	tail.Next = head
	return newHead
}
