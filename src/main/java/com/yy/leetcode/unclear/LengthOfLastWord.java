package com.yy.leetcode.unclear;

import java.util.Arrays;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        Integer[] array = new Integer[s.length()];
        Arrays.fill(array, 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (' ' != (c)) {
                array[i] = 1;
            }
        }
        int start = -1;
        int end = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if(end == -1 && array[i] == 1){
                end = i;
                break;
            }
        }

        for (int i = end; i >= 0; i--) {
            if(array[i] == 1){
                continue;
            }
            start = i;
            break;
        }

        if(end == -1){
            return 0;
        }

        if(start == 0){
            if(array[start] == 1){
                return end +1;
            }else{
                return end;
            }
        }
        return end - start ;
    }
}
