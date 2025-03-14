
  
package com.yy.leetcodeplugin.temp.leetcode.editor.cn;

//2025-03-14 16:25:12 
//数组中的最长山脉

public class LongestMountainInArray{
    public static void main(String[] args) {
         Solution solution = new LongestMountainInArray().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] arr) {
        /**
         * 双指针。
         *  1。起点开始遇到相同的数先跳过
         */

        if (arr.length < 3) {
            return 0;
        }

        int res = 0;
        int l = 0;
        int r = 0;

        while (r < arr.length) {
            //先跳过相同的数
            while (l+1 < arr.length && arr[l] == arr[l + 1]) {
                l++;
            }
            if (l > arr.length - 3) {
                break;
            }
            //此时l处于起点,重新确定r
//            System.out.println("左=" + l);
            r = l;
            while (r+1 < arr.length && arr[r+1] > arr[r]) {
                r++;
            }
            if (r == l) {
                //不是山脉，重新确定起点
//                System.out.println("不是上坡，重新确定起点");
                l++;
                continue;
            }
            //此时r处于山顶
            int top = r;
//            System.out.println("山顶=" + r);
            while (r + 1 < arr.length && arr[r] > arr[r + 1]) {
                r++;
            }
            if (r == top) {
                //山顶后面不是下坡(那肯定横着的，如果是上坡那山顶不会停在这里)，重新确定起点
//                System.out.println("不是下坡，重新确定起点");
                l = r+1;
                continue;
            }

            //此时r处于山脚，计算山脉长度
            if (r - l + 1 > res) {
                res = r - l + 1;
            }
//            System.out.println("右=" + r);

            //重新开始,前一个的山脚可以当下一个山脉的起点
            l = r;
            if (l > arr.length - 3) {
                break;
            }

        }

        return res;

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

  //把符合下列属性的数组 arr 称为 山脉数组 ： 
//
// 
// arr.length >= 3 
// 存在下标 i（0 < i < arr.length - 1），满足 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1,4,7,3,2,5]
//输出：5
//解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,2,2]
//输出：0
//解释：不存在山脉子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以仅用一趟扫描解决此问题吗？ 
// 你可以用 O(1) 空间解决此问题吗？ 
// 
//
// Related Topics 数组 双指针 动态规划 枚举 👍 298 👎 0
