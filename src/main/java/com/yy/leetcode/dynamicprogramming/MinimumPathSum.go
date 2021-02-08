package main

//func main() {
//	grid := [][]int{
//		{1, 3, 1}, {1, 5, 1}, {4, 2, 1},
//	}
//	MinPathSum(grid)
//}

//定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-path-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
func MinPathSum(grid [][]int) int {
	//dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]

	if grid == nil {
		return 0
	}

	row, col := len(grid), len(grid[0])
	dp := make([][]int, row)
	for i := range dp {
		dp[i] = make([]int, col)
	}
	dp[0][0] = grid[0][0]

	n := 1
	for n < col {
		dp[0][n] = dp[0][n-1] + grid[0][n]
		n++
	}

	n = 1
	for n < row {
		dp[n][0] = dp[n-1][0] + grid[n][0]
		n++
	}

	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}

	return dp[row-1][col-1]

}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}
