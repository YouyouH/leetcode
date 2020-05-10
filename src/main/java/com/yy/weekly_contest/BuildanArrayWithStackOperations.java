package com.yy.weekly_contest;
/**
 * @author youyouhuang
 * @create 2020-05-10
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 *
 * </p>
 **/
public class BuildanArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        if(target == null || target.length == 0 ){
            return new LinkedList<>();
        }
        Queue<String> operations = new LinkedList<>();

        int diff = target[0] - 1;
        if (diff == 0) {
            operations.offer("Push");
        } else {
            while (diff-- > 0) {
                operations.offer("Push");
                operations.offer("Pop");
            }
            operations.offer("Push");
        }

        for (int i = 1; i < target.length; i++) {
            int change = target[i] - target[i - 1];
            if (--change == 0) {
                operations.offer("Push");
                continue;
            } else {
                while (change-- > 0) {
                    operations.offer("Push");
                    operations.offer("Pop");
                }
            }
            operations.offer("Push");
        }

        return new ArrayList<>(operations);
    }

}
