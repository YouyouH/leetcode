
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-26 20:15:09 
//范围内整数的最大得分

import java.util.Arrays;

public class MaximizeScoreOfNumbersInRanges{
    public static void main(String[] args) {
         Solution solution = new MaximizeScoreOfNumbersInRanges().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int maxPossibleScore(int[] start, int d) {
                /**
                 * 二分法找最大得分
                 *  FIXME: 要对数组排序才可以转化成比较相邻的两个数
                 */
                Arrays.sort(start);
                long l = 0; //差的绝对值最小为0
                long r = Arrays.stream(start).max().getAsInt() + d;//差的最大值是所有区间的最大值

                int ans = 0;
                while (l <= r) {
                    long mid = l + (r - l) / 2;
                    if (check(mid, start, d)) {
                        ans = (int) mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                return ans;
            }


            //检查两个数的差大于等于target
            private boolean check(long target, int[] start, int d) {
                long left = start[0];//记录上一次的数
                for (int i = 1; i < start.length; i++) {
                    //如果left + target没有达到下一个区间的左边界，就取下一个区间左边界最小值,差值肯定比target还大，符合要求
                    left = Math.max(start[i], left + target);
                    if (left > start[i] + d) {//不能超过区间右边界
                        return false;
                    }
                }
                return true;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个整数数组 start 和一个整数 d，代表 n 个区间 [start[i], start[i] + d]。 
//
// 你需要选择 n 个整数，其中第 i 个整数必须属于第 i 个区间。所选整数的 得分 定义为所选整数两两之间的 最小 绝对差。 
//
// 返回所选整数的 最大可能得分 。 
//
// 
//
// 示例 1： 
//
// 
// 输入： start = [6,0,3], d = 2 
// 
//
// 输出： 4 
//
// 解释： 
//
// 可以选择整数 8, 0 和 4 获得最大可能得分，得分为 min(|8 - 0|, |8 - 4|, |0 - 4|)，等于 4。 
//
// 示例 2： 
//
// 
// 输入： start = [2,6,13,13], d = 5 
// 
//
// 输出： 5 
//
// 解释： 
//
// 可以选择整数 2, 7, 13 和 18 获得最大可能得分，得分为 min(|2 - 7|, |2 - 13|, |2 - 18|, |7 - 13|, 
//|7 - 18|, |13 - 18|)，等于 5。 
//
// 
//
// 提示： 
//
// 
// 2 <= start.length <= 10⁵ 
// 0 <= start[i] <= 10⁹ 
// 0 <= d <= 10⁹ 
// 
//
// Related Topics 贪心 数组 二分查找 排序 👍 19 👎 0
