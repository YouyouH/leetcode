package binarySearch

import "testing"

func TestSearchInRotatedSortedArrayII(t *testing.T) {
	matrix := []int{2, 5, 6, 0, 0, 1, 2}

	if false == search(matrix, 0) {
		t.Fatal("0")
	}

	if true == search(matrix, 3) {
		t.Fatal("3")
	}

	//matrix2 := []int{2,3,4}
	//
	//if false == search(matrix2,4) {
	//	t.Fatal("4")
	//}
	//if true == search(matrix2,1) {
	//	t.Fatal("1")
	//}
}

func TestSearchInRotatedSortedArrayII2(t *testing.T) {
	matrix := []int{2}

	if false == search(matrix, 2) {
		t.Fatal("2")
	}

	if true == search(matrix, 3) {
		t.Fatal("3")
	}

	matrix2 := []int{1, 1}
	if true == search(matrix2, 0) {
		t.Fatal("0")
	}
}

func TestSearchInRotatedSortedArrayII5(t *testing.T) {
	matrix := []int{1, 3}

	if false == search(matrix, 3) {
		t.Fatal("3")
	}

	if false == search(matrix, 1) {
		t.Fatal("1")
	}
}

func TestSearchInRotatedSortedArrayII3(t *testing.T) {
	matrix := []int{1, 0, 1, 1, 1, 1}

	if false == search(matrix, 0) {
		t.Fatal("0")
	}
}

func TestSearchInRotatedSortedArrayII4(t *testing.T) {
	matrix := []int{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}

	if false == search(matrix, 2) {
		t.Fatal("2")
	}
}

func TestSearchInRotatedSortedArrayII6(t *testing.T) {
	matrix := []int{1}

	if true == search(matrix, 0) {
		t.Fatal("0")
	}
}
