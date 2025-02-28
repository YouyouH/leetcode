
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-25 17:46:47 
//N 皇后

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
         Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        /**
         * FIXME: 看的答案
         *      题目要求每一行，每一列，以及斜线上不能有棋子。同时棋盘大小是n*n并且要放n个棋子，即每一行，每一列都肯定有一个棋子。
         *      可以遍历每一行，再递归寻找下一个位置。
         *          如何判断下一个位置是否合法？
         *              1.每一行只能有一个，用循环遍历
         *              2.对于每一列，记录每个棋子的列号
         *              3.对于斜行，有两个方向，这两个方向上点的特点是坐标差/坐标和是不变的，可以分别记录下来
         *
         */

        boolean[] xa = new boolean[n+n]; //记录斜行坐标和
        boolean[] xb = new boolean[n+n];   //记录斜行坐标差
        boolean[] col = new boolean[n];  //记录列号

        int[] queens = new int[n];

        traverse(0, xa, xb, col, queens);

        return ans;

    }

            /**
             * @param r 当前行
             */
            private void traverse(int r, boolean[] xa, boolean[] xb, boolean[] col, int[] queens) {
                if (r == queens.length) {//最后一行n-1 已经处理过了，可以存起来了
                    List<String> list = new ArrayList<>();
                    for (int queen : queens) {
                        char[] chars = new char[queens.length];
                        Arrays.fill(chars, '.');
                        chars[queen] = 'Q';
                        list.add(new String(chars));
                    }
                    ans.add(list);
                    return;
                }

                //因为每一行一定有且只有一个棋子，所以r表示行号，每一层递归+1
                //i 表示列号
                for (int i = 0; i < queens.length; i++) {
                    int diff = r - i + queens.length - 1;
//                    int diff = Math.abs(r - i); FIXME 不能取绝对值，否则例子中（2,0） 和 （1,3）就是重复的不能用了
                    if (!xa[r + i] && !xb[diff] && !col[i]) {
                        //当前位置可以放
                        queens[r] = i; //表示第r行第i列放棋子  注意这里不用还原？因为遍历i的时候就直接覆盖了
                        xa[r + i] = xb[diff] = col[i] = true;
                        traverse(r+1, xa, xb, col,queens);
                        xa[r + i] = xb[diff] = col[i] = false;
                    }

                }

            }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2240 👎 0
