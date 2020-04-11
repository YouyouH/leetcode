package com.yy.leetcode.bitmanipulation;
/**
 * @author youyouhuang
 * @create 2020-04-10
 **/

/**
 * <p>给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p> 示例 1:
 * <p> 输入: 2
 * <p> 输出: [0,1,1]
 * <p> 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/counting-bits
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * </p>
 **/
public class CountingBits {
    public int[] countBits(int num) {
        if(num<0){
            return new int[]{0};
        }
        int[] results = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int number = i;
            while (number > 0) {
                int mod = number % 2;
                if(mod == 1) results[i]++;
                number = number / 2;
            }
            if(number % 2 == 1) results[i]++;
        }
        return results;
    }
}
