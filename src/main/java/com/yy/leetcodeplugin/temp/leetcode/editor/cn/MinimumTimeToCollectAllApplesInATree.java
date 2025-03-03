
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-03 16:45:08 
//收集树上所有苹果的最少时间

import java.util.*;

public class MinimumTimeToCollectAllApplesInATree{
    public static void main(String[] args) {
         Solution solution = new MinimumTimeToCollectAllApplesInATree().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             *     1   0
             *     \  /  \
             *      2    3
             *
             *
             */
            private int ans = 0;
            public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
                /**
                 * 递归计算对于每一个点，访问他的所有子树（以及它自己）找到所有苹果需要的步数
                 */
                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int[] edge : edges) {
                    int from = edge[0];
                    int to = edge[1];
                    map.putIfAbsent(from, new ArrayList<>());
                    map.get(from).add(to);
                    map.putIfAbsent(to, new ArrayList<>());
                    map.get(to).add(from);
                }
                Set<Integer> visitted = new HashSet<>();
                //FIXME: 题目其实是无环图！不是树！所以需要记录visitted避免无限循环


                traverse(0, map, hasApple,visitted);
                return ans == 0? ans : (ans-1) * 2;
            }

            private boolean traverse(int head, Map<Integer, List<Integer>> map, List<Boolean> hasApple,Set<Integer> visitted) {
                if (visitted.contains(head)) {
                    return false;
                }
                visitted.add(head);
                if (!map.containsKey(head)) {
                    if (hasApple.get(head)) {
                        ans += 1;
//                        System.out.println("head=" + head + " ans=" + ans);
                        return true;
                    }
//                    System.out.println("head=" + head + " ans=" + ans);
                    return false;
                }

                List<Integer> children = map.get(head);
                boolean apple = false;
                for (Integer child : children) {
                    if (traverse(child, map, hasApple,visitted)) {
                        apple = true;
                    }
                }

                if (hasApple.get(head) || apple) {
                    //子树里面有苹果，或者当前节点是苹果，则当前节点需要遍历，消耗1
                    ans += 1;
//                    System.out.println("head=" + head + " ans=" + ans);
                    return true;
                }

                return false;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

  //给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最
//少需要多少秒，可以收集到所有苹果，并回到节点 0 。 
//
// 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数
//组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
//false,true,false,true,true,false]
//输出：8 
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
//false,true,false,false,true,false]
//输出：6
//解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
// 
//
// 示例 3： 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
//false,false,false,false,false,false]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai < bi <= n - 1 
// hasApple.length == n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 👍 107 👎 0
