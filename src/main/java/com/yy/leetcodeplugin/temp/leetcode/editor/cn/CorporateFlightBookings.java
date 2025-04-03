
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-03 16:19:27 
//航班预订统计

import java.util.Arrays;
import java.util.Comparator;

public class CorporateFlightBookings{
    public static void main(String[] args) {
         Solution solution = new CorporateFlightBookings().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        /**
         * 需要不停的修改，使用差分数组
         *  FIXME: 航班编号是从1开始的莫不是0，但是diff数组是从0开始的，所以航宝号要减一
         */
//        int maxFlight = Arrays.stream(bookings).max(Comparator.comparingInt(a -> a[1])).get()[1];
        int[] diff = new int[n];
        //构建差分数组
        for (int i = 0; i < bookings.length; i++) {
            diff[bookings[i][0]-1] += bookings[i][2];
            if (bookings[i][1] < n) {
                diff[bookings[i][1]] -= bookings[i][2];
            }
        }
        int[] res = new int[n];
        int count = 0;
        int diffSum = 0;
        for (int i = 0; i < diff.length; i++) {
            diffSum += diff[i];
            if (diffSum > 0) {
                res[count] = diffSum;
                count++;
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
//
// Related Topics 数组 前缀和 👍 546 👎 0
