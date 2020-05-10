package com.yy.leetcode.unclear;
/**
 * @author youyouhuang
 * @create 2020-05-10
 **/

/**
 *假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。  这儿有一份乘客行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了第 i 组乘客的行程信息：      必须接送的乘客数量；     乘客的上车地点；     以及乘客的下车地点。  这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。  请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/car-pooling 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        //求出多少站
        int length = 0;
        for (int[] trip : trips) {
            length = Math.max(length,trip[2]);
        }
        int[] passengers = new int[length];

        for (int i = 0; i < trips.length; i++) {
            int count = trips[i][0];
            int onStation = trips[i][1];
            int offStation = trips[i][2];
            for (int j = onStation-1; j < offStation ; j++) {
                passengers[j] += count;
            }
            passengers[offStation-1] -= count;
        }

        for (int passenger : passengers) {
            if(passenger > capacity){
                return false;
            }
        }
        return true;
    }
}
