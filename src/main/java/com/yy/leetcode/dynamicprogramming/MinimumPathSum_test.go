package main

import "testing"

func TestMinimumPathSum(t *testing.T) {
	grid := [][]int{
		{1, 3, 1}, {1, 5, 1}, {4, 2, 1},
	}
	if 7 != MinPathSum(grid) {
		t.Fail()
	}

	grid = [][]int{
		{1, 3, 1},
	}
	if 5 != MinPathSum(grid) {
		t.Fail()
	}

	grid = [][]int{
		{1},
	}
	if 1 != MinPathSum(grid) {
		t.Fail()
	}
}
