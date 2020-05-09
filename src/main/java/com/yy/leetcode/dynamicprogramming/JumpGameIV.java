package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-19
 **/


import java.util.*;

/**
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * 每一步，你可以从下标 i 跳到下标：
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * 注意：任何时候你都不能跳到数组外面。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-iv 著
 * 作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class JumpGameIV {

    //多源BFS
    public int minJumps(int[] arr) {
        if(arr==null || arr.length <= 1){
            return 0;
        }
        Map<Integer, Set<Integer>> value2Index = new HashMap<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            value2Index.computeIfAbsent(arr[i], key -> new HashSet<>()).add(i);
        }
        //store index
        Queue<Integer> reached = new LinkedList<>();
        reached.offer(length - 1);
        int steps = 0;
        boolean[] visitted = new boolean[arr.length];
        visitted[length - 1] = true;
        while (!reached.isEmpty()) {
            int size = reached.size();
            steps++;
            Queue<Integer> temp = new LinkedList<>();
            while (size-- > 0) {
                Integer pos = reached.poll();
                Set<Integer> sameValues = value2Index.get(arr[pos]);
                if (sameValues != null && sameValues.size() > 0) {
                    sameValues.remove(pos);
                    temp.addAll(sameValues);
                    for (Integer sameValue : sameValues) {
                        if(sameValue == 0){
                            return steps;
                        }
                        visitted[sameValue] = true;
                    }
                    sameValues.clear();

                }
                int left = pos - 1;
                if (left >= 0 && !visitted[left]) {
                    if(left == 0){
                        return steps;
                    }
                    temp.add(left);
                    visitted[left] = true;
                }
                int right = pos + 1;
                if (right < length && !visitted[right]) {
                    temp.add(right);
                    visitted[right] = true;
                }
            }
            reached.addAll(temp);
        }
        return steps;

    }
}
