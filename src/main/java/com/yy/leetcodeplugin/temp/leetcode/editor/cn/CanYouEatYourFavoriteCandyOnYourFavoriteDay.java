
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-02 12:33:58 
//你能在你最喜欢的那天吃到你最喜欢的糖果吗？

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay{
    public static void main(String[] args) {
         Solution solution = new CanYouEatYourFavoriteCandyOnYourFavoriteDay().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        /**
         * 每天最少吃一颗糖，最多吃dailycap颗。
         * 要满足在第target天时，按照最慢的速度一天一颗，吃糖的总数要小于等于前favoriteType类糖果的总数并且大于前favoriteType-1类糖果的总数。
         * 或者满足
         *  按照最快的速度，吃糖的总数要大于 前favoriteType-1类糖果的总数。
         *
         *  先用前缀和把糖果算出来
         */
        int len = candiesCount.length;
        long[] sum = new long[len];
        sum[0] = candiesCount[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int qLen = queries.length;
        boolean[] ans = new boolean[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] query = queries[i];
            int type = query[0];
            int day = query[1];
            int cap = query[2];
            //能够吃的糖的范围
            long min = (long) 1 * (day + 1);//最慢的速度
            long max = (long) cap * (day + 1);//最快的速度
            //min-max这个范围要和sum[type-1] -sum[type](左开右闭区间) 有重叠
            if (type != 0) {
//                System.out.println("min=" + min + " max=" + max + " type-1=" + sum[type - 1] + " type=" + sum[type]);
            }

            if (type == 0) {
                ans[i] = (day + 1) <= sum[0];
            } else {
                ans[i] = (max > sum[type - 1] && max <= sum[type]) || (min > sum[type - 1] && min <= sum[type]) || (min <= sum[type - 1] && max >= sum[type]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数
//组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。 
//
// 你按照如下规则进行一场游戏： 
//
// 
// 你从第 0 天开始吃糖果。 
// 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。 
// 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。 
// 
//
// 请你构建一个布尔型数组 answer ，用以给出 queries 中每一项的对应答案。此数组满足： 
//
// 
// answer.length == queries.length 。answer[i] 是 queries[i] 的答案。 
// answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 
//favoriteTypei 类糖果；否则 answer[i] 为 false 。 
// 
//
// 注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。 
//
// 请你返回得到的数组 answer 。 
//
// 
//
// 示例 1： 
//
// 
//输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
//输出：[true,false,true]
//提示：
//1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
//2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 
//4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
//3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
// 
//
// 示例 2： 
//
// 
//输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,3
//0],[1,3,1]]
//输出：[false,true,true,false,false]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candiesCount.length <= 10⁵ 
// 1 <= candiesCount[i] <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 3 
// 0 <= favoriteTypei < candiesCount.length 
// 0 <= favoriteDayi <= 10⁹ 
// 1 <= dailyCapi <= 10⁹ 
// 
//
// Related Topics 数组 前缀和 👍 154 👎 0
