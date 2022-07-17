  //给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// 
//
// 注意：本题与主站 120 题相同： https://leetcode-cn.com/problems/triangle/ 
// Related Topics 数组 动态规划 👍 17 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-07-17 21:09:07 
//三角形中最小路径之和

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;
  import java.util.StringJoiner;

  public class IlPe0q{
    public static void main(String[] args) {
         Solution solution = new IlPe0q().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastLine = new ArrayList<>();
        lastLine.add(triangle.get(0).get(0));
        int size = triangle.size();
        for (int i = 1; i < size; i++) {
//            System.out.println(lastLine);
            List<Integer> currentList = triangle.get(i);
            List<Integer> tmp = new ArrayList<>(currentList.size());
            for (int j = 0; j < currentList.size(); j++) {
                if (j == 0) {//处于左边界
                    tmp.add(currentList.get(j) + lastLine.get(j));
                } else if (j >= lastLine.size()) {//处于右边界
                    tmp.add(currentList.get(j) + lastLine.get(j-1));
                } else {
                    tmp.add(currentList.get(j) + Math.min(lastLine.get(j - 1), lastLine.get(j)));
                }
            }
            lastLine = tmp;
        }
//        System.out.println(lastLine);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lastLine.size(); i++) {
            min = Math.min(min, lastLine.get(i));
        }
        return min;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}