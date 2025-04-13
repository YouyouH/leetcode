
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-04-13 21:22:37 
//最近的请求次数

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls{
    public static void main(String[] args) {

    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class RecentCounter {
            /**
             * FIXME 看的答案，由于t是递增的，所以用一个queue保留3000范围内的请求即可
             *
             *   还可以用二分法求
             */
            private Deque<Integer> deque;

            public RecentCounter() {
                deque = new ArrayDeque<>();
            }

            public int ping(int t) {
                deque.offer(t);
                //删除区间外的请求，因为t是递增的
                while (deque.peek() < t - 3000) {
                    deque.pop();
                }
                return deque.size();
            }
        }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

  //写一个 RecentCounter 类来计算特定时间范围内最近的请求。 
//
// 请你实现 RecentCounter 类： 
//
// 
// RecentCounter() 初始化计数器，请求数为 0 。 
// int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求
//）。确切地说，返回在 [t-3000, t] 内发生的请求数。 
// 
//
// 保证 每次对 ping 的调用都使用比之前更大的 t 值。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//输出：
//[null, 1, 2, 3, 3]
//
//解释：
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
//recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
//recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
//recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 
//3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= t <= 10⁹ 
// 保证每次对 ping 调用所使用的 t 值都 严格递增 
// 至多调用 ping 方法 10⁴ 次 
// 
//
// Related Topics 设计 队列 数据流 👍 273 👎 0
