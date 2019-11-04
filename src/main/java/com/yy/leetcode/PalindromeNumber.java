package com.yy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youyouhuang
 * @create 2019-09-02
 * @desc
 **/

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        List<Integer> numbers = new ArrayList<>();
        convertToString(x, numbers);
        int size = numbers.size();
        int half = size /2;
        for (int i = 0, j = size - 1; i<half; i++, j--) {
            if(!numbers.get(i).equals(numbers.get(j))){
                return false;
            }
        }
        return true;
    }

    public void convertToString(int x, List<Integer> numbers) {
        while(true){
            numbers.add(x%10);
            x=x/10;
            if(x==0) break;
        }
    }
}
