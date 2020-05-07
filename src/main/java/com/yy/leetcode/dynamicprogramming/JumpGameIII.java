package com.yy.leetcode.dynamicprogramming;
/**
 * @author youyouhuang
 * @create 2020-04-19
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-iii 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class JumpGameIII {
    //bfs+visited
    public boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0 || start >= arr.length){
            return false;
        }
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        boolean result = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer pos = queue.poll();
                if(arr[pos] == 0){
                    result = true;
                    break;
                }
                int right = pos + arr[pos];
                if (right < arr.length && !visited[right]) {
                    queue.offer(right);
                    visited[right] = true;
                }
                int left = pos - arr[pos];
                if (left >= 0 && !visited[left]) {
                    queue.offer(left);
                    visited[left] = true;
                }
            }
        }
        return result;
    }
}
