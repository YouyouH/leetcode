package binarySearch

import "testing"

func TestFindMinimumInRotatedSortedArray(t *testing.T) {
	matrix := []int{4, 5, 6, 7, 0, 1, 2}

	if 0 != findMin(matrix) {
		t.Fatal("0")
	}
}

func TestFindMinimumInRotatedSortedArray2(t *testing.T) {
	matrix := []int{4, 5, 6, 7, -5, -4, -3, -2, -1}

	if -5 != findMin(matrix) {
		t.Fatal("-5")
	}
}

func TestFindMinimumInRotatedSortedArray3(t *testing.T) {
	matrix := []int{4, 5, 6, 7, -8, -7, -6, -5, -4, -3, -2, -1}

	if -8 != findMin(matrix) {
		t.Fatal("-8")
	}
}

func TestFindMinimumInRotatedSortedArray4(t *testing.T) {
	matrix := []int{4}

	if 4 != findMin(matrix) {
		t.Fatal("4")
	}

	matrix2 := []int{5, 4}

	if 4 != findMin(matrix2) {
		t.Fatal("4")
	}
}
