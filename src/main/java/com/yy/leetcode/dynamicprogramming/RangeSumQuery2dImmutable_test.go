package main

import "testing"

func TestRangeSumQuery2DImmutable(t *testing.T) {
	matrix := [][]int{
		{3, 0, 1, 4, 2},
		{5, 6, 3, 2, 1},
		{1, 2, 0, 1, 5},
		{4, 1, 0, 1, 7},
		{1, 0, 3, 0, 5},
	}
	obj := Constructor2D(matrix)
	if 8 != obj.SumRegion(2, 1, 4, 3) {
		t.Fail()
	}

	if 11 != obj.SumRegion(1, 1, 2, 2) {
		t.Fail()
	}

	if 14 != obj.SumRegion(0, 0, 1, 1) {
		t.Fail()
	}

	if 6 != obj.SumRegion(0, 1, 1, 1) {
		t.Fatal(6)
	}

	if 11 != obj.SumRegion(1, 0, 1, 1) {
		t.Fatal(11)
	}

}
