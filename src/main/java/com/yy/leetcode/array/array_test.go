package array

import (
	"testing"
)

func TestPalindromeLinkedList(t *testing.T) {
	head := ListNode{
		Val: 0,
	}
	head.Next = &ListNode{
		Val: 1,
	}

	head.Next.Next = &ListNode{
		Val:  0,
		Next: nil,
	}
	if !IsPalindrome(&head) {
		t.Fail()
	}
}

func TestPalindromeLinkedList2(t *testing.T) {
	head := ListNode{
		Val: 0,
	}
	head.Next = &ListNode{
		Val: 1,
	}
	if IsPalindrome(&head) {
		t.Fail()
	}

}
