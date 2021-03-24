package binarySearch

/**
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。

提示：

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
func searchMatrix(matrix [][]int, target int) bool {
	row := len(matrix)
	col := len(matrix[0])
	if 1 == col && 1 == row {
		return matrix[0][0] == target
	}

	rowLo := 0
	rowHi := row - 1
	rowMid := row / 2

	//calculate the row number where target exist in
	for rowHi >= rowLo {
		if target > matrix[rowMid][0] {
			rowLo = rowMid + 1
		} else if target < matrix[rowMid][0] {
			rowHi = rowMid - 1
		} else {
			return true
		}
		rowMid = rowLo + (rowHi-rowLo)/2
	}

	if rowHi < 0 {
		rowHi = rowLo
	}

	colLo := 0
	colHi := col - 1
	colMid := col / 2
	for colHi >= colLo {
		if target > matrix[rowHi][colMid] {
			colLo = colMid + 1
		} else if target < matrix[rowHi][colMid] {
			colHi = colMid - 1
		} else {
			return true
		}
		colMid = colLo + (colHi-colLo)/2
	}
	return false
}
