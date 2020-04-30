package com.yy.leetcode.math;
/**
 * @author youyouhuang
 * @create 2020-04-21
 **/

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。  「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。  如果 n 是快乐数就返回 True ；不是，则返回 False 。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/happy-number 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 * 必然是快乐数，因为平方和最大值远小于数字个数，说明有多个数字对应同样的平方和。
 **/
public class HappyNumber {
    //方法一：用集合存储所有计算结果。
    //方法二：快慢指针法
    public boolean isHappy(int n) {
        int slow =squareSum(n), fast = squareSum(slow);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        if(slow == 1){
            return true;
        }
        int c = slow;
        slow = squareSum(slow);
        while (slow!= c){
            slow = squareSum(slow);
            if(slow == 1){
                return true;
            }
        }
        return false;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n >=10) {
            sum += (n % 10)*(n%10);
            n = n/10;
        }
        sum += n * n;
        return sum;
    }
}
