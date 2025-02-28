
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-02-26 21:23:01 
//最小高度树

import java.util.*;

public class MinimumHeightTrees{
    public static void main(String[] args) {
         Solution solution = new MinimumHeightTrees().new Solution();
         solution.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /**
         * 1.用map表示节点间的对应关系
         * 2.用宽度遍历求高度
         * FIXME: 暴力法超时了
         *  从树的最外层开始遍历，往里面遍历，最后剩下的那些点就是最矮的树的根节点。像剥洋葱一样
         *  一层一层的剥开，每剥一层都把对应点的出度减一。
         *      遍历边edges
         *          1.记录每个点的出度存成出度表
         *          2.记录每个点连着的其他点
         *      遍历出度表
         *          1.先把出度为1的点找出来加入队列
         *          2.遍历队列找到他们关联的点，并且每个点的出度减一
         *          3.剩下的点中，出度为1的点再找出来然后处理
         */
        if (n == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }

        int[] points = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            //求每个点的出度。出度为一的就是最外圈的节点
            points[edge[0]]++;
            points[edge[1]]++;
            //求每个点连接的节点
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            List<Integer> list2 = map.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }

        Deque<Integer> deque = new LinkedList<>();


        //先把出度为1的加进去
        for (int i = 0; i < n; i++) {
            if (points[i] == 1) {
                deque.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            res = new ArrayList<>();
            while (size-- > 0) {
                Integer point = deque.poll();
                res.add(point);
                List<Integer> nodes = map.get(point);
                for (Integer node : nodes) {
                    points[node]--;
                    if (points[node] == 1) {
                        deque.add(node);
                    }
                }

            }

        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，任何一个没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 树的 
//高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
// 
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 963 👎 0
