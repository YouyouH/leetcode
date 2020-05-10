package com.yy.leetcode.jianzhioffer;
/**
 * @author youyouhuang
 * @create 2020-05-10
 **/

/**
 *给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。  你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。  如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/living-people-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class LivingPeopleLCCI {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] years = new int[101];
        int max = 0;
        for (int i = 0; i < birth.length; i++) {
            for (int j = birth[i] -1900; j < death[i]-1900+1; j++) {
                years[j]++;
                max = Math.max(max,years[j]);
            }
        }
        for (int i = 0; i < years.length; i++) {
            if(years[i] == max){
                return i+1900;
            }
        }
        return 0;
    }
}
