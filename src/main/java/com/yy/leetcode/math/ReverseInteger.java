package com.yy.leetcode.math;

/**
 * @author youyouhuang
 * @create 2019-09-02
 * @desc
 **/


import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        if(x>=1534236469){
            return 0;
        }
        boolean neg = false;
        if(x<0){
            if(Long.compare(-x,2147483648L)>=0){
                return 0;
            }
            x = -x;
            neg = true;
        }

        LinkedList<String> linkedList = new LinkedList<>();
        long result = 0;

            reverse0(x, linkedList);
            for(int k =0;k<linkedList.size();k++){
                result=result+Integer.valueOf(linkedList.get(k)) * (int) Math.pow(10, k);
            }
            if(neg){
                if(Long.compare(-result,2147483648L)>=0){
                    return 0;
                }
                result = -result;
            }
            return (int) result;

    }

    private void reverse0(int x, LinkedList<String> linkedList) {
        int length = String.valueOf(x).length();
        if(length == 1){
            linkedList.add(String.valueOf(x));
            return;
        }
        int pow = (int) Math.pow(10, length - 1);
        int i = x / pow;
        int j = x % pow;
        linkedList.add(String.valueOf(i));
        int pad0 = String.valueOf(pow).length() - String.valueOf(j).length();
        if(pad0 >1){
            for(int m = 0;m<pad0-1;m++) {
                linkedList.add(String.valueOf(0));
            }
        }
        reverse0(j,linkedList);
    }
}
