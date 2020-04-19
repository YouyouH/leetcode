package com.yy.leetcode.competition;
/**
 * @author youyouhuang
 * @create 2020-04-18
 **/

import java.util.*;

/**
 * https://leetcode-cn.com/contest/season/2020-spring/problems/chuan-di-xin-xi-UGC/
 * <p>
 *
 * </p>
 **/
public class SendMessage {
    public int numWays(int n, int[][] relation, int k) {
        if (relation == null || relation.length == 0 || n <= 0 || k == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> mapping = convertToMap(relation);

        int hoop = 1;
        List<Integer> integers = mapping.get(0);
        if (k == 1) {
            if (integers.contains(n - 1)) {
                return 1;
            } else {
                return 0;
            }
        }
        queue.addAll(integers);
        while (hoop < k - 1) {
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                Integer next = queue.poll();
                if (mapping.get(next) == null || mapping.get(next).isEmpty()) {
                    continue;
                }
                temp.addAll(mapping.get(next));
            }
            queue.addAll(temp);
            hoop++;
        }
        int result = 0;
        for (Integer integer : queue) {
            if (integer == n - 1) {
                continue;
            } else {
                if (mapping.get(integer) != null && mapping.get(integer).contains(n - 1)) {
                    result++;
                }
            }
        }
        return result;
    }

    private Map convertToMap(int[][] relation) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            List<Integer> key = map.get(relation[i][0]);
            if (key == null) {
                List<Integer> list = new ArrayList<>();
                list.add(relation[i][1]);
                map.put(relation[i][0], list);
            } else {
                key.add(relation[i][1]);
            }
        }
        return map;
    }
}
