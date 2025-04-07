
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-07 14:33:28 
//用邮票贴满网格图

public class StampingTheGrid{
    public static void main(String[] args) {
         Solution solution = new StampingTheGrid().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        /**
         * FIXME 看的答案
         * 1.对每一个点求二维前缀和
         *      方便判断每一个点能否放邮票
         * 2.遍历前缀和矩阵，判断哪些点能放邮票。对于能放邮票的区域每个点都加一
         *      因为要修改数组所以用差分矩阵表示每个点的变化速度更快
         * 3.累加差分矩阵，如果遇到一个点是空的但是差分值等于0说明这个点没有被邮票覆盖
         *      累加差分值就是在还原矩阵
         */
        int row = grid.length;
        int col = grid[0].length;

        //求前缀和
        int[][] sumArray = new int[row+1][col+1];//加一行和一列方便计算第一行和第一列的前缀和
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //加一行和一列方便计算第一行和第一列的前缀和
                sumArray[i + 1][j + 1] = sumArray[i + 1][j] + sumArray[i][j + 1] - sumArray[i][j] + grid[i][j];
            }
        }

        //遍历所有可能的点判断能不能放邮票
        //用差分数组保存对矩阵的修改
        int[][] diff = new int[row+1][col+1];
        for (int i = stampHeight-1; i < row; i++) {
            for (int j = stampWidth - 1; j < col; j++) {
                int sum = sumArray[i + 1][j + 1] - sumArray[i + 1][j + 1 - stampWidth] - sumArray[i + 1 - stampHeight][j + 1] + sumArray[i + 1 - stampHeight][j + 1 - stampWidth];
                if (sum == 0) {//说明这一片的格子都是0，那么就可以贴邮票,这一片全部加1
                    diff[i - stampHeight + 1][j - stampWidth + 1]++;
                    diff[i + 1][j - stampWidth + 1]--;
                    diff[i - stampHeight + 1][j + 1]--;
                    diff[i + 1][j + 1]++;

                }
            }
        }

        //还原差分数组，检查有没有空格的值是0
        //FIXME 用前缀和计算差分数组
        int[][] a = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                a[i][j] += a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + diff[i-1][j-1];
                if (a[i][j] == 0 && grid[i - 1][j - 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 m x n 的二进制矩阵 grid ，每个格子要么为 0 （空）要么为 1 （被占据）。 
//
// 给你邮票的尺寸为 stampHeight x stampWidth 。我们想将邮票贴进二进制矩阵中，且满足以下 限制 和 要求 ： 
//
// 
// 覆盖所有 空 格子。 
// 不覆盖任何 被占据 的格子。 
// 我们可以放入任意数目的邮票。 
// 邮票可以相互有 重叠 部分。 
// 邮票不允许 旋转 。 
// 邮票必须完全在矩阵 内 。 
// 
//
// 如果在满足上述要求的前提下，可以放入邮票，请返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0],[1,0,0,0]], stampHeight = 
//4, stampWidth = 3
//输出：true
//解释：我们放入两个有重叠部分的邮票（图中标号为 1 和 2），它们能覆盖所有与空格子。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]], stampHeight = 2, 
//stampWidth = 2 
//输出：false 
//解释：没办法放入邮票覆盖所有的空格子，且邮票不超出网格图以外。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[r].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 2 * 10⁵ 
// grid[r][c] 要么是 0 ，要么是 1 。 
// 1 <= stampHeight, stampWidth <= 10⁵ 
// 
//
// Related Topics 贪心 数组 矩阵 前缀和 👍 159 👎 0
