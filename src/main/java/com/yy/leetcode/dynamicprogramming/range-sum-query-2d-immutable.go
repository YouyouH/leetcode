package main

//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
type NumMatrix struct {
	cache [][]int
	row   int
	col   int
}

//前缀和，先把每一个点的值缓存起来
func Constructor2D(matrix [][]int) NumMatrix {
	row := len(matrix)
	if row == 0 {
		return NumMatrix{}
	}
	col := len(matrix[0])

	cache := make([][]int, row)
	for i := range cache {
		cache[i] = make([]int, col)
	}
	for i := range matrix {
		for j := range matrix[i] {
			if i == 0 && j == 0 {
				cache[i][j] = matrix[i][j]
			} else if i == 0 {
				cache[i][j] = cache[i][j-1] + matrix[i][j]
			} else if j == 0 {
				cache[i][j] = cache[i-1][j] + matrix[i][j]
			} else {
				cache[i][j] = cache[i-1][j] + cache[i][j-1] + matrix[i][j] - cache[i-1][j-1]
			}
		}
	}
	return NumMatrix{
		cache: cache,
		row:   row,
		col:   col,
	}

}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	if row2 > this.row || col2 > this.col {
		return 0
	}

	if row1 == 0 && col1 == 0 {
		return this.cache[row2][col2]
	}
	if row1 == 0 {
		return this.cache[row2][col2] - this.cache[row2][col1-1]
	}
	if col1 == 0 {
		return this.cache[row2][col2] - this.cache[row1-1][col2]
	}
	cache := this.cache
	return cache[row2][col2] - cache[row1-1][col2] - cache[row2][col1-1] + cache[row1-1][col1-1]
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */
