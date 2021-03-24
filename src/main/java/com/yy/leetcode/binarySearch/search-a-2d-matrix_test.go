package binarySearch

import "testing"

func TestSearchA2dMatrix(t *testing.T) {
	matrix := [][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 60},
	}
	if searchMatrix(matrix, 4) {
		t.Fatal("4")
	}

	if !searchMatrix(matrix, 16) {
		t.Fatal("16")
	}

	matrix2 := [][]int{
		{1, 3, 5, 7},
	}
	if searchMatrix(matrix2, 4) {
		t.Fatal("4")
	}

	if !searchMatrix(matrix2, 1) {
		t.Fatal("16")
	}
	if !searchMatrix(matrix2, 3) {
		t.Fatal("5")
	}

	matrix3 := [][]int{
		{1},
	}
	if !searchMatrix(matrix3, 1) {
		t.Fatal("1")
	}
}

func TestSearchA2dMatrix2(t *testing.T) {
	matrix4 := [][]int{
		{1, 1},
	}
	if searchMatrix(matrix4, 0) {
		t.Fatal("1")
	}
	if !searchMatrix(matrix4, 1) {
		t.Fatal("1")
	}
}

func TestSearchA2dMatrix3(t *testing.T) {
	matrix4 := [][]int{
		{1}, {3},
	}
	if !searchMatrix(matrix4, 3) {
		t.Fatal("1")
	}
}
