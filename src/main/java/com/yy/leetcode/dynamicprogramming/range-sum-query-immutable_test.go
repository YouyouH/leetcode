package main

import "testing"

func TestRangeSumQueryImmutable(t *testing.T) {
	obj := Constructor([]int{1, 2, 3})
	if 6 != obj.SumRange(0, 2) {
		t.Fail()
	}
}
