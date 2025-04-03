
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-03 15:08:48 
//人口最多的年份

public class MaximumPopulationYear{
    public static void main(String[] args) {
         Solution solution = new MaximumPopulationYear().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPopulation(int[][] logs) {
        /**
         * 用差分数组保存人口，对于频繁变动的数组，差分数组修改更简单
         * 另外由于数据范围是1950-2050，所以可以-1950让差分数组长度更小
         */

        int[] diff = new int[2050 - 1950 + 1 + 1];//101个数，再额外加一，方便处理
        int offset = 1950;
        for (int i = 0; i < logs.length; i++) {
            diff[logs[i][0] - offset]++;
            diff[logs[i][1] - offset]--;//当年死亡的不计入，所以不用logs[i][1] - offset + 1
        }

        int max = 0;
        int diffCount = 0;
        int year = 0;
        for (int i = 0; i < 102; i++) {
            diffCount += diff[i];
            if (diffCount > max) {//变化量的最大值（此题一定为正数）的时候就是人口达到最大值的时候
                max = diffCount;
                year = i + offset;
            }
        }
        return year;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。 
//
// 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内
//。注意，人不应当计入他们死亡当年的人口中。 
//
// 返回 人口最多 且 最早 的年份。 
//
// 
//
// 示例 1： 
//
// 输入：logs = [[1993,1999],[2000,2010]]
//输出：1993
//解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
// 
//
// 示例 2： 
//
// 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
//输出：1960
//解释： 
//人口最多为 2 ，分别出现在 1960 和 1970 。
//其中最早年份是 1960 。 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 1950 <= birthi < deathi <= 2050 
// 
//
// Related Topics 数组 计数 前缀和 👍 87 👎 0
