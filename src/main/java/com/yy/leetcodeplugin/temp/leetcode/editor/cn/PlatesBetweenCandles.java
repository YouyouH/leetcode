
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-02 10:25:20 
//蜡烛之间的盘子

public class PlatesBetweenCandles{
    public static void main(String[] args) {
         Solution solution = new PlatesBetweenCandles().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        /**
         * Fixme 对于每个区间，找到左右两边的第一个盘子
         * 累计盘子数量但是只有遇到蜡烛才更新前缀和。
         * 0,0,0,0,0,2,2,2,2,5
         * Fixme: 每次查询才寻找盘子也超时了，需要预处理盘子的位置，找到对于每一个点左边和右边的盘子在哪
         */
        char[] array = s.toCharArray();
        int len = array.length;
        int[] plates = new int[len];//记录每个蜡烛处对应的盘子的前缀和
        int sum = 0;
        boolean firstPlate = true;

        for (int i = 0; i < len; i++) {
            if (array[i] == '|') {//遇到蜡烛
                if (firstPlate) {
                    firstPlate = false;
                    sum = 0;//重新计数
                }
                if(i>0) {
                    plates[i] = sum;
//                    System.out.println("i=" + sum);
                }
            }else{
                //遇到盘子
                sum += 1;
            }
        }

        int[] leftPlates = new int[len];
        int l = -1;//-1表示左边没有蜡烛
        for (int i = 0; i < len; i++) {
            if (array[i] == '|') {
                l = i;
            }
            leftPlates[i] = l;
        }

        int[] rightPlates = new int[len];
        int r = -1;//-1表示左边没有蜡烛
        for (int i = len - 1; i >= 0; i--) {
            if (array[i] == '|') {
                r = i;
            }
            rightPlates[i] = r;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int rightPlate = rightPlates[left];
            int leftPlate = leftPlates[right];
            if (rightPlate == -1 || leftPlate == -1 || leftPlate <=rightPlate) {
                ans[i] = 0;
            }else {
                ans[i] = plates[leftPlate] - plates[rightPlate];
            }
//            System.out.println("left=" + left + " right=" + right + " leftPlate" + leftPlate + " rightPlate" + rightPlate);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|
//' 表示一支 蜡烛 。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[
//lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。 
//
// 
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
// 
//
// 示例 2: 
//
// 
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
//]]
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 10⁵ 
// s 只包含字符 '*' 和 '|' 。 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= lefti <= righti < s.length 
// 
//
// Related Topics 数组 字符串 二分查找 前缀和 👍 190 👎 0
