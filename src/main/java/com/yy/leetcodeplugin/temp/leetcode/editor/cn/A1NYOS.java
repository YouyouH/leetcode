//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 👍 29 👎 0


package com.yy.leetcodeplugin.temp.leetcode.editor.cn;
//date: 2022-01-12 19:13:19
//0 和 1 个数相同的子数组

import java.util.HashMap;
import java.util.Map;

public class A1NYOS{
    public static void main(String[] args) {
         Solution solution = new A1NYOS().new Solution();
        solution.findMaxLength(new int[]{0, 1, 0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        //前缀和，计算前i个数的 0 1 分布
        //例如：01101101，前缀和为-1，0，1，0，1，2，1，2。 0表示一样
        //用哈希表记录位置和前缀和，第一次遇到的前缀和为起点，后面遇到的为终点，不断更新最远距离
        int[] preSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
                preSum[i] = sum - 1;
            } else {
                sum += 1;
            }
            preSum[i] = sum;
        }
        int max = 0;

        Map<Integer, Integer> p2sum = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            int s = preSum[i];
            //如果是0则说明01数量刚好一样
            if (s == 0) {
                max = Math.max(max, i+1);
                continue;
            }
            if (p2sum.containsKey(s)) {
                //下一次遇到则更新最大距离
                max = Math.max(max,i - p2sum.get(s));
            }else{
                //第一次遇到则直接保存，作为比较距离的起始位置
                p2sum.put(s, i);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}