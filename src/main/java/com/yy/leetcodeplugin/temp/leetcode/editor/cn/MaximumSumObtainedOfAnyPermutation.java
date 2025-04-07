
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-07 15:20:33 
//所有排列中的最大和

import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;
import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class MaximumSumObtainedOfAnyPermutation{
    public static void main(String[] args) {
         Solution solution = new MaximumSumObtainedOfAnyPermutation().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private static final int MOD = 1_000_000_000 + 7;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        /**
         * 统计每个索引的查询次数
         * 将nums从大到小排列
         * 查询次数最多的索引放最大的数，查询次数第二多的就放第二大的数
         *
         * nums长度最大为10的5次方，在这个区间内需要频繁修改，所以用差分数组
         *
         */

        int length = nums.length;
        int[] count = new int[length];

        int[] diff = new int[length];
        for (int i = 0; i < requests.length; i++) {
            diff[requests[i][0]]++;
            if(requests[i][1] + 1 < length) {
                diff[requests[i][1] + 1]--;
            }
        }
        //找出所有查询过的索引，并按照查询次数group
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += diff[i];
            if (sum != 0) {
                count[i] = (sum);
            }
        }

        Arrays.sort(nums);
        Arrays.sort(count);//按出现次数排序
        long res = 0;
        for (int j = nums.length-1; j >=0; j--) {
//            System.out.println("num=" + count.get(nums));
            res = (res + (long) (count[j]) % MOD * nums[j]) % MOD;

        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 
//nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 
//endi 数组索引都是 从 0 开始 的。 
//
// 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。 
//
// 由于答案可能会很大，请你将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
//输出：19
//解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
//requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
//requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
//总和为：8 + 3 = 11。
//一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
//requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
//requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
//总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
//输出：11
//解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
//输出：47
//解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 1 <= requests.length <= 10⁵ 
// requests[i].length == 2 
// 0 <= starti <= endi < n 
// 
//
// Related Topics 贪心 数组 前缀和 排序 👍 74 👎 0
