
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-08 15:26:33 
//接雨水 II

public class TrappingRainWaterIi{
    public static void main(String[] args) {
         Solution solution = new TrappingRainWaterIi().new Solution();
        solution.trapRainWater(new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}});
    }

        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trapRainWater(int[][] heightMap) {
        /**
         * [[1,4,3,1,3,2],
         *  [3,2,1,3,2,4],
         *  [2,3,3,2,3,1]]
         *  二维接雨水
         *      对于每一个点
         *          周围一圈不能接雨水
         *          每一个点，横着看，左边最高值和右边最高值去较小的值。竖着看，上面的最高值和下面的最高值取最小值。
         *          两个最小值中取最小值，再减去自身高度就是接雨水的体积
         * FIXME：
         *   上面思路错误
         *           [12,13,1,12],
         *           [13,4,13,12],
         *           [13,8,10,12],
         *           [12,13,12,12],
         *           [13,13,13,13]]
         *           例如对于4这个格子，按上面的方案算出来是9，但实际上只能装8，因为隔壁的格子8只能装8，所以4装不了9，会流到8格子
         *
         *  先把最外围的一圈作为围栏， 选择一个最低的围栏， 如果这个围栏的邻节点都比它大， 此围栏可删除，
         *  邻节点作为新的围栏； 如果邻节点比它小， 那么邻节点可储蓄的水为 二者高度之差， 此时在邻节点设置围栏，
         *  高度为当前围栏高度即可
         */


        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//输出: 4
//解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
//输出: 10
// 
//
// 
//
// 提示: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
//
// 
//
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 765 👎 0
