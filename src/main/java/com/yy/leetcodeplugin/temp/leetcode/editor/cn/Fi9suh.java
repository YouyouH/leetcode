  //请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。 
//
// MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里
//的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < end。 
//
// 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。 
//
// 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该
//日程安排添加到日历中。 
//
// 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(
//start, end) 
//
// 
//
// 示例: 
//
// 
//输入:
//["MyCalendar","book","book","book"]
//[[],[10,20],[15,25],[20,30]]
//输出: [null,true,false,true]
//解释: 
//MyCalendar myCalendar = new MyCalendar();
//MyCalendar.book(10, 20); // returns true 
//MyCalendar.book(15, 25); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预
//定了
//MyCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。 
// 0 <= start < end <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 729 题相同： https://leetcode-cn.com/problems/my-calendar-i/ 
// Related Topics 设计 线段树 有序集合 👍 13 👎 0

  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2022-03-05 13:57:17 
//日程表

  import java.util.SortedMap;
  import java.util.TreeMap;

  public class Fi9suh{
    public static void main(String[] args) {

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {

        //key存start,value存end
        private TreeMap<Integer, Integer> sortedMap;
        public MyCalendar() {
            sortedMap = new TreeMap<>();
        }

        //理解floorkey和ceilingkey这两个API:即以传的参数为floor
        public boolean book(int start, int end) {
            //小于等于。 不超过待加入的start的最大值，即在start开始前已经存在的会议
            Integer pre = sortedMap.floorKey(start);
            //大于等于。 大于等于待加入的start的最小值，即在start开始后的下一个会议。
            Integer next = sortedMap.ceilingKey(start);

            if ((pre == null || start >= sortedMap.get(pre)) && (next == null || end <= next)) {
                //start大于上一个会议的结束时间，end小于下一个会议的开始时间
                //pre 和 next可能为null,意味着没有上一个或者下一个会议
                sortedMap.put(start, end);
                return true;
            }
            return false;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}