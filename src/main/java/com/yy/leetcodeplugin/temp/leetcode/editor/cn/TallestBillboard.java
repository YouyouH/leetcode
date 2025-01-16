
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-01-13 14:09:27 
//最高的广告牌

import java.util.Arrays;

public class TallestBillboard{
    public static void main(String[] args) {
         Solution solution = new TallestBillboard().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tallestBillboard(int[] rods) {
        /**
         * 从支架中选择一部分，长度 <= 总长度的一半
         * 例如总长是23，就先用01背包判断 11（22/2），10（20/2），9（18/2）
         * FIXME：
         *  上面解法有问题，选出一半能凑出11，剩下的一半有12，不一定能凑出11
         *
         *  方案一：
         *  dp[i][j] 表示使用前i个钢筋，拼出两个支架，支架高度差值为j的情况下的总长度。对于每个支架有三个选择，放到左边，放到右边，不用。最后答案是dp[rods.length][0]/2
         *
         *  思考过程：
         *      1.每根钢筋有三种状态，放到左边，放到右边，不要
         *      2.两边加起来和小于总长度
         *      要让两边一样长，可以把两边差值当做状态。
         *
         *      dp[i][j] = mas{ //求max 是为了得到当差值i=0是的最大值，这样安装高度是总高的一半
         *          dp[i-1][j] //不用当前钢筋
         *          dp[i-1][j+rods[i]] + rods[i]  //当前钢筋放到较小的一边，会导致差值减小(相当于前一个状态差值j 更大)
         *          dp[i-1][j-rods[i]] + rods[i]  //当前钢筋放到较大的一边，会导致差值增大（相当于前一个状态差值j 小一些）
         *      }
         *
         *      注意 j-rods[i] 要求绝对值
         *
         *      此题题目说明总长小于5000，则差值j最大是5000
         */

        int sum = Arrays.stream(rods).sum();

        int[][] dp = new int[rods.length+1][sum+1];



        //初始化: 一根钢筋dp[1]怎么拼？
        //不行要用负无穷表示，这样确保及时加上rods[i]也是负无穷，仍然可以表示不能组成架子
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0; //3 4 3 3 2
        //dp[2][1] = dp[1][1], dp[1][5]+4, dp[1][-3]+4



        for (int i = 1; i < rods.length+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int a = dp[i - 1][j];

                int b = Integer.MIN_VALUE;
                if (j + rods[i - 1] < sum + 1) {
                    b = dp[i - 1][j + rods[i - 1]] + rods[i - 1];
                }

                int c = Integer.MIN_VALUE;
//                if (j - rods[i - 1] >= 0) {
//                    c = dp[i - 1][j - rods[i - 1]] + rods[i - 1];
//                }
                //这里要注意取绝对值，因为j是负数的时候相当于长的一边和短的一边换位置了
                c = dp[i - 1][Math.abs(j - rods[i - 1])] + rods[i - 1];

                dp[i][j] = Math.max(a, Math.max(b, c));
//                System.out.println("i=" + i + " j=" + j + " height=" + dp[i][j]);
            }
        }

        return dp[rods.length][0] < 0 ? 0 : dp[rods.length][0] / 2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。 
//
// 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。 
//
// 返回 广告牌的最大可能安装高度 。如果没法安装广告牌，请返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,6]
//输出：6
//解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3,4,5,6]
//输出：10
//解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。 
//
// 示例 3： 
//
// 
//输入：[1,2]
//输出：0
//解释：没法安装广告牌，所以返回 0。 
//
// 
//
// 提示： 
//
// 
// 0 <= rods.length <= 20 
// 1 <= rods[i] <= 1000 
// sum(rods[i]) <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 195 👎 0
