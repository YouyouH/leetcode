package com.yy.leetcode.doublepointers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author youyouhuang
 * @create 2019-11-05
 * @desc https://leetcode.com/problems/trapping-rain-water/
 **/

/**
 * Wrong!!!
 */

public class Incorrect_TrappingRainWater {

    public int trap(int[] height) {
        if(height == null){
            return 0;
        }
        int sum = 0;
        int length = height.length;
        int[] newHeight = new int[length + 2];
        newHeight[0] = 0;
        newHeight[length + 1] = 0;

        for (int i = 1; i < length+1; i++) {
            newHeight[i] = height[i-1];
        }

        Map<Integer,Integer> pos2value = new HashMap<>();
        int top = 0;
        for(int i= 1; i< newHeight.length-1; i++){
            int current = newHeight[i];
            if(current >newHeight[i-1] && current >newHeight[i+1]){
                    pos2value.put(i , current);
                    if(current > top){
                        top = current;
                    }
            }
        }

        mergeTopPonits(pos2value, top);
        if(pos2value.size()<2){
            return 0;
        }



        Iterator<Map.Entry<Integer, Integer>> iterator = pos2value.entrySet().iterator();
        //must large than 2
        Map.Entry<Integer, Integer> top2 =null;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> top1 = null;
            if(null == top2) {
                top1 = iterator.next();
            }else {
                top1 = top2;
            }

            top2 = iterator.next();
            Integer top1value = top1.getValue();
            Integer top1pos = top1.getKey();
            Integer top2value = top2.getValue();
            Integer top2pos = top2.getKey();

            if(top1value > top2value){
                for(int i = top2pos-1; i>top1pos; i--){
                    if(newHeight[i] > top2value){
                        top1value = newHeight[i];
                        top1pos = i;
                        break;
                    }
                }
            }

            int width = top2pos - top1pos -1;
            int high = Math.min(top1value,top2value);

            int black = 0;
            for(int i = top1pos +1; i<top2pos; i++){
                black = black + newHeight[i];
            }
            int tmpSum = width * high - black;
            sum = sum + tmpSum;
        }
        return sum;
    }

    private void mergeTopPonits(Map<Integer, Integer> pos2value, int top) {
        Map<Integer, Integer> topPos2value = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : pos2value.entrySet()) {
            Integer value = entry.getValue();
            if(value == top){
                topPos2value.put(entry.getKey(), value);
            }
        }
        topPos2value.keySet();


    }
}
