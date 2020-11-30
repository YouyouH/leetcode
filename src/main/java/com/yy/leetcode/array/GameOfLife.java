package com.yy.leetcode.array;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangyou
 */
public class GameOfLife {

    /**
     * 活得变成死的，(1->0)记为 -1
     * 死的记为活的  (0->1)记为 2
     */
    public void gameOfLife(int[][] board) {
        if (null == board) return;
        int[] neighbours = new int[]{-1, 0, 1};
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                update(i, j, rowLength, colLength, board, neighbours);
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private void update(int i, int j, int rowLength, int colLength, int[][] board, int[] neighbours) {
        int live = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int r = i + neighbours[k];
                int c = j + neighbours[l];
                if (!(neighbours[k] == 0 && neighbours[l] == 0) && r >= 0 && r < rowLength && c >= 0 && c < colLength) {
                    if (board[r][c] == 1 || board[r][c] == -1) {
                        live++;
                    }
                }
            }
        }
        if (live < 2 && board[i][j] == 1) {
            board[i][j] = -1;
        } else if (live == 3 && board[i][j] == 0) {
            board[i][j] = 2;
        } else if (live > 3 && board[i][j] == 1) {
            board[i][j] = -1;
        }

    }
}
