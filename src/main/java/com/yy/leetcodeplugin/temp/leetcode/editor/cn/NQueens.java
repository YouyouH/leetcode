
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-25 17:46:47 
//N 皇后

import java.util.List;

public class NQueens{
    public static void main(String[] args) {
         Solution solution = new NQueens().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
