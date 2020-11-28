package com.yy.leetcode.dfs;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangyou
 */
public class GasStation {
    /**
     * 方法一:遍历所有起点,暴力解法
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int leftGas = gas[i];
            for (int j = i + 1; j < length; j++) {
                leftGas -= cost[j - 1];
                if (leftGas < 0) break;
                leftGas += gas[j];
            }
            leftGas -= cost[length - 1];
            if (leftGas < 0) continue;
            leftGas += gas[0];
            for (int j = 1; j <= i; j++) {
                leftGas -= cost[j - 1];
                if (leftGas < 0) break;
                leftGas += gas[j];
            }
            if (leftGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二:每次从下一个达不到的车站开始出发
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int length = gas.length;
        int initStart = 0;
        int totalCount = 0;
        while (initStart < length && totalCount < length) {
            totalCount++;
            int leftGas = gas[initStart];

            int start = initStart;
            int count = 0;
            while (count <= length) {
                count++;
                leftGas -= cost[start];
                if (leftGas < 0) {
                    initStart = start+1;
                    break;
                }
                start = (start + 1) % length;
                leftGas += gas[start];
                if(start == initStart){
                    return start;
                }
            }

        }
        return -1;
    }
}
