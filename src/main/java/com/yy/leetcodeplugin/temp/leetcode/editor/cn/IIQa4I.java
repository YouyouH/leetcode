//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
// Related Topics 栈 数组 单调栈 👍 24 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-02-09 18:37:19
//每日温度

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IIQa4I{
    public static void main(String[] args) {
         Solution solution = new IIQa4I().new Solution();
        solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈
        //思路是抄的答案
        //遍历数组，用一个栈来保存下标，不是温度！温度可以通过下标得到
        //当栈为空的时候，存进去
        //当栈不为空时，比较当前温度和栈顶温度，如果当前温度比栈顶温度高，则出栈。并且更新等待天数，循环这个过程，知道栈顶的温度比当前温度高
        //如果当前温度比栈顶温度低，则进栈。
        //所以栈里面的温度一定是单调的
        Deque<Integer> stack = new LinkedList<>();
        int length = temperatures.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}