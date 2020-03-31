package com.yy.leetcode.bfs;

/**
 * @author youyouhuang
 * @create 2020-03-31
 * @desc https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * <p>
 * 示例 1：
 * 输入：[[1,0,1],
 *      [0,0,0],
 *      [1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 **/

import java.util.LinkedList;

/**
 * bfs.
 * 根节点是所有陆地节点1,通过bfs每找到一个海洋就标记当前层数(即距离)。
 * 如果周围全是海洋,则周围一圈海洋作为根节点，通过BFS找海洋并设置距离。
 */
public class AsFarfromLandasPossible {

    public int maxDistance(int[][] grid) {
        if(grid == null){
            return -1;
        }
        int row = grid.length;
        if(row == 0){
            return -1;
        }
        int col = grid[0].length;
        LinkedList<Pos> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    queue.offer(new Pos(i, j, 1));
                }

            }
        }

        int max = 0;

        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            int i = pos.i;
            int j = pos.j;
            int level = pos.level;
            max= Math.max(max,level);
            if(i-1>=0 && grid[i-1][j] == 0){
                grid[i-1][j] = level+1;
                queue.offer(new Pos(i-1,j,level+1));
            }
            if(i+1<=row-1 && grid[i+1][j] == 0){
                grid[i+1][j] = level+1;
                queue.offer(new Pos(i+1,j,level+1));
            }
            if(j-1>=0 && grid[i][j-1] == 0){
                grid[i][j-1] = level+1;
                queue.offer(new Pos(i,j-1,level+1));
            }
            if(j+1<=col-1 && grid[i][j+1] == 0){
                grid[i][j+1] = level+1;
                queue.offer(new Pos(i,j+1,level+1));
            }
        }
//        int max = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                max = Math.max(max, grid[i][j]);
//            }
//        }
        return max-1>0? max-1 : -1;

    }
}
