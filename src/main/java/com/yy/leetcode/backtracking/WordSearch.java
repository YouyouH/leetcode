package com.yy.leetcode.backtracking;
/**
 * @author youyouhuang
 * @create 2020-04-11
 **/

/**
 * <p>给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p> 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p> 示例:
 * <p> board = [   ['A','B','C','E'],   ['S','F','C','S'],   ['A','D','E','E'] ]
 * <p> 给定 word = "ABCCED", 返回 true
 * <p> 给定 word = "SEE", 返回 true
 * <p> 给定 word = "ABCB", 返回 false
 * <p> 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-search
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visit = new boolean[row][col];
                if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int pos, boolean[][] visit) {
        int row = board.length;
        int col = board[0].length;

        if (pos >= word.length()) {
            return true;
        }
        if (i >= row || i < 0 || j >= col || j < 0) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(pos)) {
            return false;
        } else {
            visit[i][j] = true;
        }
        boolean found = true;

        found = find(board, i - 1, j, word, pos + 1, visit) ||//上
                find(board, i, j - 1, word, pos + 1, visit) ||//左
                find(board, i + 1, j, word, pos + 1, visit) ||//下
                find(board, i, j + 1, word, pos + 1, visit);//右
        if(!found){
            visit[i][j] = false;
        }
        return found;
    }
}
