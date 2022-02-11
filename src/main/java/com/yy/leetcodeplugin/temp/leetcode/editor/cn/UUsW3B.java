  //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
// Related Topics 数组 回溯 👍 11 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-02-11 13:09:02 
//含有 k 个元素的组合

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class UUsW3B{
    public static void main(String[] args) {
         Solution solution = new UUsW3B().new Solution();
        solution.combine(4, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> combine(int n, int k) {
            //递归加回溯
            List<List<Integer>> res = new ArrayList<>();

            combine0(1, new ArrayList<>(), res, k, n);
            return res;
        }

        private void combine0(int start, List<Integer> tmp, List<List<Integer>> res, int k, int n) {
            //注意！！！！这里可以减枝，可能出现剩下数字数量加起来已经不够K了
            if (tmp.size() == k) {
                res.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = start; i <= n; i++) {
                tmp.add(i);
                combine0(i + 1, tmp, res, k, n);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}