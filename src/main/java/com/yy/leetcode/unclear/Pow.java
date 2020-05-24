package com.yy.leetcode.unclear;
/**
 * @author youyouhuang
 * @create 2020-05-24
 **/

/**
 *实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 **/
public class Pow {

    //快速幂方法
    public double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = -n;
        }
        return quickMul(x,n);
    }

    private double quickMul(double x, int i) {
        if(i == 0){
            return 1;
        }
        double result = quickMul(x,i/2);
        return i % 2 == 0?  result * result: result*result*x;
    }

    public double myPow1(double x, int n) {
        double result = 1;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        while (n-- >0){
            result = result * x;
        }
        return result;
    }
}
