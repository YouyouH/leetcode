//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
//histogram/ 
// Related Topics 栈 数组 单调栈 👍 21 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-09 21:16:50
//直方图最大矩形面积

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZeroYnMMM{
    public static void main(String[] args) {
         Solution solution = new ZeroYnMMM().new Solution();
        Assert.assertEquals(10, solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(1, solution.largestRectangleArea(new int[]{1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        /*单调栈存下标，和前一题类似。为什么不存值？？因为存了值下标这个信息就丢掉了

        /*思路：枚举每一根柱子，如果画一个以这跟柱子为高的矩形，那么左右边界在哪？
        /*此时问题转化为，对于一根柱子，左右两边最近的低于它的柱子时哪一根？求出左右的范围之后，所有处于这两跟之间（不包括）的
        /*柱子就构成了一个矩形

        /*例如对于高度为2的柱子来说，左边最近的低于它的高度的柱子为高度为一的柱子，右边到边界。这样这个矩形就是1到边界（不包括1），
        /*则面积就是（5-1-1）*2=6
        /*转化之后，问题就可以用单调栈来解决了
        */

        Deque<Integer> stack = new LinkedList();

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            left[i] = heights.length - 1;
            right[i] = 0;
        }

        //先算每个柱子右边最近的低于它的
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        //如果到边界了就设置哨兵
        while (!stack.isEmpty()) {
            left[stack.pop()] = heights.length;
        }

        stack.clear();
        //再算每个柱子左边的最近的低于它的
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        //如果到边界了就设置哨兵
        while (!stack.isEmpty()) {
            right[stack.pop()] = -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (left[i] - right[i] - 1) * heights[i]);
        }

        return max;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}