package com.yy.leetcode.dfs;

/**
 * @author youyouhuang
 * @create 2020-03-30
 * @desc https://leetcode-cn.com/problems/surrounded-regions/
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 **/

/**
 * 图的DFS，确定root node为边界上的0，所有与边界O连通的都设成P。剩下的0改成X。最后再把P还原为0。
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (null == board) {
            return;
        }
        int row = board.length;
        if (board.length == 0) {
            return;
        }
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, row, col);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'P';
        } else {
            return;
        }
        dfs(board, i - 1, j, row, col);
        dfs(board, i + 1, j, row, col);
        dfs(board, i, j - 1, row, col);
        dfs(board, i, j + 1, row, col);
    }
}
