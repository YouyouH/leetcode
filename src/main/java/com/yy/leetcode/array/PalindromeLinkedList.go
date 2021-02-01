package array

/**
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false

示例 2:

输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
type ListNode struct {
	Val  int
	Next *ListNode
}

func IsPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}
	var array = []*ListNode{}

	for head != nil {
		array = append(array, head)
		head = head.Next
	}
	var l = 0
	var n = len(array) - 1
	for l < n {
		if array[l].Val != array[n].Val {
			return false
		}
		l++
		n--
	}
	return true
}
