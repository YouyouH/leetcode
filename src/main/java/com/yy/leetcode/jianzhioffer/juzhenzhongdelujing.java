package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-05-23
 **/

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;
import static jdk.nashorn.internal.objects.Global.print;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class juzhenzhongdelujing {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] visitted = new int[board.length][board[0].length];
//                    visitted[i][j] = 1;
                    if (dfs(i, j, 0, board, word, visitted)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index, char[][] board, String word, int[][] visitted) {
        if (index == word.length()) {
            return true;
        }
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (visitted[row][col] == 1) {
            return false;
        }
        visitted[row][col] = 1;
        printArrayInconsole(visitted);

        boolean result = dfs(row + 1, col, index + 1, board, word, visitted) ||
                dfs(row, col + 1, index + 1, board, word, visitted) ||
                dfs(row - 1, col, index + 1, board, word, visitted) ||
                dfs(row, col - 1, index + 1, board, word, visitted);

        visitted[row][col] = 0;
        printArrayInconsole(visitted);
        return result;

    }

    private void printArrayInconsole(int[][] visitted) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : visitted) {
            for (int anInt : ints) {
                stringBuilder.append(anInt);
            }
            stringBuilder.append("\r\n");
        }
        System.out.println(stringBuilder.toString());

    }
}
