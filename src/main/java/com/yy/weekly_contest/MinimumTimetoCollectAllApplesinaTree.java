package com.yy.weekly_contest;
/**
 * @author youyouhuang
 * @create 2020-05-10
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 *
 * 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class MinimumTimetoCollectAllApplesinaTree {

    /**
     *从每一个苹果节点往根节点找，把经历过的边都加进去，去掉重复的。最后乘以2.
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Integer> connections = buildConnectionsFromChildToParent(edges);

        Map<Integer,Integer> visitted = new HashMap<>();

        for (int i = 0; i < hasApple.size(); i++) {
            if(hasApple.get(i)) {
                dfs(i,connections,visitted);
            }
        }
        return visitted.size() << 1;
    }

    private void dfs(Integer child, Map<Integer, Integer> connections, Map<Integer, Integer> visitted) {
        if(child == null){
            return;
        }
        if (null != connections.get(child)) {
            visitted.put(child,connections.get(child));
        }
        dfs(connections.get(child),connections,visitted);
    }

    private Map<Integer, Integer> buildConnectionsFromChildToParent(int[][] edges) {
        Map<Integer, Integer> connections = new HashMap<>();
        for (int[] edge : edges) {
//            connections.computeIfAbsent(edge[0],key->new ArrayList<>()).add(edge[1]);
            connections.put(edge[1],edge[0]);
        }
        return connections;
    }
}
