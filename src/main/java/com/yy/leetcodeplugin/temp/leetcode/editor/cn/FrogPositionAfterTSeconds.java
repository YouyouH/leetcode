
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-04 14:15:38 
//T 秒后青蛙的位置

import java.util.ArrayList;
import java.util.List;

public class FrogPositionAfterTSeconds{
    public static void main(String[] args) {
         Solution solution = new FrogPositionAfterTSeconds().new Solution();
        solution.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 2, 4);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            private double res = 0;

            public double frogPosition(int n, int[][] edges, int t, int target) {
                /**
                 *
                 *  注意：
                 *     1.青蛙可以在目标上原地跳跃。所以要么t秒的时候刚好到达目标/或者t秒内到达目标之后没法往别的地方跳了。否则最后不算到达目标
                 */
                List<ArrayList<Integer>> edge = new ArrayList<>(n + 1);//编号从1开始
                edge.add(new ArrayList<>());
                for (int i = 1; i <= n; i++) {
                    edge.add(new ArrayList<>(n+1));
                }
                for (int[] array : edges) {//无向树所以两个方向都有可能
                    edge.get(array[0]).add(array[1]);
                    edge.get(array[1]).add(array[0]);
                }

                boolean[] visited = new boolean[n + 1];

                traverse(1, edge, t, target, 1,visited);

                return res == 0 ? 0 : 1 / res;


            }

            private void traverse(int root, List<ArrayList<Integer>> edge, int t, int target, double ans,boolean[] visited) {
                if (visited[root]) {
                    return;
                }
                visited[root] = true;
                if (t == 0) {
                    if (root == target) {
                        res = ans;
                    }
                    return;//时间到了不能再跳了
                }
                //时间没到继续跳
                ArrayList<Integer> children = edge.get(root);
                if (root == target) {
                    //时间还没到就跳到了target,此时判断是不是原地跳，如果是原地跳那么就找到答案了
                    boolean jump = false;
                    for (Integer child : children) {
                        if (!visited[child]) {
                            jump = true;
                            break;
                        }
                    }
                    if (!jump) {
                        res = ans;
                        return;
                    }else{
                        //跳过去就不会再回来了，所以概率变成0了
                        res = 0;
                        return;
                    }

                }

                //没有访问过的节点
                int size = (int) children.stream().filter(child->!visited[child]).count();
                for (Integer child : children) {
                    if(!visited[child]) {
                        traverse(child, edge, t - 1, target, ans * size, visited);
                    }
                }


            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下： 
//
// 
// 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。 
// 青蛙无法跳回已经访问过的顶点。 
// 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。 
// 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。 
// 
//
// 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。 
//
// 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10⁻⁵ 的结果将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//输出：0.16666666666666666 
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙
//在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//输出：0.3333333333333333
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 图 👍 125 👎 0
