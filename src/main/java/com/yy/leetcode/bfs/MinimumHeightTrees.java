package com.yy.leetcode.bfs;

import java.util.*;


/**
 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。

 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。

 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。

 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。

 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 输出：[1]
 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。

 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 输出：[3,4]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-height-trees
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumHeightTrees {

    //超时！！！！！！！！！！！！！！
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int temp = n;
        while (--temp >=0){
            map.put(temp, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int l1 = edge[0];
            int l2 = edge[1];
            map.get(l1).add(l2);
            map.get(l2).add(l1);
        }

        /**
         宽度遍历
         */
        if(n == 1){
            return Arrays.asList(0);
        }

        int minHeight = Integer.MAX_VALUE;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int height = 0;
            Set<Integer> visitted = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visitted.add(i);

            while (!queue.isEmpty()) {
                height++;
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    List<Integer> next = map.get(cur);
                    for (Integer integer : next) {
                        if (!visitted.contains(integer)) {
                            queue.add(integer);
                            visitted.add(integer);
                        }
                    }
                }
            }
            if (height == minHeight) {
                result.add(i);
            } else if (height < minHeight) {
                result = new ArrayList<>();
                result.add(i);
                minHeight = height;
            }

        }
        return result;
    }



    //超时！！！！！！！！！！！！！！
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        /**
         宽度遍历
         */
        if(n == 1){
            return Arrays.asList(0);
        }

        int minHeight = Integer.MAX_VALUE;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int height = 0;
            Set<Integer> visitted = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visitted.add(i);

            while (!queue.isEmpty()) {
                height++;
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    for (int j = 0; j < edges.length; j++) {
                        int[] vector = edges[j];
                        if (cur == vector[0]) {
                            if (!visitted.contains(vector[1])) {
                                queue.add(vector[1]);
                                visitted.add(vector[1]);
                            }
                        } else if (cur == vector[1]) {
                            if (!visitted.contains(vector[0])) {
                                queue.add(vector[0]);
                                visitted.add(vector[0]);
                            }
                        }
                    }
                }
            }
            if (height == minHeight) {
                result.add(i);
            } else if (height < minHeight) {
                result = new ArrayList<>();
                result.add(i);
                minHeight = height;
            }

        }
        return result;
    }

}
